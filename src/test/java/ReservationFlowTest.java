import car.rental.dao.InventoryDao;
import car.rental.dao.InventoryDaoImpl;
import car.rental.dao.ReservationDao;
import car.rental.dao.ReservationDaoImpl;
import car.rental.exceptions.ExistingReservationException;
import car.rental.model.*;
import car.rental.service.BookingService;
import car.rental.service.BookingServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by erroh on 1/14/2019.
 */

public class ReservationFlowTest {

    BookingService bookingService ;

    // Doing it only for the testing purposes, this will be moved to a DAO call
    public List<Reservation> getReservations(){

        List<Reservation> existingReservations = new ArrayList<>();

        Customer cust1 = new Customer( 123, "John","Doe" );
        Customer cust2 = new Customer( 243, "David","Hunt" );


        // Create dummy cars
        Car car = new Car( CarType.SEDAN, new CarDescription( "Honda","Accord",2015,5 ));
        Car car2 = new Car( CarType.SEDAN, new CarDescription( "Ford","Fusion",2015,5 ));
        Car car3 = new Car( CarType.SEDAN, new CarDescription( "Toyota","Camry",2015,5 ));
        Car car4 = new Car( CarType.MINIVAN, new CarDescription( "Toyota","Sienna",2015,9 ));

        DateRange dateRange1 = new DateRange( LocalDate.now().plusDays(2),LocalDate.now().plusDays( 5 ));
        DateRange dateRange2 = new DateRange( LocalDate.now().plusDays(7),LocalDate.now().plusDays( 10 ));

        Reservation reservation1 = new Reservation( cust1,car,dateRange1 );
        Reservation reservation2 = new Reservation( cust1,car,dateRange2 );


        existingReservations.add( reservation1 );
        existingReservations.add( reservation2 );

        return existingReservations;
    }


    public static List<Car> getAvailableInventory(){

        List<Car> cars = new ArrayList<>();

        // lookup the inventory
        Car car = new Car( CarType.SEDAN, new CarDescription( "Honda","Accord",2015,5 ));
        Car car2 = new Car( CarType.SEDAN, new CarDescription( "Ford","Fusion",2015,5 ));
        Car car3 = new Car( CarType.SEDAN, new CarDescription( "Toyota","Camry",2015,5 ));
        Car car4 = new Car( CarType.MINIVAN, new CarDescription( "Toyota","Sienna",2015,9 ));

        cars.add(car);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        return cars;
    }


    @BeforeClass
    public static void initializeClassParams(){
    //      MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReservationFlow() throws ExistingReservationException {

        Customer cust1 = new Customer( 75, "Good","Fellow" );
        DateRange dr = new DateRange( LocalDate.now(),LocalDate.now().plusDays( 7 ));
        DateRange nonOverlappingDateRange = new DateRange( LocalDate.now().plusDays(11),LocalDate.now().plusDays( 15 ));

        InventoryDao inventoryDaoMock = mock( InventoryDao.class);
        ReservationDao reservationDaoMock = Mockito.mock( ReservationDao.class );

        when( inventoryDaoMock.loadAvailableCars( dr )).thenReturn( getAvailableInventory());

        // Customer searches the inventory of cars.
        List<Car> cars = inventoryDaoMock.loadAvailableCars( dr );

        when( reservationDaoMock.loadExistingReservations( cars.get(0) )).thenReturn( getReservations());
        when( reservationDaoMock.addNewReservation( any( Reservation.class ))).thenReturn( TRUE );

        // Optimistic Flow.


        // Customer selects a car and new reservation for time period is requested
        bookingService = new BookingServiceImpl( reservationDaoMock );

        assert( bookingService.makeReservation( cust1 , cars.get(0), nonOverlappingDateRange ) == TRUE );

        }

    @Test
    public void testOverlappingReservationScenario() throws ExistingReservationException {

        Customer cust1 = new Customer( 75, "David","Hunt" );
        DateRange dr = new DateRange( LocalDate.now(),LocalDate.now().plusDays( 7 ));
        //DateRange nonOverlappingDateRange = new DateRange( LocalDate.now().plusDays(11),LocalDate.now().plusDays( 15 ));
        DateRange OverlappingDateRange = new DateRange( LocalDate.now().plusDays(7),LocalDate.now().plusDays( 10 ));

        InventoryDao inventoryDaoMock = mock( InventoryDao.class);
        ReservationDao reservationDaoMock = Mockito.mock( ReservationDao.class );

        when( inventoryDaoMock.loadAvailableCars( any( DateRange.class))).thenReturn( getAvailableInventory());

        when( reservationDaoMock.loadExistingReservations( any( Car.class))).thenReturn( getReservations());
        when( reservationDaoMock.addNewReservation( any( Reservation.class ))).thenReturn( TRUE );

        // Customer searches the inventory of cars.
        List<Car> cars = inventoryDaoMock.loadAvailableCars( dr );

        // Customer selects a car and new reservation for time period is requested
        bookingService = new BookingServiceImpl( reservationDaoMock );

        try {
            bookingService.makeReservation(cust1, cars.get(0), OverlappingDateRange);
        }
        catch( ExistingReservationException ex )
        {
            assert( TRUE);
        }
    }


    @AfterClass
    public static void tearDownClasses(){

    }
}

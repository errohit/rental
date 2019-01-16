package car.rental.service;

import car.rental.dao.ReservationDao;
import car.rental.dao.ReservationDaoImpl;
import car.rental.exceptions.ExistingReservationException;
import car.rental.model.*;

import java.util.List;

/**
 * Created by erroh on 12/15/2018.
 *
 * Service class for making reseravtions.
 */
public class BookingServiceImpl implements BookingService {


    private ReservationDao reservationDaoImpl;

    public BookingServiceImpl( ReservationDao reservationDaoImpl ){
        this.reservationDaoImpl = reservationDaoImpl;
    }

    @Override
    public Boolean makeReservation(Customer cust , Car car, DateRange dateRange) throws ExistingReservationException {

        // load existing reservations for the car specified.
        List<Reservation> reservations = reservationDaoImpl.loadExistingReservations(car);

        // Check for any overlap with existing reservation before creating a reservation.
        for (Reservation reservation : reservations) {
            if (!(DateRange.checkForOverlap(reservation.getDateRange(), dateRange)))
                throw new ExistingReservationException("Request Overlapping with existing reservation");
        }

        Reservation newReservation = new Reservation( cust,car,dateRange);

        // Add the modified entry in the db reservations table.
        return reservationDaoImpl.addNewReservation( newReservation );
    }
}

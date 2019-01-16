package car.rental.dao;

import car.rental.model.Car;
import car.rental.model.CarType;
import car.rental.model.DateRange;
import car.rental.model.Reservation;

import java.util.List;

/**
 * Created by erroh on 1/8/2019.
 *
 * Reservation db interaction methods.
 */
public interface ReservationDao {

    // used for getting the existing reservations for a car.
    List<Reservation> loadExistingReservations(Car car );
   

    Boolean addNewReservation( Reservation reservation ); // This needs transactional check for concurrent writes

    Boolean cancelReservation( Reservation reservation ); // Cancel the existing reservation.

}

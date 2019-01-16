package car.rental.dao;

import car.rental.model.Car;
import car.rental.model.CarType;
import car.rental.model.DateRange;
import car.rental.model.Reservation;

import java.util.List;

/**
 * Created by erroh on 1/9/2019.
 */
public class ReservationDaoImpl implements ReservationDao {

    @Override
    public List<Reservation> loadExistingReservations(Car car) {
        return null;
    }

    @Override
    public Boolean addNewReservation(Reservation reservations) {
        return null;
    }

    @Override
    public Boolean cancelReservation(Reservation reservation) {
        return null;
    }
}

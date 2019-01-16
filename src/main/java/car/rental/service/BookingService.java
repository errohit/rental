package car.rental.service;

import car.rental.exceptions.ExistingReservationException;
import car.rental.model.Car;
import car.rental.model.Customer;
import car.rental.model.DateRange;

/**
 * Created by erroh on 12/15/2018.
 *
 * Service class for making reseravtions.
 */
public interface BookingService {

    Boolean makeReservation(Customer cust, Car car, DateRange dateRange ) throws ExistingReservationException;

}

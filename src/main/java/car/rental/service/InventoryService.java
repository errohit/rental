package car.rental.service;

import car.rental.model.Car;
import car.rental.model.CarType;
import car.rental.model.DateRange;

import java.util.List;

/**
 * Created by erroh on 1/14/2019.
 *
 *  Service class for inventory look ups etc.0
 */
public interface InventoryService {

    List<Car> searchForCar(CarType carType, DateRange dateRange );

    List<Car> searchForCarsInDateRange(  DateRange dateRange );

}

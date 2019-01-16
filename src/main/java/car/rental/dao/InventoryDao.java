package car.rental.dao;

import car.rental.model.Car;
import car.rental.model.CarType;
import car.rental.model.DateRange;

import java.util.List;

/**
 * Created by erroh on 1/14/2019.
 *
 * Methods for loading inventory of cars available.
 */
public interface InventoryDao {

    // Search for Inventory of cars.

    // search func to get available cars in a date range.
    List<Car> loadAvailableCars(DateRange dateRange );

    // search func to get available cars in a date range.
    List<Car> loadAvailableCarsForCarType(CarType carType, DateRange dateRange );


}

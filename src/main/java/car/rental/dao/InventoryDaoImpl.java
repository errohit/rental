package car.rental.dao;

import car.rental.model.Car;
import car.rental.model.CarType;
import car.rental.model.DateRange;

import java.util.List;

/**
 * Created by erroh on 1/14/2019.
 */
public class InventoryDaoImpl implements InventoryDao {


    @Override
    public List<Car> loadAvailableCars(DateRange dateRange) {
        return null;
    }

    @Override
    public List<Car> loadAvailableCarsForCarType(CarType carType, DateRange dateRange) {
        return null;
    }
}

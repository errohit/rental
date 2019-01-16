package car.rental.service;

import car.rental.dao.ReservationDao;
import car.rental.dao.ReservationDaoImpl;
import car.rental.model.Car;
import car.rental.model.CarType;
import car.rental.model.DateRange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erroh on 1/14/2019.
 */
public class InventoryServiceImpl implements InventoryService {

    @Override
    public List<Car> searchForCar(CarType carType, DateRange dateRange) {
      // Assuming the params are already validated in the front end.
        return new ArrayList<Car>();
    }

    @Override
    public List<Car> searchForCarsInDateRange(  DateRange dateRange ) {

        return new ArrayList<Car>();
    }

}

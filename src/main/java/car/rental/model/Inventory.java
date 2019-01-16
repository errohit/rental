package car.rental.model;

import car.rental.model.Car;
import car.rental.model.CarDescription;
import car.rental.model.CarType;
import car.rental.model.DateRange;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by erroh on 12/15/2018.
 */
public class Inventory {

   private Map<Car, List<DateRange>> inventoryAtHand;

    public Map<Car, List<DateRange>> getInventoryAtHand() {
        return inventoryAtHand;
    }

    public void setInventoryAtHand( Map<Car, List<DateRange>> inventoryAtHand ) {
        this.inventoryAtHand = inventoryAtHand;
    }
}

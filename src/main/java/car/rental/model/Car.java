package car.rental.model;

import car.rental.helper.SequenceGenerator;

import java.util.UUID;

/**
 * Created by erroh on 12/15/2018.
 */
public class Car {

    private Integer carId; // Using this as database identifier
    private final CarType carType;
    private final CarDescription carDescription;

    public CarType getCarType() {
        return carType;
    }

    public CarDescription getCarDescription() {
        return carDescription;
    }

    public Car(CarType carType, CarDescription carDescription) {
        this.carId = SequenceGenerator.getNextInt();
        this.carType = carType;
        this.carDescription = carDescription;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!carId.equals(car.carId)) return false;
        if (carType != car.carType) return false;
        return carDescription != null ? carDescription.equals(car.carDescription) : car.carDescription == null;
    }

    @Override
    public int hashCode() {
        int result = carId.hashCode();
        result = 31 * result + carType.hashCode();
        return result;
    }
}

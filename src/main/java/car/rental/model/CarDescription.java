package car.rental.model;

/**
 * Created by erroh on 12/15/2018.
 */

public class CarDescription {

    private String make;

    private Integer year;
    private String model;

    private Integer SeatingCapacity;

    public CarDescription(String make, String model, int year, int seatingCapacity) {
        this.make = make;
        this.year = year;
        this.model = model;
        SeatingCapacity = seatingCapacity;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeatingCapacity() {
        return SeatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        SeatingCapacity = seatingCapacity;
    }
}

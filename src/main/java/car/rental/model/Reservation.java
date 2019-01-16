package car.rental.model;

/**
 * Created by erroh on 12/16/2018.
 */
public class Reservation {

    private Customer customer;

    private Car car;

    private DateRange dateRange;

    public Reservation(Customer customer, Car car, DateRange dateRange) {
        this.customer = customer;
        this.car = car;
        this.dateRange = dateRange;
    }

//    public void addBooking( Customer customer, Car, DateRange dateRange ) throws ExistingReservationException {
//
//        // sort for the existing date range
//        this.dateRange.sort( (Comparator.comparing(o -> o.getFromDate())));
//
//        // check for an overlap and throw an exception if there is one
//        // we can make it faster given the date range array is sorted.
//
//        for ( DateRange d1 : this.dateRange ){
//
//            if( !(DateRange.checkForOverlap( d1,dateRange ))) {
//                throw new ExistingReservationException("Existing booking found for date range");
//            }
//        }
//
//        // insert if there is no overlap
//        this.dateRange.add( dateRange );
//    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public DateRange getDateRange() {
        return dateRange;
    }

    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "car=" + car +
                ", dateRange=" + dateRange +
                '}';
    }
}

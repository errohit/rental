package car.rental.exceptions;

/**
 * Created by erroh on 1/8/2019.
 */
public class ExistingReservationException extends Exception {

    public ExistingReservationException(String message) {
        super(message);
    }

    public ExistingReservationException() {
    }
}

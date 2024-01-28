package car.rental.model;

import java.time.LocalDate;

/**
 * Created by erroh on 12/15/2018.
 */
public class DateRange{

    private LocalDate fromDate;
    private LocalDate toDate;

    public DateRange(LocalDate fromDate, LocalDate toDate) {
        if( fromDate.compareTo(toDate ) > 0 )
            throw new IllegalArgumentException( "Invalid Date Range" );

        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    // Checks for overlap between 2 dateRanges provided
    // True if there is no overlap
    // False if there is an overlap.
    public static Boolean checkForOverlap( DateRange d1 , DateRange d2 ){

        if( ( d1.getFromDate().compareTo(d2.getToDate()) < 0 ) && ( d1.getToDate().compareTo( d2.getFromDate()) < 0 )
            || ( d1.getFromDate().compareTo(d2.getToDate()) > 0 ) && ( d1.getToDate().compareTo( d2.getFromDate()) > 0 )
        )
            return true;
        else
            return false;
    }
}

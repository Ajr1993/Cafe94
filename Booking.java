import java.util.ArrayList;
import java.util.List;

public class Booking {
    private int id;
    private int guestCount;
    private int tableId;
    private int startTimeDate;
    private int endTimeDate;
    private int startDate;
    private boolean approvedBy;
    private boolean status;
    private boolean cancel;
    private boolean deny;
    private int approveStaffId;

    // Create a bookings list
    private List<Booking> bookings;


    public Booking(int id, int guestCount, int tableId, int startTimeDate, int endTimeDate) {
        this.id = id;
        this.guestCount = guestCount;
        this.tableId = tableId;
        this.startTimeDate = startTimeDate;
        this.endTimeDate = endTimeDate;
        this.bookings = new ArrayList<>(); // Correct initialization
    }

    public int getId() {
        return this.id;
    }
    // method that lets you add a booking if request is not null
    public boolean requestBooking(Booking request) {
        if (request == null) {
            return false;
        }
        bookings.add(request);
        return true;
    }

    // method to cancel a booking
    public boolean cancelBooking(Booking cancel) {
        for (int i = 0; i < bookings.size(); i++) { // loops through the list of bookings
            Booking currentBooking = bookings.get(i); // retrives a booking from the variable currentBooking
            if (currentBooking.getId() == cancel.getId()) { // if current booking id is same as the cancel remove it
                bookings.remove(i);
                return true; //
            }
        }
        return false; // Booking to cancel was not found
    }

    public static void main(String[] args) {
        // Create a new booking
        Booking one = new Booking(1, 4, 101, 10, 12); // Correct constructor usage

        // Request a booking
        boolean complete = one.requestBooking(one); // Should work as expected
        System.out.println("Booking request successful: " + success);

        // Cancel the booking
        boolean cancelled = one.cancelBooking(one); // Should cancel the booking
        System.out.println("Booking canceled: " + cancelled);
    }
}
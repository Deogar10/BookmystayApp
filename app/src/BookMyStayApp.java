import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Main Class (UC2)
public class BookMyStayApp {

    public static void main(String[] args) {

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("===== Room Details & Availability =====\n");

        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailable);
        System.out.println("--------------------------------------");

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable);
        System.out.println("--------------------------------------");

        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
        System.out.println("--------------------------------------");

        System.out.println("\nApplication Terminated.");


        RoomInventory inventory = new RoomInventory();

        System.out.println("===== Centralized Room Inventory =====\n");

        single.displayRoomDetails();
        System.out.println("Available: " + inventory.getAvailability(single.getRoomType()));
        System.out.println("--------------------------------------");

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + inventory.getAvailability(doubleRoom.getRoomType()));
        System.out.println("--------------------------------------");

        suite.displayRoomDetails();
        System.out.println("Available: " + inventory.getAvailability(suite.getRoomType()));
        System.out.println("--------------------------------------");
        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom());
        rooms.add(new DoubleRoom());
        rooms.add(new SuiteRoom());

        // Use RoomInventory from UC3

        RoomSearchService service = new RoomSearchService();

        service.searchRooms(rooms, inventory);
        BookingRequestQueue queue = new BookingRequestQueue();

        // Adding requests (arrival order)
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Double"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Process queue
        queue.processRequests();
        service.processBookings(queue, inventory);

    }
}

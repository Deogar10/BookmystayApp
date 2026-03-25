import java.util.*;

// Search Service
class RoomSearchService {

    public void searchRooms(List<Room> rooms, RoomInventory inventory) {

        System.out.println("===== Room Search Results =====\n");

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getRoomType());

            // Show only rooms with availability
            if (available > 0) {
                room.displayRoomDetails();
                System.out.println("Available: " + available);
                System.out.println("--------------------------------------");
            }
        }
    }

    public void processBookings(BookingRequestQueue queue, RoomInventory inventory) {
    }
}

import java.util.*;

class RoomAllocationService {

    private final Set<String> allocatedRooms = new HashSet<>();
    private Map<String, Set<String>> roomMap = new HashMap<>();
    private Map<String, Integer> counters = new HashMap<>();

    public RoomAllocationService() {
        counters.put("Single", 0);
        counters.put("Double", 0);
        counters.put("Suite", 0);
    }

    public void processBookings(Queue<Reservation> queue, RoomInventory inventory) {

        System.out.println("Room Allocation Processing");

        while (!queue.isEmpty()) {

            Reservation r = queue.poll();
            String type = r.getRoomType();

            if (inventory.getAvailability(type) > 0) {

                // Generate unique room ID
                int count = counters.get(type) + 1;
                counters.put(type, count);

                String roomId = type + "-" + count;

                // Ensure uniqueness
                if (!allocatedRooms.contains(roomId)) {

                    allocatedRooms.add(roomId);

                    roomMap.putIfAbsent(type, new HashSet<>());
                    roomMap.get(type).add(roomId);

                    // Update inventory immediately
                    inventory.decrement(type);

                    System.out.println(
                            "Booking confirmed for Guest: " +
                                    r.getGuestName() +
                                    ", Room ID: " + roomId
                    );
                }

            } else {
                System.out.println(
                        "Booking failed for Guest: " +
                                r.getGuestName() +
                                " (No rooms available)"
                );
            }
        }
    }
}
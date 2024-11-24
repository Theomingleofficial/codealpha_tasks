import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String type;
    boolean isAvailable;

    public Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + type + ") - " + (isAvailable ? "Available" : "Booked");
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        ArrayList<Room> rooms = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Add sample rooms
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));

        System.out.println("Welcome to the Hotel Reservation System!");

        while (true) {
            System.out.println("\n1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Room List:");
                    for (Room room : rooms) {
                        System.out.println(room);
                    }
                }
                case 2 -> {
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    boolean found = false;

                    for (Room room : rooms) {
                        if (room.roomNumber == roomNumber) {
                            if (room.isAvailable) {
                                room.isAvailable = false;
                                System.out.println("Room " + roomNumber + " booked successfully!");
                            } else {
                                System.out.println("Room " + roomNumber + " is already booked.");
                            }
                            found = true;
                            break;
                        }
                    }

                    if (!found) System.out.println("Invalid room number.");
                }
                case 3 -> {
                    System.out.println("Exiting. Thank you for using the system!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

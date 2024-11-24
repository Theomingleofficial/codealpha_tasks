import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    String name;
    String date;

    public Destination(String name, String date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Date: " + date;
    }
}

public class TravelPlanner {
    public static void main(String[] args) {
        ArrayList<Destination> itinerary = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (true) {
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter destination name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter travel date (e.g., 2024-11-25): ");
                    String date = scanner.nextLine();
                    itinerary.add(new Destination(name, date));
                    System.out.println("Destination added!");
                }
                case 2 -> {
                    System.out.println("Your Itinerary:");
                    for (Destination d : itinerary) {
                        System.out.println(d);
                    }
                }
                case 3 -> {
                    System.out.println("Exiting. Have a great trip!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

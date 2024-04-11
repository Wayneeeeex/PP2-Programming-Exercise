import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VehicleManagement {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    listVehicles();
                    break;
                case 3:
                    deleteVehicle();
                    break;
                case 4:
                    sortVehiclesMenu();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        } while (choice != 5);
    }

    private static void printMenu() {
        System.out.println("\nVehicle Management System");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Display List of Vehicles");
        System.out.println("3. Delete Vehicle");
        System.out.println("4. Sort Vehicle List by Age");
        System.out.println("5. Quit\n");
    }

    private static void addVehicle() {
        System.out.print("Enter registration number: ");
        String regNo = scanner.next();
        System.out.print("Enter make: ");
        String make = scanner.next();
        System.out.print("Enter year of manufacture: ");
        int yearOfManufacture = scanner.nextInt();
        System.out.print("Enter value: ");
        double value = scanner.nextDouble();

        Vehicle vehicle = new Vehicle(regNo, make, yearOfManufacture, value);
        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully!\n");
    }

    private static void listVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found!\n");
        } else {
            System.out.println("Vehicles:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
            System.out.println();
        }
    }

    private static void deleteVehicle() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found!\n");
        } else {
            System.out.println("Vehicles:");
            for (int i = 0; i < vehicles.size(); i++) {
                System.out.println((i + 1) + ". " + vehicles.get(i));
            }
            System.out.print("Enter the index of the vehicle to delete: ");
            int index = scanner.nextInt() - 1; // Adjust for zero-based indexing

            if (index >= 0 && index < vehicles.size()) {
                System.out.print("Are you sure you want to delete (y/n)? ");
                char confirmation = scanner.next().charAt(0);
                if (confirmation == 'y' || confirmation == 'Y') {
                    vehicles.remove(index);
                    System.out.println("Vehicle deleted successfully!\n");
                } else {
                    System.out.println("Deletion cancelled.\n");
                }
            } else {
                System.out.println("Invalid index!\n");
            }
        }
    }

    private static void sortVehiclesMenu() {
        int sortChoice;

        do {
            System.out.println("\nSort Menu:");
            System.out.println("1. Sort by age (ascending)");
            System.out.println("2. Sort by age (descending)");
            System.out.println("3. Back to main menu");
            System.out.print("Enter your choice: ");
            sortChoice = scanner.nextInt();

            switch (sortChoice) {
                case 1:
                    Collections.sort(vehicles, (v1, v2) -> v1.calculateAge() - v2.calculateAge());
                    System.out.println("Vehicles sorted by age (ascending).\n");
                    listVehicles(); // Optional: Display sorted list
                    break;
                 case 2:
                    Collections.sort(vehicles, (v1, v2) -> v2.calculateAge() - v1.calculateAge());
                    System.out.println("Vehicles sorted by age (descending).\n");
                    listVehicles(); // Optional: Display sorted list
                    break;
                case 3:
                    System.out.println("Returning to main menu...\n");
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        } while (sortChoice != 3);
    }
}


// OnlineReservationSystem.java
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineReservationSystem {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static User loggedInUser = null;

    public static void main(String[] args) {
        // Predefine some users
        users.add(new User("Shiba", "Shiba123"));
        users.add(new User("user", "user123"));

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Welcome to the Online Reservation System");
            if (loggedInUser == null) {
                login(scanner);
            } else {
                System.out.println("1. Make a Reservation");
                System.out.println("2. Cancel a Reservation");
                System.out.println("3. Logout");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                
                switch (choice) {
                    case 1:
                        makeReservation(scanner);
                        break;
                    case 2:
                        cancelReservation(scanner);
                        break;
                    case 3:
                        loggedInUser = null;
                        System.out.println("Logged out successfully.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.validatePassword(password)) {
                loggedInUser = user;
                System.out.println("Login successful. Welcome, " + username + "!");
                return;
            }
        }
        System.out.println("Invalid username or password. Please try again.");
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter your name: ");
        String passengerName = scanner.nextLine();
        System.out.print("Enter train number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter train name: ");
        String trainName = scanner.nextLine();
        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey (YYYY-MM-DD): ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter departure place: ");
        String from = scanner.nextLine();
        System.out.print("Enter destination place: ");
        String to = scanner.nextLine();

        Reservation reservation = new Reservation(passengerName, trainNumber, trainName, classType, dateOfJourney, from, to);
        reservations.add(reservation);
        System.out.println("Reservation successful. Your PNR is " + reservation.getPnr());
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter PNR number to cancel: ");
        int pnr = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Reservation toRemove = null;
        for (Reservation reservation : reservations) {
            if (reservation.getPnr() == pnr) {
                toRemove = reservation;
                break;
            }
        }

        if (toRemove != null) {
            reservations.remove(toRemove);
            System.out.println("Reservation cancelled successfully. Details: " + toRemove);
        } else {
            System.out.println("No reservation found with PNR " + pnr);
        }
    }
}

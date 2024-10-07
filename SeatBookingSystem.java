import java.util.Scanner;

public class SeatBookingSystem {
    // Define seating arrangement
    private static char[][] seats = new char[5][10]; // 5 rows, 10 seats per row

    public static void main(String[] args) {
        initializeSeats();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Book a seat");
            System.out.println("2. Cancel a seat");
            System.out.println("3. View seats");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookSeat(scanner);
                    break;
                case 2:
                    cancelSeat(scanner);
                    break;
                case 3:
                    displaySeats();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the seat booking system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    // Initialize seats with all 'A' (available)
    private static void initializeSeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'A'; // 'A' for Available
            }
        }
    }

    // Display seating arrangement
    private static void displaySeats() {
        System.out.println("\nSeating Arrangement:");
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Row " + (i + 1) + ": ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Book a seat
    private static void bookSeat(Scanner scanner) {
        System.out.print("Enter row number (1-5): ");
        int row = scanner.nextInt();
        
        if (row < 1 || row > 5) {
            System.out.println("Invalid row number. Please enter a number between 1 and 5.");
            return;
        }

        System.out.print("Enter seat number (1-10): ");
        int seat = scanner.nextInt();

        if (seat < 1 || seat > 10) {
            System.out.println("Invalid seat number. Please enter a number between 1 and 10.");
            return;
        }

        if (seats[row - 1][seat - 1] == 'A') {
            seats[row - 1][seat - 1] = 'B'; // 'B' for Booked
            System.out.println("Seat " + row + "-" + seat + " booked successfully.");
        } else {
            System.out.println("Seat " + row + "-" + seat + " is already booked.");
        }
    }

    // Cancel a seat
    private static void cancelSeat(Scanner scanner) {
        System.out.print("Enter row number (1-5): ");
        int row = scanner.nextInt();
        
        if (row < 1 || row > 5) {
            System.out.println("Invalid row number. Please enter a number between 1 and 5.");
            return;
        }

        System.out.print("Enter seat number (1-10): ");
        int seat = scanner.nextInt();

        if (seat < 1 || seat > 10) {
            System.out.println("Invalid seat number. Please enter a number between 1 and 10.");
            return;
        }

        if (seats[row - 1][seat - 1] == 'B') {
            seats[row - 1][seat - 1] = 'A'; // 'A' for Available
            System.out.println("Seat " + row + "-" + seat + " canceled successfully.");
        } else {
            System.out.println("Seat " + row + "-" + seat + " is not booked.");
        }
    }
}

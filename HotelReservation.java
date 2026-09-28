import java.util.Scanner;
import java.util.InputMismatchException;

class HotelReservation {

    Scanner sc = new Scanner(System.in);

    String customerName;
    int tableNumber;
    int people;
    boolean booked = false;

    // Table availability
    boolean[] tableBooked = new boolean[6];

    void showTables() {
        System.out.println("\n===== TABLES =====");

        System.out.println("Table 1 - 2 People - "
                + (tableBooked[1] ? "Booked" : "Available"));

        System.out.println("Table 2 - 2 People - "
                + (tableBooked[2] ? "Booked" : "Available"));

        System.out.println("Table 3 - 4 People - "
                + (tableBooked[3] ? "Booked" : "Available"));

        System.out.println("Table 4 - 4 People - "
                + (tableBooked[4] ? "Booked" : "Available"));

        System.out.println("Table 5 - 6 People - "
                + (tableBooked[5] ? "Booked" : "Available"));
    }

    void bookTable() {

        try {
            showTables();

            System.out.print("\nEnter Table Number: ");
            tableNumber = sc.nextInt();

            // Check valid table number
            if (tableNumber < 1 || tableNumber > 5) {
                System.out.println("Invalid Table Number!");
                return;
            }

            // Check table availability
            if (tableBooked[tableNumber]) {
                System.out.println("Sorry! Table " + tableNumber
                        + " is already booked.");
                return;
            }

            System.out.print("Enter Number of People: ");
            people = sc.nextInt();

            if (people <= 0) {
                System.out.println("Number of people must be greater than 0.");
                return;
            }

            // Check table capacity
            if (tableNumber == 1 || tableNumber == 2) {
                if (people > 2) {
                    System.out.println("This table can accommodate only 2 people.");
                    return;
                }
            }

            if (tableNumber == 3 || tableNumber == 4) {
                if (people > 4) {
                    System.out.println("This table can accommodate only 4 people.");
                    return;
                }
            }

            if (tableNumber == 5) {
                if (people > 6) {
                    System.out.println("This table can accommodate only 6 people.");
                    return;
                }
            }

            sc.nextLine();

            System.out.print("Enter Customer Name: ");
            customerName = sc.nextLine();

            tableBooked[tableNumber] = true;
            booked = true;

            System.out.println("\nTable Booked Successfully!");

        } catch (InputMismatchException e) {

            System.out.println("\nInvalid Input!");
            System.out.println("Please enter numbers only.");

            sc.nextLine();
        }
    }

    void viewBooking() {

        if (booked) {
            System.out.println("\n===== BOOKING DETAILS =====");
            System.out.println("Customer Name : " + customerName);
            System.out.println("Table Number  : " + tableNumber);
            System.out.println("People        : " + people);
        } else {
            System.out.println("\nNo booking found.");
        }
    }

    void cancelBooking() {

        try {

            if (booked) {

                tableBooked[tableNumber] = false;
                booked = false;

                System.out.println("\nBooking Cancelled Successfully!");
                System.out.println("Table " + tableNumber + " is now Available.");

            } else {

                System.out.println("\nNo booking found.");

            }

        } catch (Exception e) {

            System.out.println("Error while cancelling booking.");

        }
    }

    public static void main(String[] args) {

        HotelReservation hotel = new HotelReservation();

        int choice = 0;

        do {

            try {

                System.out.println("\n===== HOTEL TABLE RESERVATION =====");
                System.out.println("1. View Tables");
                System.out.println("2. Book Table");
                System.out.println("3. View Booking");
                System.out.println("4. Cancel Booking");
                System.out.println("5. Exit");

                System.out.print("Enter Choice: ");
                choice = hotel.sc.nextInt();

                switch (choice) {

                    case 1:
                        hotel.showTables();
                        break;

                    case 2:
                        hotel.bookTable();
                        break;

                    case 3:
                        hotel.viewBooking();
                        break;

                    case 4:
                        hotel.cancelBooking();
                        break;

                    case 5:
                        System.out.println("\nThank You! Visit Again!");
                        break;

                    default:
                        System.out.println("\nInvalid Choice!");
                }

            } catch (InputMismatchException e) {

                System.out.println("\nInvalid Input!");
                System.out.println("Please enter a number from 1 to 5.");

                hotel.sc.nextLine();
            }

        } while (choice != 5);
    }
}
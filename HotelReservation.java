import java.util.Scanner;

class HotelReservation {

    Scanner sc = new Scanner(System.in);

    String customerName;
    int tableNumber;
    int people;
    boolean booked = false;

    void showTables() {
        System.out.println("\n===== TABLES =====");
        System.out.println("Table 1 - 2 People");
        System.out.println("Table 2 - 2 People");
        System.out.println("Table 3 - 4 People");
        System.out.println("Table 4 - 4 People");
        System.out.println("Table 5 - 6 People");
    }

    void bookTable() {

        showTables();

        System.out.print("\nEnter Table Number: ");
        tableNumber = sc.nextInt();

        System.out.print("Enter Number of People: ");
        people = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();

        booked = true;

        System.out.println("\nTable Booked Successfully!");
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

        if (booked) {
            booked = false;
            System.out.println("\nBooking Cancelled Successfully!");
        } else {
            System.out.println("\nNo booking found.");
        }
    }

    public static void main(String[] args) {

        HotelReservation hotel = new HotelReservation();

        int choice;

        do {
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

        } while (choice != 5);
    }
}
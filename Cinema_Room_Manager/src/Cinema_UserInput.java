import java.util.Scanner;

public class Cinema_UserInput {
    public static void main(String[] args) {
        /**
         * Read two positive integer numbers that represent the number of rows and seats in each row and print the seating arrangement like in the first stage. Then, read two integer numbers from the input: a row number and a seat number in that row. These numbers represent the coordinates of the seat according to which the program should print the ticket price. The ticket price is determined by the same rules as the previous stage:
         *
         *     If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
         *     In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the rest 5 rows.
         *
         * After that, the program should print out all the seats in the screen room as shown in the example and mark the chosen seat by the B symbol. Finally, it should print the ticket price and stop. Note that in this project, the number of rows and seats won't be greater than 9.
         *
         */
        /**
         * example1
         * Enter the number of rows:
         * > 8
         * Enter the number of seats in each row:
         * > 9
         *
         * Cinema:
         *   1 2 3 4 5 6 7 8 9
         * 1 S S S S S S S S S
         * 2 S S S S S S S S S
         * 3 S S S S S S S S S
         * 4 S S S S S S S S S
         * 5 S S S S S S S S S
         * 6 S S S S S S S S S
         * 7 S S S S S S S S S
         * 8 S S S S S S S S S
         *
         * Enter a row number:
         * > 6
         * Enter a seat number in that row:
         * > 5
         *
         * Ticket price: $8
         *
         * Cinema:
         *   1 2 3 4 5 6 7 8 9
         * 1 S S S S S S S S S
         * 2 S S S S S S S S S
         * 3 S S S S S S S S S
         * 4 S S S S S S S S S
         * 5 S S S S S S S S S
         * 6 S S S S B S S S S
         * 7 S S S S S S S S S
         * 8 S S S S S S S S S
         */
        /**
         * Enter the number of rows:
         * > 7
         * Enter the number of seats in each row:
         * > 8
         *
         * Cinema:
         *   1 2 3 4 5 6 7 8
         * 1 S S S S S S S S
         * 2 S S S S S S S S
         * 3 S S S S S S S S
         * 4 S S S S S S S S
         * 5 S S S S S S S S
         * 6 S S S S S S S S
         * 7 S S S S S S S S
         *
         * Enter a row number:
         * > 3
         * Enter a seat number in that row:
         * > 6
         *
         * Ticket price: $10
         *
         * Cinema:
         *   1 2 3 4 5 6 7 8
         * 1 S S S S S S S S
         * 2 S S S S S S S S
         * 3 S S S S S B S S
         * 4 S S S S S S S S
         * 5 S S S S S S S S
         * 6 S S S S S S S S
         * 7 S S S S S S S S
         */
        final int PRICE_CHEAP = 8;
        final int PRICE_NORMAL = 10;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i<=seats;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 1; i<=rows;i++){
            System.out.print(i);
            System.out.print(" ");
            for (int j = 0; j<seats;j++){
                System.out.print("S");
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Enter a row number:");
        int selectedrow =0;
        //condition 1 : rows lower than 9
        do {
            selectedrow = sc.nextInt();
        }while((selectedrow <= 0) || (selectedrow > rows));

        System.out.println("Enter a seat number in that row:");
        int seat = 0;
        do {
            seat = sc.nextInt();
        }while((seat <= 0) || (seat > seats));


        int totalSeats = rows*seats;
        long ticketPrice = 0;
        int half = 0;
        if(totalSeats > 60){
            if(rows%2 ==0){
                half = rows/2;
                if (selectedrow > half){
                    ticketPrice = PRICE_CHEAP;
                }else {
                    ticketPrice = PRICE_NORMAL;
                }

            }else{
                half = rows/2;
                if (selectedrow > half){
                    ticketPrice = PRICE_CHEAP;
                }else {
                    ticketPrice = PRICE_NORMAL;
                }
            }

        }else{
            ticketPrice = PRICE_NORMAL;
        }

        System.out.println("Ticket price: $"+ticketPrice);

        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i<=seats;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 1; i<=rows;i++){
            System.out.print(i);
            System.out.print(" ");
            for (int j = 0; j<seats;j++){
                if((i == selectedrow) && (j == seat-1)) {
                    System.out.print("B");
                    System.out.print(" ");
                }else{
                    System.out.print("S");
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

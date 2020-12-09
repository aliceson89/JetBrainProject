/**
 * When the item Statistics is chosen, your program should print the following information:
 *
 *     The number of purchased tickets;
 *     The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;
 *     Current income;
 *     Total income that shows how much money the theatre will get if all the tickets are sold.
 *
 * The rest of the menu items should work the same way as before, except the item Buy a ticket shouldn't allow a user to buy a ticket that has already been purchased.
 *
 * If a user chooses an already taken seat, print That ticket has already been purchased and ask them to enter different seat coordinates until they pick an available seat. Of course, you shouldn't allow coordinates that are out of bounds. If this happens, print Wrong input! and ask to enter different seat coordinates until the user picks an available seat.
 */

import java.util.Scanner;

/**
 * Enter the number of rows:
 * > 6
 * Enter the number of seats in each row:
 * > 6
 *
 * 1. Show the seats
 * 2. Buy a ticket
 * 3. Statistics
 * 0. Exit
 * > 3
 *
 * Number of purchased tickets: 0
 * Percentage: 0.00%
 * Current income: $0
 * Total income: $360
 *
 * 1. Show the seats
 * 2. Buy a ticket
 * 3. Statistics
 * 0. Exit
 * > 2
 *
 * Enter a row number:
 * > 1
 * Enter a seat number in that row:
 * > 1
 *
 * Ticket price: $10
 *
 * 1. Show the seats
 * 2. Buy a ticket
 * 3. Statistics
 * 0. Exit
 * > 3
 *
 * Number of purchased tickets: 1
 * Percentage: 2.78%
 * Current income: $10
 * Total income: $360
 *
 * 1. Show the seats
 * 2. Buy a ticket
 * 3. Statistics
 * 0. Exit
 * > 2
 *
 * Enter a row number:
 * > 1
 * Enter a seat number in that row:
 * > 1
 *
 * That ticket has already been purchased!
 *
 * Enter a row number:
 * > 10
 * Enter a seat number in that row:
 * > 20
 *
 * Wrong input!
 *
 * Enter a row number:
 * > 4
 * Enter a seat number in that row:
 * > 4
 *
 * Ticket price: $10
 *
 * 1. Show the seats
 * 2. Buy a ticket
 * 3. Statistics
 * 0. Exit
 * > 1
 *
 * Cinema:
 *   1 2 3 4 5 6
 * 1 B S S S S S
 * 2 S S S S S S
 * 3 S S S S S S
 * 4 S S S B S S
 * 5 S S S S S S
 * 6 S S S S S S
 *
 * 1. Show the seats
 * 2. Buy a ticket
 * 3. Statistics
 * 0. Exit
 * > 3
 *
 * Number of purchased tickets: 2
 * Percentage: 5.56%
 * Current income: $20
 * Total income: $360
 *
 * 1. Show the seats
 * 2. Buy a ticket
 * 3. Statistics
 * 0. Exit
 * > 0
 */
public class Cinema_Statistics {
    public static void Menu(){
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }



    public static void createSeatArray (String[][] cinemaSeat,int rows, int seats){

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinemaSeat[i][j] ="S";
            }
        }
    }

    public static boolean createSelectedSeatArray (String[][] cinemaSeat, int selectedrow, int seat, boolean flag){

        for (int i = 0; i < cinemaSeat.length; i++) {
            for (int j = 0; j < cinemaSeat[i].length; j++) {
                if(i == (selectedrow-1) && j == (seat-1)){
                    if (cinemaSeat[i][j] == "B"){
                        System.out.println("That ticket has already been purchased");
                        System.out.println();
                        flag = true;
                        break;
                    }else{
                        cinemaSeat[i][j] ="B";
                        flag = false;
                    }

                }
            }
        }
        return flag;
    }

    public static void printSeat(String[][] cinemaSeat, int rows, int seats){
        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");

        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <=rows; i++) {
            System.out.print(i);
            System.out.print(" ");
            for (int j = 1; j <= seats; j++) {
                System.out.print(cinemaSeat[i-1][j-1]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static int PrintTicketPrice(int rows, int seats, int selectedrow){
        final int PRICE_CHEAP = 8;
        final int PRICE_NORMAL = 10;
        int totalSeats = rows * seats;
        int ticketPrice = 0;
        int half = 0;

        if (totalSeats > 60) {
            if (rows % 2 == 0) {
                half = rows / 2;
                if (selectedrow > half) {
                    ticketPrice = PRICE_CHEAP;
                } else {
                    ticketPrice = PRICE_NORMAL;
                }

            } else {
                half = rows / 2;
                if (selectedrow > half) {
                    ticketPrice = PRICE_CHEAP;
                } else {
                    ticketPrice = PRICE_NORMAL;
                }
            }

        } else {
            ticketPrice = PRICE_NORMAL;
        }

        return ticketPrice;


    }

    public static int totalIncome (int rows, int seats){
        final int PRICE_CHEAP = 8;
        final int PRICE_NORMAL = 10;
        int totalSeats = rows * seats;
        int totalIncome = 0;
        int half = 0;

        if (totalSeats > 60) {
            if (rows % 2 == 0) {
                half = rows / 2;
                totalIncome = half*seats*PRICE_CHEAP +half*seats*PRICE_NORMAL;

            } else {
                half = rows / 2;
                totalIncome = (rows-half)*seats*PRICE_CHEAP +half*seats*PRICE_NORMAL;
            }

        } else {
            totalIncome = PRICE_NORMAL*totalSeats;
        }
        return totalIncome;
    }

    public static float percentOfPurcahsedTicket (int numberPurchasedTicket, int totalSeats){
        return ((float)numberPurchasedTicket/(float)totalSeats) *100;

    }
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        System.out.println();
        String[][] cinemaSeat = new String[rows][seats];
        createSeatArray(cinemaSeat,rows,seats);
        int totalSeats = rows * seats;

        int currentIncome = 0;
        int numberPurchasedTicket = 0;

        boolean flag = true;
        do{
            Menu();
            int option = sc.nextInt();
            switch(option){
                case 1 :
                    printSeat(cinemaSeat,rows,seats);
                    break;
                case 2 :
                    System.out.println();
                    int selectedrow = 0;
                    int seat = 0;
                    boolean ticketAvailablity = false;
                    do {

                            while (true) {
                                System.out.println("Enter a row number:");
                                selectedrow = sc.nextInt();

                                System.out.println("Enter a seat number in that row:");
                                seat = sc.nextInt();

                                if((selectedrow > 0) && (selectedrow <= rows)&&(seat > 0) && (seat <= seats)){
                                    break;
                                } else {
                                    System.out.println();
                                    System.out.println("Wrong input!");
                                    System.out.println();
                                }
                            }

                            ticketAvailablity=createSelectedSeatArray(cinemaSeat,selectedrow,seat,ticketAvailablity);


                    }while(ticketAvailablity);
                        int ticketPrice = PrintTicketPrice(rows,seats,selectedrow);
                        System.out.println("Ticket price: $" + ticketPrice);
                        System.out.println();
                        currentIncome = currentIncome+ticketPrice;
                        numberPurchasedTicket++;

                    break;
                case 3 :
                    System.out.println();
                    System.out.println("Number of purchased tickets: "+numberPurchasedTicket);
                    float percent = percentOfPurcahsedTicket(numberPurchasedTicket,totalSeats);
                    System.out.print("Percentage: ");
                    System.out.format("%4.2f",percent);
                    System.out.println("%");
                    System.out.println("Current income: $" +currentIncome);
                    System.out.println("Total income: $" + totalIncome(rows,seats));
                    System.out.println();
                    break;
                case 0 :
                    flag = false;
                    break;

                default:
                    System.out.println("Please enter correct option");
                    break;
            }
        }while(flag);

    }
}

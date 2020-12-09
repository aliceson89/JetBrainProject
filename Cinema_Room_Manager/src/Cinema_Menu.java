/**
 *
 *     Show the seats should print the current seating arrangement. The empty seats should be marked with an S symbol, and taken seats are marked with a B symbol.
 *     Buy a ticket should read the seat coordinates from the input and print the ticket price like in the previous stage. After that, the chosen seat should be marked with a B when the item Show the seats is called.
 *     Exit should stop the program.
 *
 */

import java.util.Scanner;

/**
 *  Enter the number of rows:
 * > 7
 * Enter the number of seats in each row:
 * > 7
 *
 * 1. Show the seats
 * 2. Buy a ticket
 * 0. Exit
 * > 1
 *
 * Cinema:
 *   1 2 3 4 5 6 7
 * 1 S S S S S S S
 * 2 S S S S S S S
 * 3 S S S S S S S
 * 4 S S S S S S S
 * 5 S S S S S S S
 * 6 S S S S S S S
 * 7 S S S S S S S
 *
 * 1. Show the seats
 * 2. Buy a ticket
 * 0. Exit
 * > 2
 *
 * Enter a row number:
 * > 4
 * Enter a seat number in that row:
 * > 5
 * Ticket price: $10
 *
 * 1. Show the seats
 * 2. Buy a ticket
 * 0. Exit
 * > 1
 *
 * Cinema:
 *   1 2 3 4 5 6 7
 * 1 S S S S S S S
 * 2 S S S S S S S
 * 3 S S S S S S S
 * 4 S S S S B S S
 * 5 S S S S S S S
 * 6 S S S S S S S
 * 7 S S S S S S S
 *
 * 1. Show the seats
 * 2. Buy a ticket
 * 0. Exit
 * > 0
 */

public class Cinema_Menu {


    public static void Menu(){
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
    }



    public static void createSeatArray (String[][] cinemaSeat,int rows, int seats){

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinemaSeat[i][j] ="S";
            }
        }
    }

    public static void createSelectedSeatArray (String[][] cinemaSeat, int selectedrow, int seat){
        for (int i = 0; i < cinemaSeat.length; i++) {
            for (int j = 0; j < cinemaSeat[i].length; j++) {
                if(i == (selectedrow-1) && j == (seat-1))
                cinemaSeat[i][j] ="B";
            }
        }
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


    public static void PrintTicketPrice(int rows, int seats, int selectedrow){
        final int PRICE_CHEAP = 8;
        final int PRICE_NORMAL = 10;
        int totalSeats = rows * seats;
        long ticketPrice = 0;
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

        System.out.println("Ticket price: $" + ticketPrice);

        System.out.println();

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
                    System.out.println("Enter a row number:");
                    int selectedrow = 0;
                    //condition 1 : rows lower than 9
                    do {
                        selectedrow = sc.nextInt();
                    } while ((selectedrow <= 0) || (selectedrow > rows));

                    System.out.println("Enter a seat number in that row:");
                    int seat = 0;
                    do {
                        seat = sc.nextInt();
                    } while ((seat <= 0) || (seat > seats));
                    createSelectedSeatArray(cinemaSeat,selectedrow,seat);
                    PrintTicketPrice(rows,seats,selectedrow);
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

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        /**
         * Stage 1 :
         * There is not a lot of space in our new cinema theatre, so you need to take into account the restrictions on the number of seats. Your friends said that the room would fit 7 rows of 8 seats. Your task is to help them visualize the seating arrangement by printing the scheme to the console.
         *
         * Your output should be like in the example below and should contain 9 lines.
         */
        /**
         * result
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
         */


        int row = 7;
        int seats = 8;
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 1; i<=row;i++){
            System.out.print(i);
            System.out.print(" ");
            for (int j = 0; j<seats;j++){
                System.out.print("S");
                System.out.print(" ");
            }
            System.out.println();
        }

        /**
         * Stage 2 :
         * In this stage, you need to read two positive integer numbers from the input: the number of rows and the number of seats in each row. The ticket price is determined by the following rules:
         *
         *     If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
         *     In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the rest 5 rows.
         *
         * Calculate the profit from the sold tickets depending on the number of seats and print the result as shown in the examples below. After that, your program should stop. Note that in this project, the number of rows and seats won't be greater than 9.
         */
        /**
         * Enter the number of rows:
         * > 4
         * Enter the number of seats in each row:
         * > 5
         * Total income:
         * $200
         *
         * Example 2
         *
         * Enter the number of rows:
         * > 8
         * Enter the number of seats in each row:
         * > 9
         * Total income:
         * $648
         *
         * Example 3
         *
         * Enter the number of rows:
         * > 9
         * Enter the number of seats in each row:
         * > 7
         * Total income:
         * $560
         */
        final int PRICE_CHEAP = 8;
        final int PRICE_NORMAL = 10;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row2 =0;
        //condition 1 : rows lower than 9
        do {
            row2 = sc.nextInt();
        }while((row2 <= 0) || (row2 > 9));

        System.out.println("Enter the number of seats in each row:");
        int seatPerRow = 0;
        do {
            seatPerRow = sc.nextInt();
        }while((seatPerRow <= 0) || (seatPerRow > 9));


        int totalSeats = row2*seatPerRow;
        long income = 0;
        int half = 0;
        if(totalSeats > 60){
            if(row2%2 ==0){
                half = row2/2;
                income = half*seatPerRow*PRICE_NORMAL + (row2-half)*seatPerRow*PRICE_CHEAP;
            }else{
                half = row2/2;
                income = half*seatPerRow*PRICE_NORMAL + (row2-half)*seatPerRow*PRICE_CHEAP;
            }

        }else{
            income = totalSeats*PRICE_NORMAL;
        }

        System.out.println("Total income:");
        System.out.println("$"+income);


    }
}

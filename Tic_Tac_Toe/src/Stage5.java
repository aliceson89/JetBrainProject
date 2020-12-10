/**
 *
 Prints an empty field at the beginning of the game.
 Creates a game loop where the program asks the user to enter the cell coordinates,
 analyzes the move for correctness, and shows a field with the changes if everything is ok.
 Ends the game when someone wins or when there is a draw.
 */

import java.util.Scanner;

/**
 * ---------
 * |       |
 * |       |
 * |       |
 * ---------
 * Enter the coordinates: 2 2
 * ---------
 * |       |
 * |   X   |
 * |       |
 * ---------
 * Enter the coordinates: 2 2
 * This cell is occupied! Choose another one!
 * Enter the coordinates: two two
 * You should enter numbers!
 * Enter the coordinates: 1 4
 * Coordinates should be from 1 to 3!
 * Enter the coordinates: 1 3
 * ---------
 * | O     |
 * |   X   |
 * |       |
 * ---------
 * Enter the coordinates: 3 1
 * ---------
 * | O     |
 * |   X   |
 * |     X |
 * ---------
 * Enter the coordinates: 1 2
 * ---------
 * | O     |
 * | O X   |
 * |     X |
 * ---------
 * Enter the coordinates: 1 1
 * ---------
 * | O     |
 * | O X   |
 * | X   X |
 * ---------
 * Enter the coordinates: 3 2
 * ---------
 * | O     |
 * | O X O |
 * | X   X |
 * ---------
 * Enter the coordinates: 2 1
 * ---------
 * | O     |
 * | O X O |
 * | X X X |
 * ---------
 * X wins
 */
public class Stage5 {


    public static boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != ' ') && (c1 == c2) && (c2 == c3));
    }
    // 1. board[i][j]에서 [i] 고정 인데 [j=0][j=1][j=2] 3칸이 다 같은 표시(0 or X)일때
    public static boolean checkRowsForWin(char[][] board){
        for (int i = 0; i < 3 ; i ++){
            if (checkRowCol(board[i][0],board[i][1],board[i][2]) == true){
                return true;
            }
        }
        return false;
    }
    // 2. board[i][j]에서 [j] 고정 인데 [i=0][i=1][i=2] 3칸이 다 같은 표시(0 or X)일때
    public static boolean checkColumnForWin(char[][] board){
        for (int i = 0; i < 3 ; i ++){
            if (checkRowCol(board[0][i],board[1][i],board[2][i]) == true){
                return true;
            }
        }
        return false;
    }



    // 3. 대각선 3자리가 같을때
    public static boolean checkDiagonalForWin(char[][] board){
        boolean negativeDirection = checkRowCol(board[0][0],board[1][1],board[2][2]);
        boolean positiveDirection = checkRowCol(board[0][2],board[1][1],board[2][0]);

        if(negativeDirection == true || positiveDirection == true){
            return true;
        }else{
            return false;
        }

    }

    public static boolean checkForWin(char[][] board) {
        return (checkRowsForWin(board) || checkColumnForWin(board) || checkDiagonalForWin(board));
    }

    // Board 가 찾는지 확인
    public static boolean boardFull (char[][] board){
        for (int i = 0; i < 3 ; i++){
            for (int j = 0; j < 3; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    //누가 이겼는지 확인
    public static char playerHasWon(char[][] board) {

        //Check each row
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '_') {
                return board[i][0];
            }
        }

        //Check each column
        for(int j = 0; j < 3; j++) {
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '_') {
                return board[0][j];
            }
        }

        //Check the diagonals
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '_') {
            return board[1][1];
        }
        if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '_') {
            return board[1][1];
        }

        //Otherwise nobody has not won yet
        return ' ';

    }
    public static boolean hasOnlyDigit(String string){
        char tmp;
        for (int i = 0; i < string.length(); i++){
            tmp = string.charAt(i);
            if(Character.isDigit(tmp) == false){
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char[][] board){
        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }
    public static char[][] initializedBoard(char[][] board){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                board[i][j]=' ';
            }

        }
        return board;
    }

    public static char changePlayer(char currentPlayerMark){
        if(currentPlayerMark == 'X'){
            return currentPlayerMark = 'O';
        }else {
            return currentPlayerMark = 'X';
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] board = new char[3][3];
        board = initializedBoard(board);
        printBoard(board);
        char currentPlayerMark = 'X';

        boolean complete = true;
        boolean flag = true;
        do {
                System.out.print("Enter the coordinates: ");
                String userInput = sc.nextLine();
                String intStr = userInput.replace(" ", "");
                if (hasOnlyDigit(intStr) == false) {
                    System.out.println("You should enter numbers!");
                    flag = true;
                }else {
                    String[] temp = userInput.split(" ");
                    int x = Integer.parseInt(temp[0]);
                    int y = Integer.parseInt(temp[1]);

                    if (x > 3 || x < 1 || y > 3 || y < 1) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        flag = true;
                    } else {
                        // 이부분이 이해가 안감.
                        if (board[3 - y][x - 1] == 'X' || board[3 - y][x - 1] == 'O') {
                            System.out.println("This cell is occupied! Choose another one!");
                            flag = true;
                        } else {
                            board[3 - y][x - 1] = currentPlayerMark;
                            flag = false;
                            currentPlayerMark= changePlayer(currentPlayerMark);
                            //System.out.println("Current Player is "  + currentPlayerMark);
                            printBoard(board);
                            if (checkForWin(board)){
                                char winner =playerHasWon(board);
                                System.out.println(winner+" wins");
                                complete = false;
                            }else{
                                if (boardFull(board) == true){
                                    System.out.println("Draw");
                                    complete = false;
                                }else{
                                    complete = true;
                                }
                            }
                        }
                    }
                }





                // complete or flag == true means game is not finished or user Input is wrong
        }while(complete || flag);
    }
}

import java.util.Scanner;

/**
 * Example 1:
 *
 * Enter cells: > XXXOO__O_
 * ---------
 * | X X X |
 * | O O _ |
 * | _ O _ |
 * ---------
 * X wins
 *
 * Example 2:
 *
 * Enter cells: > XOXOXOXXO
 * ---------
 * | X O X |
 * | O X O |
 * | X X O |
 * ---------
 * X wins
 *
 * Example 3:
 *
 * Enter cells: > XOOOXOXXO
 * ---------
 * | X O O |
 * | O X O |
 * | X X O |
 * ---------
 * O wins
 *
 * Example 4:
 *
 * Enter cells: > XOXOOXXXO
 * ---------
 * | X O X |
 * | O O X |
 * | X X O |
 * ---------
 * Draw
 *
 * Example 5:
 *
 * Enter cells: > XO_OOX_X_
 * ---------
 * | X O   |
 * | O O X |
 * |   X   |
 * ---------
 * Game not finished
 *
 * Example 6:
 *
 * Enter cells: > XO_XO_XOX
 * ---------
 * | X O _ |
 * | X O _ |
 * | X O X |
 * ---------
 * Impossible
 *
 * Example 7:
 *
 * Enter cells: > _O_X__X_X
 * ---------
 * |   O   |
 * | X     |
 * | X   X |
 * ---------
 * Impossible
 *
 * Example 8:
 *
 * Enter cells: _OOOO_X_X
 * ---------
 * |   O O |
 * | O O   |
 * | X   X |
 * ---------
 * Impossible
 */
public class Stage3 {


    /**
     * 이길 수 있는 경우
     * 1. board[i][j]에서 [i] 고정 인데 [j=0][j=1][j=2] 3칸이 다 같은 표시(0 or X)일때
     * 2. board[i][j]에서 [j] 고정 인데 [i=0][i=1][i=2] 3칸이 다 같은 표시(0 or X)일때
     * 3. 대각선 3자리가 같을때
     */
    /**
     * Impossible Case :
     *  1. xxx, ooo 가 동시에 있는 경우
     *  2. x 의 갯수와  o 의 갯수의 차이가 2개이상 나는 경우 (무조건 같거나 1개만 차이나야함)
     */

    public static boolean checkImpossiblewithNumber(char[][] board){
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < 3 ; i++){
            for (int j = 0; j < 3; j++){
                if(board[i][j] == 'O'){
                    oCount++;
                }else if (board[i][j] == 'X'){
                    xCount++;
                }else{

                }
            }
        }
        if (Math.abs(xCount -oCount) >= 2){
            //impossible
            return true;
        }else {
            //possible
            return false;
        }
    }
    public static boolean checkImpossibleWithOX(char[][] board){

        int rowCount = 0;
        int columnCount = 0;
        for(int i = 0; i < 3; i++) {
            if(checkRowCol(board[i][0],board[i][1],board[i][2]) == true) {
                rowCount++;
            }
        }

        //Check each column
        for(int i = 0; i < 3; i++) {
            if(checkRowCol(board[0][i],board[1][i],board[2][i]) == true) {
                columnCount++;
            }
        }

        if (rowCount >=2 || columnCount >=2){
            return true;
        }else{
            return false;
        }

    }
    public static boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '_') && (c1 == c2) && (c2 == c3));
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
                if(board[i][j] == '_'){
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



    public static void main(String[] args) {
        System.out.print("Enter cells: ");
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        char[] arrs = line.toCharArray();
        System.out.println("---------");
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                board[i][j] = arrs[i*3+j];
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");




        if (checkImpossiblewithNumber(board) == true){

            System.out.println("Impossible");
        }else if (checkImpossibleWithOX(board) == true){
            System.out.println("Impossible");
        }else{

           if (checkColumnForWin(board) == false && checkDiagonalForWin(board) == false && checkRowsForWin(board) == false){
               if (boardFull(board) == true){
                   System.out.println("Draw");
               }else{
                   System.out.println("Game not finished");
               }
           }else{
               char winner =playerHasWon(board);
               System.out.println(winner+" wins");
           }

        }

    }
}

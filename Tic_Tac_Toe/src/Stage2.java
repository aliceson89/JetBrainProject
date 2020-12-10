/**
 *
 Reads 9 symbols from the input and writes an appropriate 3x3 field. Elements of the field can contain only 'X', 'O' and '_' symbols.
 Sets the field to a specific format,
 i.e. the field should start and end with ---------,
 all lines in between should start and end with '|' symbol and everything in the middle should be separated with a single space.
 */

import java.util.Scanner;

/**
 * Example 1:
 *
 * Enter cells: > O_OXXO_XX
 * ---------
 * | O _ O |
 * | X X O |
 * | _ X X |
 * ---------
 *
 * Example 2:
 *
 * Enter cells: > OXO__X_OX
 * ---------
 * | O X O |
 * | _ _ X |
 * | _ O X |
 * ---------
 *
 * Example 3:
 *
 * Enter cells: _XO__X___
 * ---------
 * | _ X O |
 * | _ _ X |
 * | _ _ _ |
 * ---------
 */
public class Stage2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        char[] arrs = line.toCharArray();
        System.out.println("---------");
        /**way1
        System.out.println("| "+arrs[0]+" "+arrs[1]+" "+arrs[2]+" "+"|");
        System.out.println("| "+arrs[3]+" "+arrs[4]+" "+arrs[5]+" "+"|");
        System.out.println("| "+arrs[6]+" "+arrs[7]+" "+arrs[8]+" "+"|");
        */

        //way2
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

    }
}



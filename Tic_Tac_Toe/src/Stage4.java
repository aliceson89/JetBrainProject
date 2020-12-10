import java.util.Scanner;

/**
 *Example 1:
 *
 * Enter cells: > X_X_O____
 * ---------
 * | X   X |
 * |   O   |
 * |       |
 * ---------
 * Enter the coordinates: > 1 1
 * ---------
 * | X   X |
 * |   O   |
 * | X     |
 * ---------
 *
 * Example 2:
 *
 * Enter cells: > _XXOO_OX_
 * ---------
 * |   X X |
 * | O O   |
 * | O X   |
 * ---------
 * Enter the coordinates: > 1 3
 * ---------
 * | X X X |
 * | O O   |
 * | O X   |
 * ---------
 *
 * Example 3:
 *
 * Enter cells: > _XXOO_OX_
 * ---------
 * |   X X |
 * | O O   |
 * | O X   |
 * ---------
 * Enter the coordinates: > 3 1
 * ---------
 * |   X X |
 * | O O   |
 * | O X X |
 * ---------
 *
 * Example 4:
 *
 * Enter cells: > _XXOO_OX_
 * ---------
 * |   X X |
 * | O O   |
 * | O X   |
 * ---------
 * Enter the coordinates: > 3 2
 * ---------
 * |   X X |
 * | O O X |
 * | O X   |
 * ---------
 *
 * Example 5:
 *
 * Enter cells: > _XXOO_OX_
 * ---------
 * |   X X |
 * | O O   |
 * | O X   |
 * ---------
 * Enter the coordinates: > 1 1
 * This cell is occupied! Choose another one!
 * Enter the coordinates: > 1 3
 * ---------
 * | X X X |
 * | O O   |
 * | O X   |
 * ---------
 *
 * Example 6:
 *
 * Enter cells: > _XXOO_OX_
 * ---------
 * |   X X |
 * | O O   |
 * | O X   |
 * ---------
 * Enter the coordinates: > one
 * You should enter numbers!
 * Enter the coordinates: > one three
 * You should enter numbers!
 * Enter the coordinates: > 1 3
 * ---------
 * | X X X |
 * | O O   |
 * | O X   |
 * ---------
 *
 * Example 7:
 *
 * Enter cells: _XXOO_OX_
 * ---------
 * |   X X |
 * | O O   |
 * | O X   |
 * ---------
 * Enter the coordinates: 4 1
 * Coordinates should be from 1 to 3!
 * Enter the coordinates: 1 4
 * Coordinates should be from 1 to 3!
 * Enter the coordinates: 1 3
 * ---------
 * | X X X |
 * | O O   |
 * | O X   |
 * ---------
 */
public class Stage4 {


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

    public static void main(String[] args) {
        System.out.print("Enter cells: ");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
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

        boolean flag = false;

        do{

            System.out.print("Enter the coordinates: ");
            String userInput = sc.nextLine();
            String intStr = userInput.replace(" ","");
            if (hasOnlyDigit(intStr) == false){
                System.out.println("You should enter numbers!");
                flag = true;
            }else{
                String [] temp = userInput.split(" ");
                int x = Integer.parseInt(temp[0]);
                int y = Integer.parseInt(temp[1]);

                if (x > 3 || x < 1 || y > 3 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    flag = true;
                }else{
                    // 이부분이 이해가 안감.
                    if (board[3-y][x-1] == 'X' || board[3-y][x-1] == 'O' ){
                        System.out.println("This cell is occupied! Choose another one!");
                        flag = true;
                    }else{
                        board[3-y][x-1] = 'X';
                        flag = false;
                    }
                }

                }

        }while(flag == true);

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
}

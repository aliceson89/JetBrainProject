/**
 * The program should calculate how much water, coffee, and milk are necessary to make the specified amount of coffee.
 * One cup of coffee made on this coffee machine contains
 * 200 ml of water,
 * 50 ml of milk, and
 * 15 g of coffee beans.
 *
 * The user should input the amount of coffee he needs, in cups, for all the guests.
 *
 * Of course, all this coffee is not needed right now, so at this stage, the coffee machine doesn’t actually make any coffee.
 */

import java.util.Scanner;
public class Stage2 {

    public static void amountIngredientCoffee(int cups){

        int water = cups*200;
        int milk = cups*50;
        int beans = cups*15;

        System.out.println("For "+cups+ " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk +" ml of milk");
        System.out.println(beans+ " g of coffee beans");

    }

    public static void main(String[] args) {
        System.out.println("Write how many cups of coffee you will need: ");
        Scanner sc = new Scanner(System.in);
        int cups = sc.nextInt();
        amountIngredientCoffee(cups);

    }
}

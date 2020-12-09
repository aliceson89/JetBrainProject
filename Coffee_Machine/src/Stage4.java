/**
 * Write the program that can do one of these actions at a time. It reads one line from standard input, which can be "buy", "fill", "take". If you want to buy some coffee, input "buy". If you are a special worker and you think that it is time to fill out all the supplies for the coffee machine, input "fill". If you are another special worker and it is time to take the money from the coffee machine, input "take".
 *
 * If the user writes "buy" then they must choose one of three varieties of coffee that the coffee machine can make: espresso, latte, or cappuccino.
 *
 *     For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
 *     For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
 *     And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
 *
 * If the user writes "fill", the program should ask them how much water, milk, coffee, and how many disposable cups they want to add to the coffee machine.
 *
 * If the user writes "take" the program should give them all the money that it earned from selling coffee.
 *
 * At the moment, the coffee machine has $550, 400 ml of water, 540 ml of milk, 120 g of coffee beans, and 9 disposable cup
 */

import java.util.Scanner;

/**
 * Example 1
 *
 * The coffee machine has:
 * 400 of water
 * 540 of milk
 * 120 of coffee beans
 * 9 of disposable cups
 * 550 of money
 *
 * Write action (buy, fill, take):
 * > buy
 * What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:
 * > 3
 *
 * The coffee machine has:
 * 200 of water
 * 440 of milk
 * 108 of coffee beans
 * 8 of disposable cups
 * 556 of money
 *
 * Example 2
 *
 * The coffee machine has:
 * 400 of water
 * 540 of milk
 * 120 of coffee beans
 * 9 of disposable cups
 * 550 of money
 *
 * Write action (buy, fill, take):
 * > fill
 * Write how many ml of water do you want to add:
 * > 2000
 * Write how many ml of milk do you want to add:
 * > 500
 * Write how many grams of coffee beans do you want to add:
 * > 100
 * Write how many disposable cups of coffee do you want to add:
 * > 10
 *
 * The coffee machine has:
 * 2400 of water
 * 1040 of milk
 * 220 of coffee beans
 * 19 of disposable cups
 * 550 of money
 *
 * Example 3
 *
 * The coffee machine has:
 * 400 of water
 * 540 of milk
 * 120 of coffee beans
 * 9 of disposable cups
 * 550 of money
 *
 * Write action (buy, fill, take):
 * > take
 * I gave you $550
 *
 * The coffee machine has:
 * 400 of water
 * 540 of milk
 * 120 of coffee beans
 * 9 of disposable cups
 * 0 of money
 */
public class Stage4 {

    public static void printStatus (int water, int milk, int beans, int cups, int money){
        System.out.println("The coffee machine has:");
        System.out.println(water+" of water");
        System.out.println(milk+" of milk");
        System.out.println(beans+" of coffee beans");
        System.out.println(cups+" of disposable cups");
        System.out.println(money+ " of money");
        System.out.println();
    }
    public static void buy (int coffee,int water, int milk, int beans, int cups, int money){
        int remainWater = 0;
        int remainMilk = 0;
        int remainBeans = 0;
        int remainCups = 0;
        int totalmoney = 0;

        switch(coffee){
            case 1 :
                remainWater = water -250;
                remainMilk = milk;
                remainBeans = beans -16;
                remainCups = cups-1;
                totalmoney = money +4;
                break;
            case 2 :
                remainWater = water -350;
                remainMilk = milk -75;
                remainBeans = beans -20;
                remainCups= cups-1;
                totalmoney = money +7;
                break;
            case 3 :
                remainWater = water -200;
                remainMilk = milk -100;
                remainBeans = beans -12;
                remainCups= cups-1;
                totalmoney = money +6;
                break;
            default:
                System.out.println("Please enter correct option 1 - espresso, 2 - latte, 3 - cappuccino:");
                break;
        }

        printStatus(remainWater,remainMilk,remainBeans,remainCups,totalmoney);

    }
    public static void fill (int coffee){

    }
    public static void take (int coffee){

    }
    public static void main(String[] args) {
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        printStatus(water,milk,beans,cups,money);
        System.out.println("Write action (buy, fill, take): ");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        switch (option){
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                int coffee = sc.nextInt();
                buy(coffee,water,milk,beans,cups,money);
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add: ");
                int addWater = sc.nextInt();
                System.out.println("Write how many ml of milk do you want to add: ");
                int addMilk = sc.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                int addBeans = sc.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                int addCups = sc.nextInt();
                System.out.println();
                printStatus(water+addWater,milk+addMilk,beans+addBeans,cups+addCups,money);
                break;
            case "take":
                System.out.println("I gave you $" + money);
                System.out.println();
                printStatus(water,milk,beans,cups,0);
                break;

            case "default":
                System.out.println("Please select correct option buy/fill/take");
                break;
        }

    }
}

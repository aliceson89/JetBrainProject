/**
 * Write action (buy, fill, take, remaining, exit):
 * > remaining
 *
 * The coffee machine has:
 * 400 of water
 * 540 of milk
 * 120 of coffee beans
 * 9 of disposable cups
 * $550 of money
 *
 * Write action (buy, fill, take, remaining, exit):
 * > buy
 *
 * What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
 * > 2
 * I have enough resources, making you a coffee!
 *
 * Write action (buy, fill, take, remaining, exit):
 * > remaining
 *
 * The coffee machine has:
 * 50 of water
 * 465 of milk
 * 100 of coffee beans
 * 8 of disposable cups
 * $557 of money
 *
 * Write action (buy, fill, take, remaining, exit):
 * > buy
 *
 * What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
 * > 2
 * Sorry, not enough water!
 *
 * Write action (buy, fill, take, remaining, exit):
 * > fill
 *
 * Write how many ml of water do you want to add:
 * > 1000
 * Write how many ml of milk do you want to add:
 * > 0
 * Write how many grams of coffee beans do you want to add:
 * > 0
 * Write how many disposable cups of coffee do you want to add:
 * > 0
 *
 * Write action (buy, fill, take, remaining, exit):
 * > remaining
 *
 * The coffee machine has:
 * 1050 of water
 * 465 of milk
 * 100 of coffee beans
 * 8 of disposable cups
 * $557 of money
 *
 * Write action (buy, fill, take, remaining, exit):
 * > buy
 *
 * What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
 * > 2
 * I have enough resources, making you a coffee!
 *
 * Write action (buy, fill, take, remaining, exit):
 * > remaining
 *
 * The coffee machine has:
 * 700 of water
 * 390 of milk
 * 80 of coffee beans
 * 7 of disposable cups
 * $564 of money
 *
 * Write action (buy, fill, take, remaining, exit):
 * > take
 *
 * I gave you $564
 *
 * Write action (buy, fill, take, remaining, exit):
 * > remaining
 *
 * The coffee machine has:
 * 700 of water
 * 390 of milk
 * 80 of coffee beans
 * 7 of disposable cups
 * 0 of money
 *
 * Write action (buy, fill, take, remaining, exit):
 * > exit
 */

import java.util.Scanner;
public class Stage5 {

    public static void printStatus (int water, int milk, int beans, int cups, int money){
        System.out.println("The coffee machine has:");
        System.out.println(water+" of water");
        System.out.println(milk+" of milk");
        System.out.println(beans+" of coffee beans");
        System.out.println(cups+" of disposable cups");
        System.out.println(money+ " of money");
        System.out.println();
    }


    public static void main(String[] args) {
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String option = sc.next();
            switch (option) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                    //Probably you have nextInt() (or similar Scanner method) followed by nextLine() - in this situation nextLine() often gives an empty string and another one nextLine() call gives correct string.
                    String coffee = sc.next();

                    switch(coffee){
                        case "1" :
                            if ((water >= 250)&&(beans >= 16)&&(cups>= 1)){
                                System.out.println("I have enough resources, making you a coffee!");
                                water = water -250;
                                milk = milk;
                                beans = beans -16;
                                cups = cups-1;
                                money = money +4;
                            }else{
                                if (water < 250){
                                    System.out.println("Sorry, not enough water!");
                                }else if (beans < 16){
                                    System.out.println("Sorry, not enough coffee beans!");
                                }else{
                                    System.out.println("Sorry, not enough disposable cups!");
                                }

                            }

                            break;
                        case "2" :
                            if ((water >= 350)&&(milk >= 75)&&(beans >= 20)&&(cups>= 1)){
                                System.out.println("I have enough resources, making you a coffee!");
                                water = water -350;
                                milk = milk -75;
                                beans = beans -20;
                                cups= cups-1;
                                money = money +7;
                            }else{
                                if (water < 350){
                                    System.out.println("Sorry, not enough water!");
                                }else if(milk <75){
                                    System.out.println("Sorry, not enough coffee milk!");
                                }else if (beans < 20){
                                    System.out.println("Sorry, not enough coffee beans!");
                                }else{
                                    System.out.println("Sorry, not enough disposable cups!");
                                }
                            }

                            break;
                        case "3" :
                            if ((water >= 200)&&(milk >= 100)&&(beans >= 12)&&(cups>= 1)){
                                System.out.println("I have enough resources, making you a coffee!");
                                water = water -200;
                                milk = milk -100;
                                beans = beans -12;
                                cups= cups-1;
                                money = money +6;
                            }else{
                                if (water < 200){
                                    System.out.println("Sorry, not enough water!");
                                }else if(milk < 100){
                                    System.out.println("Sorry, not enough coffee milk!");
                                }else if (beans < 12){
                                    System.out.println("Sorry, not enough coffee beans!");
                                }else{
                                    System.out.println("Sorry, not enough disposable cups!");
                                }
                            }

                            break;

                        default:
                            System.out.println("Please enter correct option 1 - espresso, 2 - latte, 3 - cappuccino:");
                            break;
                    }
                    System.out.println();
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
                    water = water + addWater;
                    milk = milk + addMilk;
                    beans = beans +addBeans;
                    cups = cups +addCups;
                    break;
                case "take":
                    System.out.println();
                    System.out.println("I gave you $" + money);
                    System.out.println();
                    money = 0;
                    break;
                case "remaining":
                    printStatus(water,milk,beans,cups,money);
                    break;
                case "exit":
                    flag = false;
                    break;
                case "default":
                    System.out.println("Please select correct option buy/fill/take");
                    break;
            }
        }while(flag);

    }
}



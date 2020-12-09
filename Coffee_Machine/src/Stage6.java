import java.util.Scanner;

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
 * $0 of money
 *
 * Write action (buy, fill, take, remaining, exit):
 * > exit
 */
public class Stage6 {

    public static class Coffee{
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        public Coffee() {
            this.water = water;
            this.milk = milk;
            this.beans = beans;
            this.cups = cups;
            this.money = money;
        }

        public Coffee(int water, int milk, int beans, int cups, int money) {
            this.water = water;
            this.milk = milk;
            this.beans = beans;
            this.cups = cups;
            this.money = money;
        }

        public int getWater() {
            return water;
        }

        public int getMilk() {
            return milk;
        }

        public int getBeans() {
            return beans;
        }

        public int getCups() {
            return cups;
        }

        public int getMoney() {
            return money;
        }

        public static void printStatus (int water, int milk, int beans, int cups, int money){
            System.out.println();
            System.out.println("The coffee machine has:");
            System.out.println(water+" of water");
            System.out.println(milk+" of milk");
            System.out.println(beans+" of coffee beans");
            System.out.println(cups+" of disposable cups");
            System.out.println(money+ " of money");
            System.out.println();
        }
        public static Coffee buy (String coffee, Coffee coffeeMachine){
            switch(coffee){
                case "1" :
                    if ((coffeeMachine.getWater() >= 250)&&(coffeeMachine.getBeans()>= 16)&&(coffeeMachine.getCups()>= 1)){
                        System.out.println("I have enough resources, making you a coffee!");
                        coffeeMachine.water = coffeeMachine.water -250;
                        coffeeMachine.milk = coffeeMachine.milk;
                        coffeeMachine.beans = coffeeMachine.beans -16;
                        coffeeMachine.cups = coffeeMachine.cups-1;
                        coffeeMachine.money = coffeeMachine.money +4;
                    }else{
                        if (coffeeMachine.water < 250){
                            System.out.println("Sorry, not enough water!");
                        }else if (coffeeMachine.beans < 16){
                            System.out.println("Sorry, not enough coffee beans!");
                        }else{
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                    }

                    break;
                case "2" :
                    if ((coffeeMachine.water >= 350)&&(coffeeMachine.milk >= 75)&&(coffeeMachine.beans >= 20)&&(coffeeMachine.cups>= 1)){
                        System.out.println("I have enough resources, making you a coffee!");
                        coffeeMachine.water = coffeeMachine.water -350;
                        coffeeMachine.milk = coffeeMachine.milk -75;
                        coffeeMachine.beans = coffeeMachine.beans -20;
                        coffeeMachine.cups= coffeeMachine.cups-1;
                        coffeeMachine.money = coffeeMachine.money +7;
                    }else{
                        if (coffeeMachine.water < 350){
                            System.out.println("Sorry, not enough water!");
                        }else if(coffeeMachine.milk <75){
                            System.out.println("Sorry, not enough coffee milk!");
                        }else if (coffeeMachine.beans < 20){
                            System.out.println("Sorry, not enough coffee beans!");
                        }else{
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                    }

                    break;
                case "3" :
                    if ((coffeeMachine.water >= 200)&&(coffeeMachine.milk >= 100)&&(coffeeMachine.beans >= 12)&&(coffeeMachine.cups>= 1)){
                        System.out.println("I have enough resources, making you a coffee!");
                        coffeeMachine.water = coffeeMachine.water -200;
                        coffeeMachine.milk = coffeeMachine.milk -100;
                        coffeeMachine.beans = coffeeMachine.beans -12;
                        coffeeMachine.cups= coffeeMachine.cups-1;
                        coffeeMachine.money = coffeeMachine.money +6;
                    }else{
                        if (coffeeMachine.water < 200){
                            System.out.println("Sorry, not enough water!");
                        }else if(coffeeMachine.milk < 100){
                            System.out.println("Sorry, not enough coffee milk!");
                        }else if (coffeeMachine.beans < 12){
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
            return coffeeMachine;
        }
        public static Coffee fill (int addWater, int addMilk, int addBeans, int addCups, Coffee coffeeMachine){
            coffeeMachine.water = coffeeMachine.water + addWater;
            coffeeMachine.milk = coffeeMachine.milk + addMilk;
            coffeeMachine.beans = coffeeMachine.beans +addBeans;
            coffeeMachine.cups = coffeeMachine.cups +addCups;

            return coffeeMachine;
        }
    }
    public static void main(String[] args) {

        Coffee coffeeMachine = new Coffee();

        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String option = sc.next();

            switch (option) {
                case "buy":
                    System.out.println();
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                    //Probably you have nextInt() (or similar Scanner method) followed by nextLine() - in this situation nextLine() often gives an empty string and another one nextLine() call gives correct string.
                    String coffee = sc.next();
                    coffeeMachine=coffeeMachine.buy(coffee,coffeeMachine);
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
                    coffeeMachine = coffeeMachine.fill(addWater,addMilk,addBeans,addCups,coffeeMachine);
                    break;
                case "take":
                    System.out.println();
                    System.out.println("I gave you $" + coffeeMachine.money);
                    System.out.println();
                    coffeeMachine.money = 0;
                    break;
                case "remaining":
                    coffeeMachine.printStatus(coffeeMachine.water,coffeeMachine.milk,coffeeMachine.beans,coffeeMachine.cups,coffeeMachine.money);
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

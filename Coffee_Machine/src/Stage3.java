import java.util.Scanner;

/**
 * the coffee machine needs 200 ml of water, 50 ml of milk, and 15 g of coffee beans to make one cup of coffee.
 * Example 1
 *
 * Write how many ml of water the coffee machine has:
 * > 300
 * Write how many ml of milk the coffee machine has:
 * > 65
 * Write how many grams of coffee beans the coffee machine has:
 * > 100
 * Write how many cups of coffee you will need:
 * > 1
 * Yes, I can make that amount of coffee
 *
 * Example 2
 *
 * Write how many ml of water the coffee machine has:
 * > 500
 * Write how many ml of milk the coffee machine has:
 * > 250
 * Write how many grams of coffee beans the coffee machine has:
 * > 200
 * Write how many cups of coffee you will need:
 * > 10
 * No, I can make only 2 cup(s) of coffee
 *
 * Example 3
 *
 * Write how many ml of water the coffee machine has:
 * > 1550
 * Write how many ml of milk the coffee machine has:
 * > 299
 * Write how many grams of coffee beans the coffee machine has:
 * > 300
 * Write how many cups of coffee you will need:
 * > 3
 * Yes, I can make that amount of coffee (and even 2 more than that)
 *
 * Example 4
 *
 * Write how many ml of water the coffee machine has:
 * > 0
 * Write how many ml of milk the coffee machine has:
 * > 0
 * Write how many grams of coffee beans the coffee machine has:
 * > 0
 * Write how many cups of coffee you will need:
 * > 1
 * No, I can make only 0 cup(s) of coffee
 *
 * Example 5
 *
 * Write how many ml of water the coffee machine has:
 * > 0
 * Write how many ml of milk the coffee machine has:
 * > 0
 * Write how many grams of coffee beans the coffee machine has:
 * > 0
 * Write how many cups of coffee you will need:
 * > 0
 * Yes, I can make that amount of coffee
 *
 * Example 6
 *
 * Write how many ml of water the coffee machine has:
 * > 200
 * Write how many ml of milk the coffee machine has:
 * > 50
 * Write how many grams of coffee beans the coffee machine has:
 * > 15
 * Write how many cups of coffee you will need:
 * > 0
 * Yes, I can make that amount of coffee (and even 1 more than that)
 */
public class Stage3 {

    public static int min (int a, int b, int c){
        int temp1 = (a > b)? b:a;
        int temp2 = (temp1 > c)?c:temp1;
        return temp2;

    }
    public static void availabilityCoffeeMake(int water, int milk, int beans, int cups){
        //200 ml of water, 50 ml of milk, and 15 g of coffee beans
        int needWater= cups*200;
        int needMilk = cups*50;
        int needBeans = cups*15;
        int availableCoffee1 = 0;
        int availableCoffee2 = 0;
        int availableCoffee3 = 0;
        int availableCoffee = 0;
        int moreCoffee = 0;
        if (cups == 0){

            availableCoffee1 = water/200;
            availableCoffee2 = milk/50;
            availableCoffee3 = beans/15;
            availableCoffee = min(availableCoffee1,availableCoffee2,availableCoffee3);
            if (availableCoffee >0 ){
                System.out.println("Yes, I can make that amount of coffee (and even "+availableCoffee+" more than that)");
            }else{
                System.out.println("Yes, I can make that amount of coffee");
            }
        }else if((water > needWater)&&(milk > needMilk)&&(beans > needBeans)){
            availableCoffee1 = water/200;
            availableCoffee2 = milk/50;
            availableCoffee3 = beans/15;
            availableCoffee = min(availableCoffee1,availableCoffee2,availableCoffee3);
            moreCoffee = availableCoffee - cups;
            if(moreCoffee == 0){
                System.out.println("Yes, I can make that amount of coffee");
            }else{
                System.out.println("Yes, I can make that amount of coffee (and even "+moreCoffee+" more than that)");
            }

        }else{
            availableCoffee1 = water/200;
            availableCoffee2 = milk/50;
            availableCoffee3 = beans/15;
            availableCoffee = min(availableCoffee1,availableCoffee2,availableCoffee3);
            if (availableCoffee == 0){
                System.out.println("No, I can make only 0 cup(s) of coffee");
            }else{
                System.out.println("No, I can make only "+availableCoffee+" cup(s) of coffee");
            }

        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int availWater = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int availMilk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int availBeans = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int needCups = sc.nextInt();
        availabilityCoffeeMake(availWater,availMilk,availBeans,needCups);

    }
}

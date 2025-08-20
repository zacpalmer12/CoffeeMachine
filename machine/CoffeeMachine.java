package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        while (true) {
            System.out.println("Write action (buy, fill, take,remaining, exit):");
            String strInput = sc.next();

            switch (strInput) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1 -> {
                            water -= 250;
                            beans -= 16;
                            money += 4;
                            cups -= 1;
                        }
                        case 2 -> {
                            water -= 350;
                            milk -= 75;
                            beans -= 20;
                            money += 7;
                            cups -= 1;
                        }
                        case 3 -> {
                            water -= 200;
                            milk -= 100;
                            beans -= 12;
                            money += 6;
                            cups -= 1;
                        }
                    }
                    break; // break OUT of "buy", return to outer loop

                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    water += sc.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    milk += sc.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    beans += sc.nextInt();
                    System.out.println("Write how many disposable cups you want to add:");
                    cups += sc.nextInt();
                    break;

                case "take":
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;

                case "remaining":
                    System.out.println("""
                            The coffee machine has:
                            """ + water + " ml of water\n" +
                            milk + " ml of milk\n" +
                            beans + " g of coffee beans\n" +
                            cups + " disposable cups\n" +
                            "$" + money + " of money");
                    break;

                case "exit":
                    return; // end program
            }
        }
    }
}

//package machine;
//import java.util.Scanner;
//
//public class CoffeeMachine {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Write how many ml of water the coffee machine has:");
//        int waterAmount = sc.nextInt();
//
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        int milkAmount = sc.nextInt();
//
//        System.out.println("Write how many grams of coffee beans the coffee machine has:");
//        int beansAmount = sc.nextInt();
//
//        System.out.println("Write how many cups of coffee you will need:");
//        int cupsAmount = sc.nextInt();
//
//        // how many cups possible from each ingredient
//        int cupsFromWater = waterAmount / 200;
//        int cupsFromMilk = milkAmount / 50;
//        int cupsFromBeans = beansAmount / 15;
//
//        // limiting factor
//        int maxCups = Math.min(cupsFromWater, Math.min(cupsFromMilk, cupsFromBeans));
//
//        if (cupsAmount > maxCups) {
//            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
//        } else if (cupsAmount == maxCups) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else {
//            System.out.println("Yes, I can make that amount of coffee (and even "
//                    + (maxCups - cupsAmount) + " more than that)");
//        }
//
//        sc.close();
//    }
//}

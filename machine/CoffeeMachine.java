package machine;
import java.util.Scanner;  // Import the Scanner class


public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("""
                The coffee machine has:
                400 ml of water
                540 ml of milk
                120 g of coffee beans
                9 disposable cups
                $550 of money
                """);

        System.out.println("Write action (buy, fill, take):");
        String strInput = sc.nextLine(); // available water

        switch (strInput) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("""
                                The coffee machine has:
                                150 ml of water
                                540 ml of milk
                                104 g of coffee beans
                                8 disposable cups
                                $554 of money""");
                        break;
                    case 2:
                        System.out.println("""
                                The coffee machine has:
                                50 ml of water
                                465 ml of milk
                                100 g of coffee beans
                                8 disposable cups
                                $557 of money""");
                        break;
                    case 3:
                        System.out.println("""
                                The coffee machine has:
                                200 ml of water
                                440 ml of milk
                                108 g of coffee beans
                                8 disposable cups
                                $556 of money""");
                        break;

                }
                break;
            case "fill":
                int water = 400;
                int milk = 540;
                int beans = 120;
                int cups = 9;

                System.out.println("Write how many ml of water you want to add:");
                int waterAmount = sc.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                int milkAmount = sc.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                int beansAmount = sc.nextInt();
                System.out.println("Write how many disposable cups you want to add:");
                int cupsAmount = sc.nextInt();

                System.out.println("The coffee machine has:\n" +
                        (water + waterAmount) + " ml of water\n"+
                        (milk+milkAmount)+" ml of milk\n"+
                        (beans+beansAmount)+" of coffee beans\n"+
                         (cups+cupsAmount)+" disposable cups\n550$ of money");
                sc.close();
                break;
            case "take":
                System.out.println("I gave you " + 550);
                System.out.println("""
                        The coffee machine has:
                        400 ml of water
                        540 ml of milk
                        120 g of coffee beans
                        9 disposable cups
                        $0 of money""");
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

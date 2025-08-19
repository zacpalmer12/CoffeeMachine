package machine;
import java.util.Scanner;  // Import the Scanner class


public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int waterAmount = sc.nextInt(); // available water
        int milkAmount = sc.nextInt();  // available milk
        int beansAmount = sc.nextInt(); // available beans
        int cupsAmount = sc.nextInt();  // cups requested

        // how many cups possible from each ingredient
        int cupsFromWater = waterAmount / 300;
        int cupsFromMilk = milkAmount / 65;
        int cupsFromBeans = beansAmount / 100;

        // limiting factor
        int maxCups = Math.min(cupsFromWater, Math.min(cupsFromMilk, cupsFromBeans));

        if (cupsAmount > maxCups) {
            System.out.println("No, I can only make " + maxCups + " cup(s) of coffee");
        } else if (cupsAmount == maxCups) {
            System.out.println("Yes, I can make that amount of coffee");
        }else{
            System.out.println("Yes, I can make that amount of coffee (and even " + (maxCups-cupsAmount)+" more than that)");
        }

        sc.close();
    }

}
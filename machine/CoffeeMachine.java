package machine;

import java.util.Scanner;

class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;
    private int coffeesMade = 0; // track coffees made for cleaning
    private boolean needsCleaning = false;

    private final Coffee espresso = new Coffee(250, 0, 16, 4);
    private final Coffee latte = new Coffee(350, 75, 20, 7);
    private final Coffee cappuccino = new Coffee(200, 100, 12, 6);

    private final Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String action = sc.nextLine().trim();

            switch (action) {
                case "buy" -> buyCoffee();
                case "fill" -> fill();
                case "take" -> take();
                case "remaining" -> remaining();
                case "clean" -> clean();
                case "exit" -> {
                    return;
                }
                default -> System.out.println("Unknown action!");
            }
        }
    }

    private void buyCoffee() {
        if (needsCleaning) {
            System.out.println("I need cleaning!");
            return;
        }

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = sc.nextLine().trim();

        Coffee selectedCoffee = switch (choice) {
            case "1" -> espresso;
            case "2" -> latte;
            case "3" -> cappuccino;
            default -> null;
        };

        if (choice.equals("back")) return;
        if (selectedCoffee == null) return;

        String missing = checkResources(selectedCoffee);
        if (!missing.isEmpty()) {
            System.out.println("Sorry, not enough " + missing + "!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= selectedCoffee.water;
            milk -= selectedCoffee.milk;
            beans -= selectedCoffee.beans;
            cups -= 1;
            money += selectedCoffee.cost;

            coffeesMade++;
            if (coffeesMade >= 10) {
                needsCleaning = true;
            }
        }
    }

    private String checkResources(Coffee coffee) {
        StringBuilder missing = new StringBuilder();
        if (water < coffee.water) missing.append("water ");
        if (milk < coffee.milk) missing.append("milk ");
        if (beans < coffee.beans) missing.append("beans ");
        if (cups < 1) missing.append("cups ");
        return missing.toString().trim();
    }

    private void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += sc.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cups += sc.nextInt();
        sc.nextLine(); // consume newline
    }

    private void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println("Coffees made since last cleaning: " + coffeesMade);
        if (needsCleaning) System.out.println("The machine needs cleaning!");
    }

    private void clean() {
        if (needsCleaning) {
            coffeesMade = 0;
            needsCleaning = false;
            System.out.println("The coffee machine has been cleaned!");
        } else {
            System.out.println("Cleaning is not needed right now.");
        }
    }
}
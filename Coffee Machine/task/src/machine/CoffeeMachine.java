package machine;

import java.util.Scanner;

public class CoffeeMachine {
    Scanner scanner = new Scanner(System.in);

    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    boolean exit = false;

    void action() {
        while (!exit) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit) : ");
            String usrChoice = scanner.nextLine();
            switch (usrChoice) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
                case "exit":
                    exit = true;
                    break;
            }
        }
    }

    private void remaining() {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    private void take() {
        System.out.println("I gave you $" + money);
        money -= money;
    }

    private void fill() {
        System.out.println("Write how many ml of water do you want to add: ");
        int addedWater = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        int addedMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int addedBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int addedCups = scanner.nextInt();

        water += addedWater;
        milk += addedMilk;
        beans += addedBeans;
        cups += addedCups;
    }

    private void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, " +
                "3 - cappuccino, back - to main menu: ");
        String buyer1 = scanner.nextLine();

        switch (buyer1) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappuccino();
                break;
            case "back":
                break;

        }

    }

    private void makeCappuccino() {
        boolean capWater = water - 200 >= 0;
        boolean capMilk = milk - 100 >= 0;
        boolean capBeans = beans - 12 >= 0;
        boolean capCups = cups - 1 >= 0;

        if (capWater && capMilk && capBeans && capCups) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 200;
            milk -= 100;
            beans -= 12;
            cups -= 1;
            money += 6;
        } else if (!capWater) {
            System.out.println("Sorry, not enough water!");
        } else if (!capMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (!capBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("Sorry, not enough disposable cup");
        }
    }

    private void makeLatte() {
        boolean latWater = water - 350 >= 0;
        boolean latMilk = milk - 75 >= 0;
        boolean latBeans = beans - 20 >= 0;
        boolean latCups = cups - 1 >= 0;

        if (latWater && latMilk && latBeans && latCups) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 350;
            milk -= 75;
            beans -= 20;
            cups--;
            money += 7;
        } else if (!latWater) {
            System.out.println("Sorry, not enough water!");
        } else if (!latMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (!latBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("Sorry, not enough disposable cup!");
        }
    }

    private void makeEspresso() {
        boolean espWater = water - 250 >= 0;
        boolean espBeans = beans - 16 >= 0;
        boolean espCups = cups - 1 >= 0;

        if (espWater && espBeans && espCups) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 250;
            beans -= 16;
            cups -= 1;
            money += 4;
        } else if (!espWater) {
            System.out.println("Sorry, not enough water!");
        } else if (!espBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("Sorry, not enough disposable cup!");
        }
    }


    public static void main(String[] args) {
        CoffeeMachine starbucks = new CoffeeMachine();
        starbucks.action();


    }
}

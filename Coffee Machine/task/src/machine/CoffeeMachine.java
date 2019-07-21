package machine;
import java.util.Scanner;
import java.util.Arrays;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int waterPerCupCoffee = 200; // milileters
        final int milkPerCupCoffee  = 50; // milileters
        final int beansPerCupCoffee = 15; // grams
        int waterAvailable;
        int milkAvailable;
        int beansAvailable;
        int cupsRequested;
        int waterForRequest;
        int milkForRequest;
        int beansForRequest;
        int cupsCoffeePossible;
        int cupsPerIngredient[] = new int[3];
        int cupsRemaining;


        System.out.println("Enter how many ml of water the coffee machine has:");
        waterAvailable = scanner.nextInt();

        System.out.println("Enter how many ml of milk the coffee machine has:");
        milkAvailable = scanner.nextInt();

        System.out.println("Enter how many grams of coffee beans the coffee machine has:");
        beansAvailable = scanner.nextInt();

        System.out.println("Enter how many cups of coffee you will need:");
        cupsRequested = scanner.nextInt();

        waterForRequest = waterPerCupCoffee * cupsRequested;
        milkForRequest = milkPerCupCoffee * cupsRequested;
        beansForRequest = beansPerCupCoffee * cupsRequested;

        cupsPerIngredient[0] = waterAvailable / waterPerCupCoffee;
        cupsPerIngredient[1] = milkAvailable / milkPerCupCoffee;
        cupsPerIngredient[2] = beansAvailable / beansPerCupCoffee;
        Arrays.sort(cupsPerIngredient);

        cupsCoffeePossible = cupsPerIngredient[0];
        cupsRemaining = cupsCoffeePossible - cupsRequested;

        if (cupsCoffeePossible == cupsRequested) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsCoffeePossible > cupsRequested) {
            System.out.println("Yes, I can make that amount of coffee ( and even " +
                                cupsRemaining + " more than that)" );
        } else {
            System.out.println("No, I can make only" + cupsCoffeePossible +
                    " cups(s) of coffee");
        }
    }
}

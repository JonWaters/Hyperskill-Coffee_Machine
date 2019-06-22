package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        int waterPerCupCoffee = 200; // milileters
        int milkPerCupCoffee  = 50; // milileters
        int beansPerCupCoffee = 15; // grams
        int numCupsRequested;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter how many cups of coffee you will need: ");
        numCupsRequested = scanner.nextInt();

        System.out.println("\nFor" + numCupsRequested + " cups of coffee you will need:");
        System.out.println(waterPerCupCoffee * numCupsRequested + " ml of water");
        System.out.println(milkPerCupCoffee * numCupsRequested + " ml of milk");
        System.out.println(beansPerCupCoffee * numCupsRequested + " g of coffee beans");
    }
}

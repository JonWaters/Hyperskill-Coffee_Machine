package machine;
import java.util.*;

public class CoffeeMachine {
    private static Scanner scanner;
    private static HashMap<String, Integer> machineResources;
    private static HashMap<String, Integer> espressoResources;
    private static HashMap<String, Integer> latteResources;
    private static HashMap<String, Integer> cappuccinoResources;

    private static void displayMachineStatus() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(machineResources.get("water") + " of water");
        System.out.println(machineResources.get("milk") + " of milk");
        System.out.println(machineResources.get("beans") + " of coffee beans");
        System.out.println(machineResources.get("cups") + " of disposable cups");
        System.out.println(machineResources.get("money") + " of money\n");
    }

    private static String getUserAction() {
        System.out.print("Write action (buy, fill, take): ");
        String userInput = scanner.nextLine();
        return userInput;
    }

    private static void makeCoffee(HashMap<String, Integer> coffeeType) {
        machineResources.put("water", machineResources.get("water") -
                coffeeType.get("water"));
        machineResources.put("beans", machineResources.get("beans") -
                coffeeType.get("beans"));
        machineResources.put("milk", machineResources.get("milk") -
                coffeeType.get("milk"));
        machineResources.put("money", machineResources.get("money") +
                coffeeType.get("money"));
        machineResources.put("cups", machineResources.get("cups") -
                coffeeType.get("cups"));
    }

    private static void buyCoffee() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                makeCoffee(espressoResources);
                break;
            case 2:
                makeCoffee(latteResources);
                break;
            case 3:
                makeCoffee(cappuccinoResources);
                break;
        }
    }

    private static void fillMachine() {
        System.out.print("Write how many ml of water do you want to add: ");
        int additionalWater = scanner.nextInt();
        System.out.print("Write how many ml of milk do you want to add: ");
        int additionalMilk = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        int additionalBeans = scanner.nextInt();
        System.out.print("Write how many disposable cups of do you want to add: ");
        int additionalCups = scanner.nextInt();

        machineResources.put("water", machineResources.get("water") + additionalWater);
        machineResources.put("milk", machineResources.get("milk") + additionalMilk);
        machineResources.put("beans", machineResources.get("beans") + additionalBeans);
        machineResources.put("cups", machineResources.get("cups") + additionalCups);
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + machineResources.get("money") + "\n");
        machineResources.put("money", 0);
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        machineResources = new HashMap<>();
        machineResources.put("water", 1200); // milliliters
        machineResources.put("milk", 540); // milliliters
        machineResources.put("beans", 120); // grams
        machineResources.put("money", 550); // US dollars
        machineResources.put("cups", 9); // disposable drinking cups

        espressoResources = new HashMap<>();
        espressoResources.put("water", 250); // milliliters
        espressoResources.put("milk", 0); // milliliters
        espressoResources.put("beans", 16); // grams
        espressoResources.put("money", 4); // US dollars
        espressoResources.put("cups", 1); // disposable drinking cups

        latteResources = new HashMap<>();
        latteResources.put("water", 350); // milliliters
        latteResources.put("milk", 75); // milliliters
        latteResources.put("beans", 20); // grams
        latteResources.put("money", 7); // US dollars
        latteResources.put("cups", 1); // disposable drinking cups

        cappuccinoResources = new HashMap<>();
        cappuccinoResources.put("water", 200); // milliliters
        cappuccinoResources.put("milk", 100); // milliliters
        cappuccinoResources.put("beans", 12); // grams
        cappuccinoResources.put("money", 6); // US dollars
        cappuccinoResources.put("cups", 1); // disposable drinking cups


        displayMachineStatus();

        String userAction = getUserAction();

        switch (userAction) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                takeMoney();
                break;
        }

        displayMachineStatus();
    }
}
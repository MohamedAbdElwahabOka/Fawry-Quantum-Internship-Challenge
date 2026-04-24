import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car myCar = null;
        boolean running = true;

        System.out.println("=========================================");
        System.out.println("  Welcome to Fawry Quantum Car Factory!  ");
        System.out.println("=========================================");

        while (running) {
            System.out.println("\n-----------------------------------------");
            System.out.println("Please choose an action:");
            System.out.println("1. Create a Car / Replace Engine");
            System.out.println("2. Start Car");
            System.out.println("3. Accelerate (+20 km/h)");
            System.out.println("4. Brake (-20 km/h)");
            System.out.println("5. Stop Car");
            System.out.println("0. Exit Factory");
            System.out.print("Your choice: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("\nSelect Engine Type: [1] GAS  [2] ELECTRIC  [3] HYBRID");
                    System.out.print("Engine choice: ");
                    String engineChoice = scanner.nextLine();
                    
                    EngineType selectedType = null;
                    if (engineChoice.equals("1")) selectedType = EngineType.GAS;
                    else if (engineChoice.equals("2")) selectedType = EngineType.ELECTRIC;
                    else if (engineChoice.equals("3")) selectedType = EngineType.HYBRID;

                    if (selectedType != null) {
                        if (myCar == null) {
                            myCar = CarFactory.createCar(selectedType);
                            System.out.println("=> A new car has been manufactured!");
                        } else {
                            CarFactory.replaceEngine(myCar, selectedType);
                        }
                    } else {
                        System.out.println("=> Invalid engine choice. Try again.");
                    }
                    break;
                case "2":
                    if (myCar != null) myCar.start();
                    else System.out.println("=> Please create a car first (Option 1)!");
                    break;
                case "3":
                    if (myCar != null) myCar.accelerate();
                    else System.out.println("=> Please create a car first (Option 1)!");
                    break;
                case "4":
                    if (myCar != null) myCar.brake();
                    else System.out.println("=> Please create a car first (Option 1)!");
                    break;
                case "5":
                    if (myCar != null) myCar.stop();
                    else System.out.println("=> Please create a car first (Option 1)!");
                    break;
                case "0":
                    running = false;
                    System.out.println("=> Shutting down the factory. Goodbye!");
                    break;
                default:
                    System.out.println("=> Invalid choice. Please enter a number from 0 to 5.");
            }
        }
        scanner.close();
    }
}
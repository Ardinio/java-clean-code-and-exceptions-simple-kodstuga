import java.util.InputMismatchException;
import java.util.Scanner;

public class Robotcafe {
    static String[] products = {"Kaffe", "Te", "Bulle", "Energidryck"};

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        printMenu();

        while (true) {
            System.out.println("\nAnvänd siffrorna 1-4 för att välja en product och 0 för att avsluta programmet");
            int userChoice = -1;
            try {
                userChoice = userInput.nextInt();
                if (userChoice != 0 && userChoice < products.length) {
                    readMenuChoice(userChoice);
                }
                else if (userChoice == 0) {
                    System.out.println("Då avsultas programmet");
                    break;
                }
                else {
                    System.out.print("Du försökte att välja ett alternativ som inte finns");
                }
            } catch (InputMismatchException e) {
                System.out.println("Du kan bara skriva in nummer, testa igen");
            }
        }
    }

    static void printMenu() {
        System.out.print("Du sitter inne på ett Robot cafe och ska beställa en vara, välj mellan: ");
        for (String product : products) {
            System.out.print(product + " ");
        } 
    }

    static void validateRobotCode(int code) {
        if (code < 1000 || code > 9999) {
            throw new IllegalArgumentException("Koden måste vara fyr siffirg programmet börjar om igen");
        }
        else {
            System.out.println("Din order har nu beställts och konformerats");
        }
    }

    static void readMenuChoice(int choice) {
        Scanner userSecretCode = new Scanner(System.in);

        int numberToSubtractWithToGetTheRightIndexInTheArray = 1;

        System.out.println("Du har valt att beställa: " + products[choice - numberToSubtractWithToGetTheRightIndexInTheArray]);
        System.out.println("Skriv in en fyr siffrig kod för att konfirmera beställningen");
        try {
            validateRobotCode(userSecretCode.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Du kan bara skriva in nummer, programmet börjar om igen");
        }
    }
}
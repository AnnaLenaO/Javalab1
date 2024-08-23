package electricity.prices;

import electricity.prices.menu.MenuLine;
import electricity.prices.menu.PrintMenu;
import electricity.prices.menu.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userMenuOption = readUserInput(sc);
    }

    public static String readUserInput(Scanner sc) {
        String userMenuOption = "";
        boolean isValidOption;

        while (true) {
            new PrintMenu();
            System.out.println("\nVälj ett alternativ");
            userMenuOption = sc.nextLine();

            isValidOption = false;

            for (MenuLine line : Menu.getMenuLines()) {
                if (userMenuOption.equals(line.getOption())) {
                    isValidOption = true;
                    break;
                }
            }
            if (!isValidOption) {
                System.out.println("Ogiltigt val, försök igen.\n");
            } else {
                break;
            }
        }
        return userMenuOption;
    }
}

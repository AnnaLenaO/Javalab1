package electricity.prices.user.options;

import electricity.prices.menu.Menu;
import electricity.prices.menu.MenuLine;
import electricity.prices.menu.PrintMenu;

import java.util.Scanner;

public class ReadUserInput {
    private final Scanner sc;

    public ReadUserInput() {
        this.sc = new Scanner(System.in);
    }

    public String readUserOption() {
        String userMenuOption;
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

    public void closeScanner() {
        sc.close();
    }
}

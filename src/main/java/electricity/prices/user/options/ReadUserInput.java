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

    public UserOptionResult readUserOption() {
        String userMenuOption;

        while (true) {
            new PrintMenu();
            System.out.println("\nVälj ett alternativ");
            userMenuOption = sc.nextLine();

            for (MenuLine line : Menu.getMenuLines()) {
                if (userMenuOption.equals(line.getOption())) {
                    return new UserOptionResult(userMenuOption, line.getTitle());
                }
            }

            System.out.println("Ogiltigt val, försök igen.\n");
        }
    }

    public void closeScanner() {
        sc.close();
    }
}

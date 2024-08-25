package electricity.prices.user.options;

import electricity.prices.menu.Menu;
import electricity.prices.menu.MenuLine;
import electricity.prices.menu.PrintMenu;

import java.util.Scanner;

public class ReadUserOption {
    private final Scanner sc;

    public ReadUserOption(Scanner sc) {
        this.sc = sc;
    }

    public UserOptionResult readUserOption() {
        String userMenuOption;

        while (true) {
            new PrintMenu();
            System.out.println("\nVälj ett alternativ");
            userMenuOption = sc.nextLine();

            for (MenuLine line : Menu.getMenuLines()) {
                if (line.isSelectable() && userMenuOption.equalsIgnoreCase(line.getOption())) {
                    return new UserOptionResult(userMenuOption, line.getTitle(), line.getClassName());
                }
            }
            System.out.println("Ogiltigt val, försök igen");
        }
    }
}

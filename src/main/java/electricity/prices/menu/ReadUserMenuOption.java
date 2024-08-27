package electricity.prices.menu;

import java.util.Scanner;

public class ReadUserMenuOption {
    private final Scanner sc;

    public ReadUserMenuOption(Scanner sc) {
        this.sc = sc;
    }

    public UserMenuOptionResult readUserMenuOption() {
        String userMenuOption;

        while (true) {
            new PrintMenu();
            System.out.println("\nVälj ett alternativ");
            userMenuOption = sc.nextLine();

            for (MenuLine line : Menu.getMenuLines()) {
                if (line.isSelectable() && userMenuOption.equalsIgnoreCase(line.getOption())) {
                    return new UserMenuOptionResult(userMenuOption, line.getTitle(), line.getClassName());
                }
            }

            System.out.println("Ogiltigt val, försök igen");
        }
    }
}

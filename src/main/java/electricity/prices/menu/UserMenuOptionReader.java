package electricity.prices.menu;

import java.util.Scanner;

public class UserMenuOptionReader {
    private final Scanner sc;
    private static final int MAX_TIMES = 5;

    public UserMenuOptionReader(Scanner sc) {
        this.sc = sc;
    }

    public UserMenuOptionResult readUserMenuOption() {
        String userMenuOption;
        int times = 0;

        while (times < MAX_TIMES) {
            new MenuPrinter();
            System.out.println("\nVälj ett alternativ");
            userMenuOption = sc.nextLine().trim();
            times++;

            for (MenuLine line : Menu.getMenuLines()) {
                if (line.isSelectable() && userMenuOption.equalsIgnoreCase(line.getOption())) {
                    return new UserMenuOptionResult(userMenuOption, line.getTitle(), line.getMenuOption());
                }
            }

            System.out.println("Ogiltigt val, försök igen (" + times + "/" + MAX_TIMES + ")");
        }

        System.out.println("Inga försök kvar, programmet avslutas");
        throw new IllegalArgumentException("Illegal option, max attempts of " + MAX_TIMES);
    }
}

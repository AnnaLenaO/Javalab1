package electricity.prices.app.flow;

import electricity.prices.menu.UserMenuOptionHandler;
import electricity.prices.menu.UserMenuOptionReader;
import electricity.prices.menu.UserMenuOptionResult;

import java.util.Scanner;

public class ApplicationFlow {
    private final Scanner sc;

    public ApplicationFlow() {
        this.sc = new Scanner(System.in);
        runApplicationFlow();
        sc.close();
        System.out.println("Programmet avslutas");
    }

    private void runApplicationFlow() {
        boolean restarting = true;
        while (restarting) {
            try {
                UserMenuOptionReader readUserOption = new UserMenuOptionReader(sc);
                UserMenuOptionResult userOptionResult = readUserOption.readUserMenuOption();
                new UserMenuOptionHandler(userOptionResult, sc);

                if (userOptionResult.option().equalsIgnoreCase("e")) {
                    restarting = false;
                }
            } catch (Exception exception) {
                restarting = handleExceptionRetry(exception);
            }
        }
    }

    private boolean handleExceptionRetry(Exception exception) {
        System.out.println("Fel: " + exception.getMessage());
        System.out.println("Försöka igen? (y)");
        String input = sc.nextLine();

        if (!input.equalsIgnoreCase("y")) {
            System.out.println("Du valde inte \"y\"");
            return false;
        }
        return true;
    }
}

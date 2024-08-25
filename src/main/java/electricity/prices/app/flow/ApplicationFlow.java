package electricity.prices.app.flow;

import electricity.prices.user.options.HandleUserOption;
import electricity.prices.user.options.ReadUserOption;
import electricity.prices.user.options.UserOptionResult;

import java.util.Scanner;

public class ApplicationFlow {
    private final Scanner sc;

    public ApplicationFlow() {
        this.sc = new Scanner(System.in);
    }

    public void start() {
        boolean restarting = true;

        while (restarting) {
            ReadUserOption readUserOption = new ReadUserOption(sc);

            try {
                UserOptionResult userOptionResult = readUserOption.readUserOption();
                new HandleUserOption(userOptionResult, sc);

                if (userOptionResult.option().equalsIgnoreCase("e")) {
                    restarting = false;
                }
            } catch (Exception e) {
                System.out.println("Fel: " + e.getMessage());
                System.out.println("Försöka igen? (y)");
                String input = sc.nextLine();

                if (!input.equalsIgnoreCase("y")) {
                    System.out.println("Du valde inte \"y\"");
                    restarting = false;
                }
            }
        }

        sc.close();
        System.out.println("Programmet avslutas");
    }
}

package electricity.prices;

import electricity.prices.user.options.ReadUserInput;
import electricity.prices.user.options.HandleUserOption;
import electricity.prices.user.options.UserOptionResult;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean restarting = true;

        while (restarting) {
            ReadUserInput readUserInput = new ReadUserInput(sc);

            try {
                UserOptionResult userOptionResult = readUserInput.readUserOption();
                new HandleUserOption(userOptionResult);
                restarting = false;
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

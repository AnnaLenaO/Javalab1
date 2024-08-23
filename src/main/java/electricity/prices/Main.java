package electricity.prices;

import electricity.prices.user.options.ReadUserInput;
import electricity.prices.user.options.HandleUserOption;
import electricity.prices.user.options.UserOptionResult;

public class Main {
    public static void main(String[] args) {
        ReadUserInput readUserInput = new ReadUserInput();

        try {
            UserOptionResult userOptionResult = readUserInput.readUserOption();
            new HandleUserOption(userOptionResult);
        } finally {
            readUserInput.closeScanner();
        }
    }
}

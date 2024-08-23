package electricity.prices;

import electricity.prices.user.options.ReadUserInput;

public class Main {
    public static void main(String[] args) {
        ReadUserInput readUserInput = new ReadUserInput();
        String userMenuOption = readUserInput.readUserOption();
    }
}

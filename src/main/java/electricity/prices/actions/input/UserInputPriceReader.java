package electricity.prices.actions.input;

import static java.lang.Integer.parseInt;

import java.util.Scanner;

public class UserInputPriceReader {

    public int readUserInput(String hour, Scanner sc) {
        int price;

        while (true) {
            System.out.println("Ange elpriset per kWh i hela ören för klockan " + hour + ":");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Ogiltig inmatning, det saknas ett värde. Försök igen");
            } else {
                try {
                    price = parseInt(input);
                    return price;
                } catch (NumberFormatException e) {
                    System.out.println("Ogiltig inmatning, det måste vara ett heltal. Försök igen");
                }
            }
        }
    }
}

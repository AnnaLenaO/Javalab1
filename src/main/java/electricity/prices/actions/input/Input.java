package electricity.prices.actions.input;

import electricity.prices.actions.ActionInterface;
import electricity.prices.user.options.UserOptionResult;

import java.util.Scanner;

import static electricity.prices.actions.input.InputPrice.getInputPriceLines;
import static java.lang.Integer.parseInt;

public class Input implements ActionInterface {

    public void execute(UserOptionResult userOptionResult, Scanner sc) {

        System.out.println("Du har valt " + "\"" + userOptionResult.title() + "\"");
        int inputPriceLength = getInputPriceLines().size();

        for (int i = 0; i < inputPriceLength; i++) {
            String hour = getInputPriceLines().get(i).getHour();
            int price;

            while (true) {
                System.out.println("Ange elpriset per kWh i hela ören för klockan " + hour + ":");
                String input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Ogiltig inmatning, det saknas ett värde. Försök igen");
                } else {
                    try {
                        price = parseInt(input);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Ogiltig inmatning, det måste vara ett heltal. Försök igen");
                    }
                }
            }

            getInputPriceLines().get(i).setPrice(price);
        }

        System.out.println("Du har angett följande priser: ");
        printInputPrice();
    }

    private void printInputPrice() {
        getInputPriceLines().forEach(System.out::println);
    }
}

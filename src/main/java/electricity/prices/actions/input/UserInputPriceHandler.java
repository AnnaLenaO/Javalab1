package electricity.prices.actions.input;

import electricity.prices.actions.ActionInterface;
import electricity.prices.menu.UserMenuOptionResult;

import static electricity.prices.actions.input.InputPrice.getInputPriceLines;

import java.util.Scanner;
import java.util.stream.IntStream;

public class UserInputPriceHandler implements ActionInterface {

    public void execute(UserMenuOptionResult userOptionResult, Scanner sc) {
        System.out.println("Du har valt " + "\"" + userOptionResult.title() + "\"");
        int inputPriceLength = getInputPriceLines().size();

        IntStream.range(0, inputPriceLength)
                .forEach(i -> {
                    String hour = getInputPriceLines().get(i).getHour();
                    int price = new UserInputPriceReader().readUserInput(hour, sc);
                    getInputPriceLines().get(i).setPrice(price);
                });

        System.out.println("Du har angett följande priser: ");
        new InputPricePrinter();
    }
}

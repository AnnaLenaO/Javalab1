package electricity.prices.actions.input;

import electricity.prices.actions.ActionInterface;
import electricity.prices.menu.UserMenuOptionResult;

import static electricity.prices.actions.input.InputPrice.getInputPriceLines;
//import static electricity.prices.actions.input.InputPrice.setPrice;

import java.util.Scanner;

public class HandleUserInputPrice implements ActionInterface {

    public void execute(UserMenuOptionResult userOptionResult, Scanner sc) {
        System.out.println("Du har valt " + "\"" + userOptionResult.title() + "\"");
        int inputPriceLength = getInputPriceLines().size();

        for (int i = 0; i < inputPriceLength; i++) {
            String hour = getInputPriceLines().get(i).getHour();
            int price = new ReadUserInputPrice().readUserInput(hour, sc);
            getInputPriceLines().get(i).setPrice(price);
//            setPrice(i, price);
        }

        System.out.println("Du har angett följande priser: ");
        new PrintInputPrice();
    }
}

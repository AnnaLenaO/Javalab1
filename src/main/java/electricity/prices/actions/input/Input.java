package electricity.prices.actions.input;

import electricity.prices.actions.ActionInterface;
import electricity.prices.user.options.UserOptionResult;

import java.util.Scanner;

import static electricity.prices.actions.input.InputPrice.getInputPriceLines;

public class Input implements ActionInterface {

    public void execute(UserOptionResult userOptionResult, Scanner sc) {
        System.out.println("Du har valt " + "\"" + userOptionResult.title() + "\"");
        Integer inputPriceLength = getInputPriceLines().size();

        for (int i = 0; i < inputPriceLength; i++) {
            String hour = getInputPriceLines().get(i).getHour();
            System.out.println("Ange elpriset per kvW i hela ören för klockan " + hour + ":");
            Integer price = sc.nextInt();
            getInputPriceLines().get(i).setPrice(price);
        }
        System.out.println("Du har angett följande priser: ");
        printInputPrice();
    }

//    public PrintInputPrice() {
//        printInputPrice();
//    }

    private void printInputPrice() {
        getInputPriceLines().forEach(System.out::println);
    }
}

package electricity.prices.actions.input;

import electricity.prices.menu.Menu;

public class PrintInputPrice {

    public PrintInputPrice() {
        printInputPrice();
    }

    private void printInputPrice() {
        InputPrice.getInputPriceLines().forEach(System.out::println);
    }
}

package electricity.prices.actions.input;

public class InputPricePrinter {

    public InputPricePrinter() {
        printInputPrice();
    }

    private void printInputPrice() {
        InputPrice.getInputPriceLines().forEach(System.out::println);
    }
}

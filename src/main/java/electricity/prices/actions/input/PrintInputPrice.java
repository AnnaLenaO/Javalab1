package electricity.prices.actions.input;

public class PrintInputPrice {

    public PrintInputPrice() {
        printInputPrice();
    }

    private void printInputPrice() {
        InputPrice.getInputPriceLines().forEach(System.out::println);
    }
}

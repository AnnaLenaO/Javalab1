package electricity.prices.actions.input;

public class PrintInputPrice {
    public static void printInputPrice() {
        InputPrice.getInputPriceLines().forEach(System.out::println);
    }
}

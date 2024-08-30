package electricity.prices.actions.MinMaxAvg;

public class MinMaxAvgPrinter {

    public MinMaxAvgPrinter() {
        printMinMaxAvg();
    }

    private static void printMinMaxAvg() {
        MinMaxAvg.getMinMaxAvgLines().forEach(System.out::println);
    }
}

package electricity.prices.actions.MinMaxAvg;

public class PrintMinMaxAvg {

    public PrintMinMaxAvg() {
        printMinMaxAvg();
    }

    private static void printMinMaxAvg() {
        MinMaxAvg.getMinMaxAvgLines().forEach(System.out::println);
    }
}

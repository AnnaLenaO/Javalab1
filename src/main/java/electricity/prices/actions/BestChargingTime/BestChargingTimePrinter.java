package electricity.prices.actions.BestChargingTime;

public class BestChargingTimePrinter {
    public BestChargingTimePrinter() {
        printBestChargingTime();
    }

    private void printBestChargingTime() {
        System.out.println(BestChargingTime.getBestChargingTimeData());
    }
}
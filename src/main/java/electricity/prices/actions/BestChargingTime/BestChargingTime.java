package electricity.prices.actions.BestChargingTime;

import electricity.prices.actions.input.InputPriceLine;

import java.util.ArrayList;
import java.util.List;

public class BestChargingTime {
    private static List<BestChargingTimeLine> bestChargingTimeLines = List.of();
    private static int averagePrice = 0;

    public BestChargingTime(List<InputPriceLine> priceLines, int startIndex) {
        bestChargingTimeLines = new ArrayList<>();
        int totalPrice = 0;

        for (int i = startIndex; i < startIndex + 4; i++) {
            InputPriceLine inputPriceLine = priceLines.get(i);
            bestChargingTimeLines.add(new BestChargingTimeLine(inputPriceLine.getHour(), inputPriceLine.getPrice(), inputPriceLine.getUnit()));
            totalPrice += inputPriceLine.getPrice();
        }

        averagePrice = totalPrice / 4;
    }

    public static String getBestChargingTimeData() {
        StringBuilder sb = new StringBuilder();

        for (BestChargingTimeLine line : bestChargingTimeLines) {
            sb.append(line.hour()).append(": ").append(line.price()).append(" ").append(line.unit());
            sb.append("\n");
        }

        String unit = bestChargingTimeLines.getFirst().unit();
        sb.append("Timmarnas medelpris: ").append(averagePrice).append(" ").append(unit);
        sb.append("\n");

        return sb.toString();
    }
}

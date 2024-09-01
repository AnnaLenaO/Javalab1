package electricity.prices.actions.BestChargingTime;

import electricity.prices.actions.input.InputPriceLine;
import electricity.prices.calculations.MinMaxAvgCalc;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class BestChargingTimeAndAvg {
    private static List<BestChargingTimeLine> bestChargingTimeLines;
    private static String avgPriceString = "";

    public static void createBestChargingTimeAndAvg(List<InputPriceLine> priceLines, int startIndex) {
        bestChargingTimeLines = new ArrayList<>();
        int numberOfHours = 4;

        getBestChargingTimeLines(priceLines, startIndex, numberOfHours);

        setAvgPriceString();
    }

    private static void getBestChargingTimeLines(List<InputPriceLine> priceLines, int startIndex, int numberOfHours) {
        IntStream.range(startIndex, startIndex + numberOfHours)
                .mapToObj(priceLines::get)
                .forEach(InputPriceLine -> {
                    String hour = InputPriceLine.getHour();
                    int price = InputPriceLine.getPrice();
                    String unit = InputPriceLine.getUnit();
                    setBestChargingTimeLines(hour, price, unit);
                });
    }

    private static void setBestChargingTimeLines(String hour, int price, String unit) {
        bestChargingTimeLines.add(new BestChargingTimeLine(hour, price, unit));
    }

    private static void setAvgPriceString() {
        MinMaxAvgCalc minMaxAvgCalc = new MinMaxAvgCalc();
        OptionalDouble avgPrice = minMaxAvgCalc.avgValue(bestChargingTimeLines);
        avgPriceString = String.format("%.0f", avgPrice.isPresent() ? avgPrice.getAsDouble() : 0);
    }

    public static String bestChargingTimeLinesAndAvg() {
        StringBuilder sb = new StringBuilder();
        createBestChargingTimeLines(sb);
        createAvgPriceLine(sb);
        return sb.toString();
    }

    private static void createBestChargingTimeLines(StringBuilder sb) {
        bestChargingTimeLines.forEach(line -> {
            sb.append(line.hour())
                    .append(": ")
                    .append(line.price())
                    .append(" ")
                    .append(line.unit())
                    .append("\n");
        });
    }

    private static void createAvgPriceLine(StringBuilder sb) {
        String unit = bestChargingTimeLines.getFirst().unit();
        sb.append("Timmarnas medelpris: ")
                .append(avgPriceString)
                .append(" ")
                .append(unit)
                .append("\n");
    }
}

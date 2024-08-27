package electricity.prices.actions.MinMaxAvg;

import electricity.prices.actions.input.InputPriceLine;
import electricity.prices.calculations.MinMaxAvgCalc;

import static electricity.prices.actions.input.InputPrice.getInputPriceLines;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class MinMaxAvg {

    private static List<MinMaxAvgLine<?>> minMaxAvgLines;

    private static List<MinMaxAvgLine<?>> createMinMaxAvg() {
        final MinMaxAvgCalc minMaxAvgCalc = new MinMaxAvgCalc();

        List<InputPriceLine> priceLines = getInputPriceLines();
        List<MinMaxAvgLine<?>> minMaxAvgLines = new ArrayList<>();

        OptionalInt minPrice = minMaxAvgCalc.minValue(priceLines);
        String minPriceString = minPrice.isPresent() ? minPrice.getAsInt() + "" : "0";
        OptionalInt maxPrice = minMaxAvgCalc.maxValue(priceLines);
        String maxPriceString = maxPrice.isPresent() ? maxPrice.getAsInt() + "" : "0";
        float avgPrice = minMaxAvgCalc.avgValue(priceLines);
        String avgPriceString = String.valueOf(Math.round(avgPrice));

        StringBuilder minHours = new StringBuilder();
        StringBuilder maxHours = new StringBuilder();
        StringBuilder avgHours = new StringBuilder();
        String unitString = "öre/kWh";

        for (InputPriceLine inputPriceLine : priceLines) {
            if (Integer.toString(inputPriceLine.getPrice()).equals(minPriceString)) {
                minHours.append(inputPriceLine.getHour());
            }

            if (Integer.toString(inputPriceLine.getPrice()).equals(maxPriceString)) {
                maxHours.append(inputPriceLine.getHour());
            }
        }

        minMaxAvgLines.add(new MinMaxAvgLine<>("Billigast", minPriceString, minHours, unitString));
        minMaxAvgLines.add(new MinMaxAvgLine<>("Dyrast", maxPriceString, maxHours, unitString));
        minMaxAvgLines.add(new MinMaxAvgLine<>("Dygnets medelpris", avgPriceString, avgHours, unitString));
        return minMaxAvgLines;
    }

    public static List<MinMaxAvgLine<?>> getMinMaxAvgLines() {
        if (minMaxAvgLines == null) {
            minMaxAvgLines = createMinMaxAvg();
        }
        return minMaxAvgLines;
    }
}

package electricity.prices.actions.MinMaxAvg;

import electricity.prices.actions.input.InputPriceLine;
import electricity.prices.calculations.MinMaxAvgCalc;

import static electricity.prices.actions.input.InputPrice.getInputPriceLines;

import java.util.*;

public class MinMaxAvg {

    private static List<MinMaxAvgLine> minMaxAvgLines = new ArrayList<>();

    private static List<MinMaxAvgLine> createMinMaxAvg() {
        final MinMaxAvgCalc minMaxAvgCalc = new MinMaxAvgCalc();

        List<InputPriceLine> priceLines = getInputPriceLines();
        List<MinMaxAvgLine> minMaxAvgLines = new ArrayList<>();

        OptionalInt minPrice = minMaxAvgCalc.minValue(priceLines);
        String minPriceString = minPrice.isPresent() ? minPrice.getAsInt() + "" : "0";
        OptionalInt maxPrice = minMaxAvgCalc.maxValue(priceLines);
        String maxPriceString = maxPrice.isPresent() ? maxPrice.getAsInt() + "" : "0";
        OptionalDouble avgPrice = minMaxAvgCalc.avgValue(priceLines);
        String avgPriceString = String.format("%.0f", avgPrice.isPresent() ? avgPrice.getAsDouble() : 0);

        StringBuilder minHours = new StringBuilder();
        StringBuilder maxHours = new StringBuilder();
        StringBuilder avgHours = new StringBuilder();
        String unitString = priceLines.getFirst().getUnit();

        for (InputPriceLine inputPriceLine : priceLines) {
            if (Integer.toString(inputPriceLine.getPrice()).equals(minPriceString)) {
                minHours.append(inputPriceLine.getHour()).append(", ");
            }

            if (Integer.toString(inputPriceLine.getPrice()).equals(maxPriceString)) {
                maxHours.append(inputPriceLine.getHour()).append(", ");
            }
        }

        minMaxAvgLines.add(new MinMaxAvgLine("Billigast", minPriceString, minHours, unitString));
        minMaxAvgLines.add(new MinMaxAvgLine("Dyrast", maxPriceString, maxHours, unitString));
        minMaxAvgLines.add(new MinMaxAvgLine("Dygnets medelpris", avgPriceString, avgHours, unitString));
        return Collections.unmodifiableList(minMaxAvgLines);
    }

    public static List<MinMaxAvgLine> getMinMaxAvgLines() {
        if (minMaxAvgLines.isEmpty()) {
            minMaxAvgLines = createMinMaxAvg();
        }

        return createMinMaxAvg();
    }
}

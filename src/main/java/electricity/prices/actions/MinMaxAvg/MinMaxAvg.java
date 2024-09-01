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

        final Result minMaxAvgResult = getMinMaxAvg(minMaxAvgCalc, priceLines);

        getMinMaxHours(priceLines, minMaxAvgResult);

        return setMinMaxAvgLines(minMaxAvgLines, minMaxAvgResult);
    }

    private static Result getMinMaxAvg(MinMaxAvgCalc minMaxAvgCalc, List<InputPriceLine> priceLines) {
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

        return new Result(minPriceString, maxPriceString, avgPriceString, minHours, maxHours, avgHours, unitString);
    }

    private record Result(String minPriceString, String maxPriceString, String avgPriceString, StringBuilder minHours,
                          StringBuilder maxHours, StringBuilder avgHours, String unitString) {
    }

    private static void getMinMaxHours(List<InputPriceLine> priceLines, Result minMaxAvgResult) {
        priceLines.forEach(inputPriceLine -> {
            if (Integer.toString(inputPriceLine.getPrice()).equals(minMaxAvgResult.minPriceString())) {
                minMaxAvgResult.minHours().append(inputPriceLine.getHour()).append(", ");
            }

            if (Integer.toString(inputPriceLine.getPrice()).equals(minMaxAvgResult.maxPriceString())) {
                minMaxAvgResult.maxHours().append(inputPriceLine.getHour()).append(", ");
            }
        });
    }

    private static List<MinMaxAvgLine> setMinMaxAvgLines(List<MinMaxAvgLine> minMaxAvgLines, Result minMaxAvgResult) {
        minMaxAvgLines.add(new MinMaxAvgLine("Billigast", minMaxAvgResult.minPriceString(), minMaxAvgResult.minHours(), minMaxAvgResult.unitString()));
        minMaxAvgLines.add(new MinMaxAvgLine("Dyrast", minMaxAvgResult.maxPriceString(), minMaxAvgResult.maxHours(), minMaxAvgResult.unitString()));
        minMaxAvgLines.add(new MinMaxAvgLine("Dygnets medelpris", minMaxAvgResult.avgPriceString(), minMaxAvgResult.avgHours(), minMaxAvgResult.unitString()));

        return Collections.unmodifiableList(minMaxAvgLines);
    }

    public static List<MinMaxAvgLine> getMinMaxAvgLines() {
        if (minMaxAvgLines.isEmpty()) {
            minMaxAvgLines = createMinMaxAvg();
        }

        return createMinMaxAvg();
    }
}

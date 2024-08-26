package electricity.prices.actions.MinMaxAvg;

import electricity.prices.actions.input.InputPriceLine;
import electricity.prices.calculations.MinMaxAvgCalc;

import static electricity.prices.actions.input.InputPrice.getInputPriceLines;

import java.util.List;
import java.util.OptionalInt;

public class PrintMinMaxAvg {
    private final MinMaxAvgCalc minMaxAvgCalc = new MinMaxAvgCalc();

    public void printMinMaxAvg() {
        List<InputPriceLine> priceLines = getInputPriceLines();
        OptionalInt minPrice = minMaxAvgCalc.minValue(priceLines);
        String minPriceString = minPrice.isPresent() ? minPrice.getAsInt() + "" : "0";
        OptionalInt maxPrice = minMaxAvgCalc.maxValue(priceLines);
        String maxPriceString = maxPrice.isPresent() ? maxPrice.getAsInt() + "" : "0";
        float avgPrice = minMaxAvgCalc.avgPrice(priceLines);
        String avgPriceString = String.valueOf(Math.round(avgPrice));

        System.out.println("Billigast: " + minPriceString); //Enhet + Vilken tid?
        System.out.println("Dyrast: " + maxPriceString); //Enhet + Vilken tid?
        System.out.println("Dygnets medelpris: " + avgPriceString); //Enhet
    }
}
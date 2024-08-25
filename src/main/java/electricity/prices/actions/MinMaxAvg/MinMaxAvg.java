package electricity.prices.actions.MinMaxAvg;

import electricity.prices.actions.ActionInterface;
import electricity.prices.actions.input.InputPriceLine;
import electricity.prices.menu.UserMenuOptionResult;

import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;

import static electricity.prices.actions.input.InputPrice.getInputPriceLines;

public class MinMaxAvg implements ActionInterface {
    public void execute(UserMenuOptionResult userOptionResult, Scanner sc) {
        System.out.println("Du har valt " + "\"" + userOptionResult.title() + "\"");

        //Move this to a calculate class method
        List<InputPriceLine> priceLines = getInputPriceLines();
        OptionalInt minPrice = minValue(priceLines);
        String minPriceString = minPrice.isPresent() ? minPrice.getAsInt() + "" : "0";
        OptionalInt maxPrice = maxValue(priceLines);
        String maxPriceString = maxPrice.isPresent() ? maxPrice.getAsInt() + "" : "0";
        float avgPrice = avgPrice(priceLines);
        String avgPriceString = String.valueOf(Math.round(avgPrice));

        System.out.println("Billigast: " + minPriceString); //Enhet + Vilken tid?
        System.out.println("Dyrast: " + maxPriceString); //Enhet + Vilken tid?
        System.out.println("Dygnets medelpris: " + avgPriceString); //Enhet
    }

    public static void calculateMinMaxAvg() {
    }

    static OptionalInt minValue(List<InputPriceLine> priceLines) {
        return priceLines.stream().mapToInt(InputPriceLine::getPrice).min();
    }

    static OptionalInt maxValue(List<InputPriceLine> priceLines) {
        return priceLines.stream().mapToInt(InputPriceLine::getPrice).max();
    }

    static float avgPrice(List<InputPriceLine> priceLines) {
        return (float) (priceLines.stream().mapToInt(InputPriceLine::getPrice).sum()) / priceLines.size();
    }
}

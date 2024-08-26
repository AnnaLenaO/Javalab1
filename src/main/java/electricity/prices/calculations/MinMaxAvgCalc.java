package electricity.prices.calculations;

import electricity.prices.actions.input.InputPriceLine;

import java.util.List;
import java.util.OptionalInt;

public class MinMaxAvgCalc {
    public OptionalInt minValue(List<InputPriceLine> priceLines) {
        return priceLines.stream().mapToInt(InputPriceLine::getPrice).min();
    }

    public OptionalInt maxValue(List<InputPriceLine> priceLines) {
        return priceLines.stream().mapToInt(InputPriceLine::getPrice).max();
    }

    public float avgPrice(List<InputPriceLine> priceLines) {
        return (float) (priceLines.stream().mapToInt(InputPriceLine::getPrice).sum()) / priceLines.size();
    }
}

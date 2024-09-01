package electricity.prices.calculations;

import electricity.prices.actions.PriceLineInterface;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class MinMaxAvgCalc {
    public OptionalInt minValue(List<? extends PriceLineInterface> priceLines) {
        return priceLines.stream().mapToInt(PriceLineInterface::getPrice).min();
    }

    public OptionalInt maxValue(List<? extends PriceLineInterface> priceLines) {
        return priceLines.stream().mapToInt(PriceLineInterface::getPrice).max();
    }

    public OptionalDouble avgValue(List<? extends PriceLineInterface> priceLines) {
        return (priceLines.stream().mapToInt(PriceLineInterface::getPrice).average());
    }
}

package electricity.prices.calculations;

import electricity.prices.actions.input.InputPriceLine;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAscending {
    public List<InputPriceLine> sortAscending(List<InputPriceLine> priceLines) {

        return priceLines.stream().sorted(Comparator.comparing(InputPriceLine::getPrice)).collect(Collectors.toList());
    }
}
package electricity.prices.actions.input;

import java.util.ArrayList;
import java.util.List;

public class InputPrice {
    private static List<InputPriceLine> inputPriceLines;

    private InputPrice() {
    }

    private static List<InputPriceLine> createInputPrice() {
        List<InputPriceLine> inputPriceLines = new ArrayList<>();

        for (int hour = 0; hour < 24; hour++) {
            String hourString = String.format("%02d-%02d", hour, (hour + 1) % 24);
            Integer priceInteger = 0;
            String unitString = "öre/kWh";

            inputPriceLines.add(new InputPriceLine(hourString, priceInteger, unitString));
        }
        return inputPriceLines;
    }

    public static List<InputPriceLine> getInputPriceLines() {
        if (inputPriceLines == null) {
            inputPriceLines = createInputPrice();
        }
        return inputPriceLines;
    }
}

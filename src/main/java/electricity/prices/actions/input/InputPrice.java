package electricity.prices.actions.input;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class InputPrice {
    private static List<InputPriceLine> inputPriceLines;

    private static List<InputPriceLine> createInputPrice() {
        List<InputPriceLine> inputPriceLines = new ArrayList<>();

        for (int hour = 0; hour < 24; hour++) {
            String hourString = String.format("%02d-%02d", hour, (hour + 1) % 24);
            Integer priceInteger = 0;
            String unitString = "öre/kWh";

            inputPriceLines.add(new InputPriceLine(hourString, priceInteger, unitString));
        }
        return inputPriceLines;
//        return Collections.unmodifiableList(inputPriceLines);
    }

    public static List<InputPriceLine> getInputPriceLines() {
        if (inputPriceLines == null) {
            inputPriceLines = createInputPrice();
        }
        return inputPriceLines;
    }

//    ///to test immutable /////
//    public static void setPrice(Integer index, Integer newPrice) {
//        List<InputPriceLine> updatedInputPriceLines = new ArrayList<>(inputPriceLines);
//        InputPriceLine inputPriceLine = updatedInputPriceLines.get(index);
//        updatedInputPriceLines.set(index, new InputPriceLine(inputPriceLine.getHour(), newPrice, inputPriceLine.getUnit()));

//        inputPriceLines = Collections.unmodifiableList(updatedInputPriceLines);
//    }
}

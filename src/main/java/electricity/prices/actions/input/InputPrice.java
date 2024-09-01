package electricity.prices.actions.input;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InputPrice {
    private static List<InputPriceLine> inputPriceLines = new ArrayList<>();

    private static List<InputPriceLine> createInputPrice() {
        List<InputPriceLine> inputPriceLines = new ArrayList<>();

        IntStream.range(0, 24)
                .mapToObj(hour -> {
                    String hourString = String.format("%02d-%02d", hour, (hour + 1) % 24);
                    Integer priceInteger = 0;
                    String unitString = "öre/kWh";
                    return new InputPriceLine(hourString, priceInteger, unitString);
                })
                .forEach(inputPriceLines::add);

        return inputPriceLines;
    }

    public static List<InputPriceLine> getInputPriceLines() {
        if (inputPriceLines.isEmpty()) {
            inputPriceLines = createInputPrice();
        }
        return inputPriceLines;
    }

    public static void setInputPriceLines(List<InputPriceLine> csvBeanPriceLines) {
        inputPriceLines = new ArrayList<>(csvBeanPriceLines);
    }
}

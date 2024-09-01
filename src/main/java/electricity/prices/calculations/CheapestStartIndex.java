package electricity.prices.calculations;

import electricity.prices.actions.input.InputPriceLine;

import java.util.List;

public class CheapestStartIndex {
    public static int getCheapestStartIndex(List<InputPriceLine> priceLines) {

        int startIndex = 0;
        int minFourHourPrice = getFirstFourHourPrice(priceLines);
        int currentFourHourPrice = minFourHourPrice;

        for (int i = 4; i < priceLines.size(); i++) {
            currentFourHourPrice += priceLines.get(i).getPrice() - priceLines.get(i - 4).getPrice();

            if (currentFourHourPrice < minFourHourPrice) {
                minFourHourPrice = currentFourHourPrice;
                startIndex = i - 3;
            }
        }
        return startIndex;
    }

    private static int getFirstFourHourPrice(List<InputPriceLine> priceLines) {
        int firstFourHourPrice = 0;
        for (int i = 0; i < 4; i++) {
            firstFourHourPrice += priceLines.get(i).getPrice();
        }
        return firstFourHourPrice;
    }
}

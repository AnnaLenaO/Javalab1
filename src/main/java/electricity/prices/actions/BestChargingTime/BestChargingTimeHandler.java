package electricity.prices.actions.BestChargingTime;

import electricity.prices.actions.ActionInterface;
import electricity.prices.actions.input.InputPrice;
import electricity.prices.actions.input.InputPriceLine;
import electricity.prices.calculations.CheapestStartIndex;
import electricity.prices.menu.UserMenuOptionResult;

import java.util.List;
import java.util.Scanner;

public class BestChargingTimeHandler implements ActionInterface {
    public void execute(UserMenuOptionResult userOptionResult, Scanner sc) {
        System.out.println("Du har valt " + "\"" + userOptionResult.title() + "\"");
        List<InputPriceLine> inputPriceLines = InputPrice.getInputPriceLines();
        int startIndex = CheapestStartIndex.getCheapestStartIndex(inputPriceLines);
        System.out.println(startIndex);

        BestChargingTimeAndAvg.createBestChargingTimeAndAvg(inputPriceLines, startIndex);

        System.out.println("Bästa laddningstid under 4 timmar i följd:");
        new BestChargingTimePrinter();
    }
}

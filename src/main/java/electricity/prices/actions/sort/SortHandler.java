package electricity.prices.actions.sort;

import electricity.prices.actions.ActionInterface;
import electricity.prices.actions.input.InputPrice;
import electricity.prices.actions.input.InputPriceLine;
import electricity.prices.calculations.AscendingSorter;
import electricity.prices.menu.UserMenuOptionResult;

import java.util.List;
import java.util.Scanner;

public class SortHandler implements ActionInterface {
    public void execute(UserMenuOptionResult userOptionResult, Scanner sc) {
        System.out.println("Du har valt " + "\"" + userOptionResult.title() + "\"");
        List<InputPriceLine> priceLines = InputPrice.getInputPriceLines();
        List<InputPriceLine> priceLinesCopy = List.copyOf(priceLines);
        List<InputPriceLine> sortedPriceLinesCopy = new AscendingSorter().sortAscending(priceLinesCopy);
        for (InputPriceLine inputPriceLine : sortedPriceLinesCopy) {
            System.out.println(inputPriceLine);
        }
    }
}

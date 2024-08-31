package electricity.prices.actions.CsvInput;

import electricity.prices.actions.ActionInterface;
import electricity.prices.actions.input.InputPrice;
import electricity.prices.actions.input.InputPriceLine;
import electricity.prices.actions.input.InputPricePrinter;
import electricity.prices.menu.UserMenuOptionResult;

import java.util.*;


public class CsvInputHandler implements ActionInterface {
    public void execute(UserMenuOptionResult userOptionResult, Scanner sc) throws Exception {
        System.out.println("Du har valt " + "\"" + userOptionResult.title() + "\"");
        List<InputPriceLine> csvBeanPriceLines = CsvInputBean.readCsvPrices();
        InputPrice.setInputPriceLines(csvBeanPriceLines);

        System.out.println("Du har läst in följande priser från fil: ");
        new InputPricePrinter();
    }
}

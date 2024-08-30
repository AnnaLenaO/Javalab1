package electricity.prices.actions.MinMaxAvg;

import electricity.prices.actions.ActionInterface;
import electricity.prices.menu.UserMenuOptionResult;

import java.util.Scanner;

public class MinMaxAvgHandler implements ActionInterface {
    public void execute(UserMenuOptionResult userOptionResult, Scanner sc) {
        System.out.println("Du har valt " + "\"" + userOptionResult.title() + "\"");
        new MinMaxAvgPrinter();
    }
}

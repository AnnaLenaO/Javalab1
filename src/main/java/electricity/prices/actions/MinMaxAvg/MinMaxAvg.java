package electricity.prices.actions.MinMaxAvg;

import electricity.prices.actions.ActionInterface;
import electricity.prices.user.options.UserOptionResult;

import java.util.Scanner;

public class MinMaxAvg implements ActionInterface {
    public void execute(UserOptionResult userOptionResult, Scanner sc) {
        System.out.println("Du har valt " + "\"" + userOptionResult.title() + "\"");
    }
}

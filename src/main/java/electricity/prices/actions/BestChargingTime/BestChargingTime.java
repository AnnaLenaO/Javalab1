package electricity.prices.actions.BestChargingTime;

import electricity.prices.actions.ActionInterface;
import electricity.prices.user.options.UserOptionResult;

import java.util.Scanner;

public class BestChargingTime implements ActionInterface {
    public void execute(UserOptionResult userOptionResult, Scanner sc) {
        System.out.println("Du har valt " + "\"" + userOptionResult.title() + "\"");
    }
}

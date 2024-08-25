package electricity.prices.actions.sort;

import electricity.prices.actions.ActionInterface;
import electricity.prices.menu.UserMenuOptionResult;

import java.util.Scanner;

public class Sort implements ActionInterface {
    public void execute(UserMenuOptionResult userOptionResult, Scanner sc) {
        System.out.println("Du har valt " + "\"" + userOptionResult.title() + "\"");
    }
}

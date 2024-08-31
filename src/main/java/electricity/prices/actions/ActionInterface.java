package electricity.prices.actions;

import electricity.prices.menu.UserMenuOptionResult;

import java.util.Scanner;

public interface ActionInterface {
    void execute(UserMenuOptionResult userOptionResult, Scanner sc) throws Exception;
}

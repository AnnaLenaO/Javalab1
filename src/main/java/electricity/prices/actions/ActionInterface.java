package electricity.prices.actions;

import electricity.prices.user.options.UserOptionResult;

import java.util.Scanner;

public interface ActionInterface {
    void execute(UserOptionResult userOptionResult, Scanner sc);
}

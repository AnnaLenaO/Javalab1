package electricity.prices.menu;

import electricity.prices.actions.ActionInterface;

import java.util.Scanner;

public class UserMenuOptionHandler {
    private final UserMenuOptionResult userOptionResult;
    private final Scanner sc;

    public UserMenuOptionHandler(UserMenuOptionResult userOptionResult, Scanner sc) throws Exception {
        this.userOptionResult = userOptionResult;
        this.sc = sc;
        handleOption();
    }

    private void handleOption() throws Exception {
        try {
            Class<? extends ActionInterface> actionClass = ActionClassRegistry.getActionClass(userOptionResult.menuOption().getClass());

            if (actionClass == null) {
                throw new Exception("No class " + "\"" + userOptionResult.menuOption().getClass() + "\"" + "found");
            }

            ActionInterface action = actionClass.getDeclaredConstructor().newInstance();
            action.execute(userOptionResult, sc);
        } catch (Exception exception) {
            System.out.println("Alternativ: " + userOptionResult.option() + " kan inte exekveras");
            System.out.println("\"" + userOptionResult.title() + "\"" + " kan inte utföras");
            throw exception;
        }
    }
}

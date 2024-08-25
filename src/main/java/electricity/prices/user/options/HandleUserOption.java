package electricity.prices.user.options;

import electricity.prices.actions.ActionClassRegistry;
import electricity.prices.actions.ActionInterface;

import java.util.Scanner;

public class HandleUserOption {
    private final UserOptionResult userOptionResult;
    private final Scanner sc;

    public HandleUserOption(UserOptionResult userOptionResult, Scanner sc) throws Exception {
        this.userOptionResult = userOptionResult;
        this.sc = sc;
        handleOption();
    }

    private void handleOption() throws Exception {
        String className = userOptionResult.className();

        try {
            Class<? extends ActionInterface> actionClass = ActionClassRegistry.getActionClass(className);

            if (actionClass == null) {
                throw new Exception("Ingen klass " + "\"" + className + "\"" + " hittades");
            }

            ActionInterface action = actionClass.getDeclaredConstructor().newInstance();
            action.execute(userOptionResult, sc);
        } catch (Exception e) {
            System.out.println("Alternativ: " + userOptionResult.option() + " kan inte exekveras");
            System.out.println("\"" + userOptionResult.title() + "\"" + " kan inte utföras");
            throw e;
        }
    }
}

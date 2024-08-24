package electricity.prices.user.options;

import electricity.prices.actions.ActionClassRegistry;
import electricity.prices.actions.ActionInterface;

public class HandleUserOption {
    private final UserOptionResult userOptionResult;

    public HandleUserOption(UserOptionResult userOptionResult) throws Exception {
        this.userOptionResult = userOptionResult;
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
            action.execute();
        } catch (Exception e) {
            System.out.println("Alternativ: " + userOptionResult.option() + " kan inte exekveras");
            System.out.println("\"" + userOptionResult.title() + "\"" + " kan inte utföras");
            throw e;

        }
    }
}

package electricity.prices.menu;

import electricity.prices.actions.ActionInterface;

import electricity.prices.actions.BestChargingTime.BestChargingTimeHandler;
import electricity.prices.actions.CsvInput.CsvInputHandler;
import electricity.prices.actions.MinMaxAvg.MinMaxAvgHandler;
import electricity.prices.actions.exit.ExitHandler;
import electricity.prices.actions.input.UserInputPriceHandler;
import electricity.prices.actions.sort.SortHandler;

import java.util.HashMap;
import java.util.Map;

public class ActionClassRegistry {
    private static final Map<Class<? extends UserMenuOption>, Class<? extends ActionInterface>> actionClassMap = new HashMap<>();

    static {
        actionClassMap.put(Input.class, UserInputPriceHandler.class);
        actionClassMap.put(CsvInput.class, CsvInputHandler.class);
        actionClassMap.put(MinMaxAvg.class, MinMaxAvgHandler.class);
        actionClassMap.put(Sort.class, SortHandler.class);
        actionClassMap.put(BestChargingTime.class, BestChargingTimeHandler.class);
        actionClassMap.put(Exit.class, ExitHandler.class);
    }

    public static Class<? extends ActionInterface> getActionClass(Class<? extends UserMenuOption> menuOptionClass) {
        return actionClassMap.get(menuOptionClass);
    }
}

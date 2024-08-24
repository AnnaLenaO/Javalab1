package electricity.prices.actions;

import electricity.prices.actions.BestChargingTime.BestChargingTime;
import electricity.prices.actions.MinMaxAvg.MinMaxAvg;
import electricity.prices.actions.input.Input;
import electricity.prices.actions.sort.Sort;

import java.util.HashMap;
import java.util.Map;

public class ActionClassRegistry {
    private static final Map<String, Class<? extends ActionInterface>> actionClassMap = new HashMap<>();

    static {
        actionClassMap.put("Input", Input.class);
        actionClassMap.put("MinMaxAvg", MinMaxAvg.class);
        actionClassMap.put("Sort", Sort.class);
        actionClassMap.put("BestChargingTime", BestChargingTime.class);
    }

    public static Class<? extends ActionInterface> getActionClass(String className) {
        return actionClassMap.get(className);
    }
}

package electricity.prices.menu;

import java.util.List;
import java.util.ArrayList;

public class Menu {

    private static List<MenuLine> menuLines;

    private static List<MenuLine> createMenu() {
        List<MenuLine> menuLines = new ArrayList<MenuLine>();
        menuLines.add(new MenuLine("", "Elpriser", "NoClassName", false));
        menuLines.add(new MenuLine("", "========", "NoClassName", false));
        menuLines.add(new MenuLine("1", "Inmatning", "Input", true));
        menuLines.add(new MenuLine("2", "Min, Max och Medel", "MinMaxAvg", true));
        menuLines.add(new MenuLine("3", "Sortera", "Sort", true));
        menuLines.add(new MenuLine("4", "Bästa Laddningstid (4h)", "BestChargingTime", true));
        menuLines.add(new MenuLine("e", "Avsluta", "Exit", true));
        return menuLines;
    }

    public static List<MenuLine> getMenuLines() {
        if (menuLines == null) {
            menuLines = createMenu();
        }
        return menuLines;
    }
}

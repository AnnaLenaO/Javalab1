package electricity.prices.menu;

import java.util.List;
import java.util.ArrayList;

public class Menu {

    private static List<MenuLine> menuLines;

    private Menu() {
    }

    private static List<MenuLine> createMenu() {
        List<MenuLine> menuLines = new ArrayList<MenuLine>();
        menuLines.add(new MenuLine("", "Elpriser", "NoClassName"));
        menuLines.add(new MenuLine("", "========", "NoClassName"));
        menuLines.add(new MenuLine("1", "Inmatning", "Input"));
        menuLines.add(new MenuLine("2", "Min, Max och Medel", "MinMaxAvg"));
        menuLines.add(new MenuLine("3", "Sortera", "Sort"));
        menuLines.add(new MenuLine("4", "Bästa Laddningstid (4h)", "BestChargingTime"));
        menuLines.add(new MenuLine("e", "Avsluta", "Exit"));
        return menuLines;
    }

    public static List<MenuLine> getMenuLines() {
        if (menuLines == null) {
            menuLines = createMenu();
        }
        return menuLines;
    }
}

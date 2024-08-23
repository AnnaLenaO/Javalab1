package electricity.prices.menu;

import java.util.List;
import java.util.ArrayList;

public class Menu {

    private static List<MenuLine> menuLines;

    private Menu() {
    }

    private static List<MenuLine> createMenu() {
        List<MenuLine> menuLines = new ArrayList<MenuLine>();
        menuLines.add(new MenuLine("", "Elpriser"));
        menuLines.add(new MenuLine("", "========"));
        menuLines.add(new MenuLine("1.", "Inmatning"));
        menuLines.add(new MenuLine("2.", "Min, Max och Medel"));
        menuLines.add(new MenuLine("3.", "Sortera"));
        menuLines.add(new MenuLine("4.", "Bästa Laddningstid (4h)"));
        menuLines.add(new MenuLine("e.", "Avsluta"));
        return menuLines;
    }

    public static List<MenuLine> getMenuLines() {
        if (menuLines == null) {
            menuLines = createMenu();
        }
        return menuLines;
    }
}

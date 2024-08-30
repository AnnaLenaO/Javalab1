package electricity.prices.menu;

import java.util.List;
import java.util.ArrayList;

public class Menu {

    private static final List<MenuLine> menuLines = createMenu();

    private static List<MenuLine> createMenu() {
        List<MenuLine> menuLines = new ArrayList<MenuLine>();
        menuLines.add(new MenuLine("", "Elpriser", new Headline(), false));
        menuLines.add(new MenuLine("", "========", new Underline(), false));
        menuLines.add(new MenuLine("1", "Inmatning", new Input(), true));
        menuLines.add(new MenuLine("2", "Min, Max och Medel", new MinMaxAvg(), true));
        menuLines.add(new MenuLine("3", "Sortera", new Sort(), true));
        menuLines.add(new MenuLine("4", "Bästa Laddningstid (4h)", new BestChargingTime(), true));
        menuLines.add(new MenuLine("e", "Avsluta", new Exit(), true));
        return menuLines;
    }

    public static List<MenuLine> getMenuLines() {
        return menuLines;
    }
}

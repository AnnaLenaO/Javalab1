package electricity.prices.menu;

public class MenuPrinter {
    public MenuPrinter() {
        printMenu();
    }

    private void printMenu() {
        Menu.getMenuLines().forEach(System.out::println);
    }
}

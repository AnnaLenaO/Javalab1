package electricity.prices.menu;

public class PrintMenu {
    public PrintMenu() {
        printMenu();
    }

    private void printMenu() {
        Menu.getMenuLines().forEach(System.out::println);
    }
}

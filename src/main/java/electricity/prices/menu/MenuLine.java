package electricity.prices.menu;

public class MenuLine {
    private final String option;
    private final String title;
    private final UserMenuOption menuOption;
    private final boolean isSelectable;

    MenuLine(String option, String title, UserMenuOption menuOption, boolean isSelectable) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        this.option = option;
        this.title = title;
        this.menuOption = menuOption;
        this.isSelectable = isSelectable;
    }

    public String getOption() {
        return option;
    }

    public String getTitle() {
        return title;
    }

    public UserMenuOption getMenuOption() {
        return menuOption;
    }

    public boolean isSelectable() {
        return isSelectable;
    }

    @Override
    public String toString() {
        if (option.isEmpty()) {
            return title;
        }
        return option + ". " + title;
    }
}

package electricity.prices.menu;

public class MenuLine {
    private final String option;
    private final String title;

    MenuLine(String option, String title) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.option = option;
        this.title = title;
    }

    public String getOption() {
        return option;
    }

    public String getTitle() {
        return title;
    }

    //@Override
    public String toString() {
        if (option.isEmpty()) {
            return title;
        }
        return option + ". " + title;
    }
}

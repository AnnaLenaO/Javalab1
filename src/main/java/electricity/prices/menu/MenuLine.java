package electricity.prices.menu;

public class MenuLine {
    private final String option;
    private final String title;

    MenuLine(String digit, String title) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.option = digit;
        this.title = title;
    }

    public String getOption() {
        return option;
    }

    //@Override
    public String toString() {
        if (option.isEmpty()) {
            return title;
        }
        return option + ". " + title;
    }
}

package electricity.prices.menu;

public class MenuLine {
    private final String option;
    private final String title;
    private final String className;
    private final boolean isSelectable;

    MenuLine(String option, String title, String className, boolean isSelectable) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (className.isBlank()) {
            throw new IllegalArgumentException("ClassName cannot be empty");
        }
        this.option = option;
        this.title = title;
        this.className = className;
        this.isSelectable = isSelectable;
    }

    public String getOption() {
        return option;
    }

    public String getTitle() {
        return title;
    }

    public String getClassName() {
        return className;
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

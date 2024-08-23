package electricity.prices.menu;

public class MenuLine {
    private final String digit;
    private final String title;

    MenuLine(String digit, String title) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.digit = digit;
        this.title = title;
    }

    //@Override
    public String toString() {
        if (digit.isEmpty()) {
            return title;
        }
        return digit + " " + title;
    }
}

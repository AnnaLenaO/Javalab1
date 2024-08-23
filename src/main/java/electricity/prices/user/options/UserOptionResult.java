package electricity.prices.user.options;

public class UserOptionResult {
    private final String option;
    private final String title;

    public UserOptionResult(String option, String title) {
        this.option = option;
        this.title = title;
    }

    public String getOption() {
        return option;
    }

    public String getTitle() {
        return title;
    }
}

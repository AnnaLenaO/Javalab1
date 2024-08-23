package electricity.prices.user.options;

public class HandleUserOption {
    private final UserOptionResult userOptionResult;

    public HandleUserOption(UserOptionResult userOptionResult) {
        this.userOptionResult = userOptionResult;
        handleOption();
    }

    private void handleOption() {
        System.out.println("\n" + userOptionResult.title()); //to test & to be removed
        //More logic here to start the different Options
    }
}

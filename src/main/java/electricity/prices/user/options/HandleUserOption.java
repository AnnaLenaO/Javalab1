package electricity.prices.user.options;

public class HandleUserOption {
    private final UserOptionResult userOptionResult;

    public HandleUserOption(UserOptionResult userOptionResult) throws Exception {
        this.userOptionResult = userOptionResult;
        handleOption();
    }

    private void handleOption() throws Exception {
        String className = userOptionResult.className();

        try {
            //Might use interface here, instead of reflection
            Class<?> classObj = Class.forName("electricity.prices.actions." + className);
            classObj.getMethod("main", String[].class).invoke(null, (Object) new String[]{});
        } catch (Exception e) {
            System.out.println("Alternativ: " + userOptionResult.option() + " kan inte exekveras");
            System.out.println("\"" + userOptionResult.title() + "\"" + " kan inte utföras");
//            System.out.println("Välj ett nytt alternativ");
            throw e;
        }
    }
}

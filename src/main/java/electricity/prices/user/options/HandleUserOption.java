package electricity.prices.user.options;

public class HandleUserOption {
    private final UserOptionResult userOptionResult;

    public HandleUserOption(UserOptionResult userOptionResult) throws Exception{
        this.userOptionResult = userOptionResult;
        handleOption();
    }

    private void handleOption() throws Exception {
//        System.out.println("\n" + userOptionResult.title()); //to test & to be removed
        String className = userOptionResult.className();

        try {
            //Might use interface here, instead of reflection
            Class<?> classObj = Class.forName("electricity.prices." + className);
            classObj.getMethod("main", String[].class).invoke(null, (Object) new String[]{});
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Alternativ: " + userOptionResult.option() + " kan inte exekveras");
            System.out.println(userOptionResult.title() + " kan inte utföras");
            System.out.println("Välj ett nytt alternativ");
            throw e;
        }
    }
}

package electricity.prices.actions.exit;

import electricity.prices.actions.ActionInterface;

public class Exit implements ActionInterface {
    public void execute() {
        System.out.println("Du har valt att avsluta programmet");
    }
}

package challenger;

import app.UI;

public class EasyBot extends Challenger {

    public EasyBot() {
        super("Easy Bot", 1, 0.01, 0);
    }

    @Override
    public void doAction(IChallenger enemy) {
        UI.getInstance().doNothing(this);
    }

}

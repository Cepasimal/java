package challenger;

public class FactoryBot {

    public static IChallenger createBot(String difficulties) {
        if (difficulties.equalsIgnoreCase("easy")) {
            return new EasyBot();
        }
        if (difficulties.equalsIgnoreCase("normal")) {
            return new NormalBot();
        }
        if (difficulties.equalsIgnoreCase("hard")) {
            return new HardBot();
        }
        return null;
    }

}

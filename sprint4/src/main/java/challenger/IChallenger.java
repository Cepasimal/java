package challenger;

public interface IChallenger {

    void doAction(IChallenger enemy);

    String getName();

    int getHealthPoints();

    int getSpeedPoints();

    boolean isEscaping();

    void setHealthPoints(int i);

    double getDefensePoints();

}

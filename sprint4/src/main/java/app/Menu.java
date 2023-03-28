package app;

import challenger.*;

public class Menu {

    private Player player;
    private IChallenger challenger;

    // Un singleton permet d'avoir une seule instance du menu sans utiliser que des méthodes statiques
    //#region Singleton
    private static Menu instance;

    private Menu() { }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }
    //#endregion

    /**
     * Commence le jeu et son paramétrage
     */
    public void beginGame() {
        this.choosePlayerName();

        while (true) {
            String currentDifficulty = this.chooseDifficulties();

            // Reset settings
            this.player = new Player(this.player);
            this.challenger = FactoryBot.createBot(currentDifficulty);

            this.beginFight();

            if (UI.getInstance().wantToEndGame()) { break; }

            boolean changeDifficulty = UI.getInstance().wantToUpdateDifficulties(currentDifficulty);
            if (changeDifficulty) {
                this.challenger = null;
            }
        }
    }

    /**
     * Demande le nom de l'utilisateur pour créer le joueur
     */
    private void choosePlayerName() {
        String playerName = UI.getInstance().getPlayerName();
        this.player = new Player(playerName, 1.5, 0.5, 1);
    }

    /**
     * Demande la difficulté de la partie à l'utilisateur
     * @return la difficulté choisie
     */
    private String chooseDifficulties() {
        String difficulties = "";
        while (this.challenger == null) {
            difficulties = UI.getInstance().chooseDifficulties();
            this.challenger = FactoryBot.createBot(difficulties);
            if (this.challenger == null) {
                UI.getInstance().wrongInput();
            }
        }
        return difficulties;
    }

    /**
     * Démarre le combat avec les paramètres définis
     */
    private void beginFight() {
        new Fight(this.player, this.challenger).play();
    }

}

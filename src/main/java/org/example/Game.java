package org.example;

public class Game {

    private String playerName;
    private int badges;
    private int pokemonCount;
    private int playTime;

    public Game(String playerName) {
        this.playerName = playerName;
        this.badges = 0;
        this.pokemonCount = 0;
        this.playTime = 0;
    }

    /**
     * Play the game adding more time to the game, new badges that the player won
     * and new Pokemons that has been captured
     * @param minutes: The minutes that you play this time
     * @param newBadges: The new badges that you acquired this gaming session
     * @param newPokemon: The new Pokemons that you captured this gaming session
     * @return A text indicating the statistics of the game
     */
    public String play(int minutes, int newBadges, int newPokemon) {
        this.playTime += minutes;
        this.badges += newBadges;
        this.pokemonCount += newPokemon;
        return  "Playing... \nTime: " + playTime + " mins\nBadges: " + badges + "\nPokémon: " + pokemonCount;
    }


    /**
     * Creates a Save State in the emulator
     * @return A new Save State with the actual statistics of the game
     */
    public SaveState saveGame() {
        return new SaveState(playerName, badges, pokemonCount, playTime);
    }

    /**
     * Load an existing Save State
     * @param saveState: The Save State to load
     * @return A text indicating the statistics of the loaded Save State
     */
    public String loadGame(SaveState saveState) {
        this.playerName = saveState.getPlayerName();
        this.badges = saveState.getBadges();
        this.pokemonCount = saveState.getPokemonCount();
        this.playTime = saveState.getPlayTime();
        return  "Game loaded! State:\nPlayer: " + playerName + "\nBadges: " + badges + "\nPokémon: " + pokemonCount + "\nTime: " + playTime + " mins";
    }
}

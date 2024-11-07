package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SaveStateTest {

    Game game = new Game("Ash");
    SaveManager saveManager = new SaveManager();

    /**
     * Check that you can play the game correctly, you can make your own Save States, and
     * they can be loaded into the game without problems
     */
    @Test
    void testSaveState(){
        assertEquals("Playing... \n" +
                        "Time: 30 mins" +
                        "\nBadges: 2" +
                        "\nPokémon: 5",
                game.play(30,2,5));

        SaveState saveState1 = game.saveGame();
        saveManager.addSaveState(saveState1);

        assertEquals("Playing... \n" +
                        "Time: 75 mins" +
                        "\nBadges: 3" +
                        "\nPokémon: 8",
                game.play(45,1,3));
        SaveState saveState2 = game.saveGame();
        saveManager.addSaveState(saveState2);

        assertEquals("Save state not found!",
                saveManager.getSaveState(5));

        assertEquals("Game loaded! State:\n" +
                        "Player: Ash" +
                        "\nBadges: 2" +
                        "\nPokémon: 5" +
                        "\nTime: 30 mins",
                game.loadGame(
                        (SaveState) saveManager.getSaveState(0)
                )
        );
    }
}
package nz.ac.auckland.se281.Difficulty;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.MessageCli;

public class GameFactory {

  /**
   * Create a new game with the given difficulty level.
   *
   * @param difficulty The difficulty level of the game
   * @return A new GameLevel object with the specified difficulty level
   */
  public static GameLevel createGame(Difficulty difficulty) {

    // Switch statement to handle different difficulty levels
    switch (difficulty) {
      case EASY:
        return new Easy();

      case MEDIUM:
        return new Medium();

      case HARD:
        return new Hard();

      default:
        // If the difficulty does not match any case, print an invalid difficulty message and exit
        MessageCli.INVALID_DIFFICULTY.printMessage();
        System.exit(0);
    }
    // Return null if no valid difficulty is found
    return null;
  }
}

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class GameFactory {
  // Factory method to create an instance of GameLevel based on the chosen difficulty
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

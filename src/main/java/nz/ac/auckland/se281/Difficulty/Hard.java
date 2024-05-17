package nz.ac.auckland.se281.Difficulty;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Strategy.Random;
import nz.ac.auckland.se281.Strategy.Strategy;
import nz.ac.auckland.se281.Strategy.TopLevel;

public class Hard extends GameLevel {
  private String winner; // Variable to store the winner of the round
  private boolean switchStrategy = false; // Flag to determine if the strategy should be switched

  /**
   * Method to play a round of the game
   *
   * @param fingers The number of fingers the player chooses
   * @param name The name of the player
   * @param choice The player's choice for the round
   * @param round The current round number
   */
  @Override
  public void play(int fingers, String name, Choice choice, int round) {
    // If the round number is less than 4, use the Random strategy
    if (round < 4) {
      // Create a new Strategy instance with the player's name, number of fingers, and choice
      Strategy strategy = new Strategy(name, fingers, choice);
      // Set the strategy to Random
      strategy.setStrategy(new Random());
      // Play the game using the Random strategy
      strategy.playGame();
      // Get the winner of the round
      winner = strategy.getWinner();
      // Add the winner to the history of winners
      historyOfWinners.add(winner);
    }

    // Loop through the history of winners to check if the player has won a round
    for (int i = 0; i < historyOfWinners.size(); i++) {
      if (historyOfWinners.get(i) == name) {
        switchStrategy = true; // Set the flag to true if the player has won
      }
    }

    // If the flag is set to true, switch to the TopLevel strategy
    if (switchStrategy) {
      // Create a new Strategy instance with the player's name, number of fingers, and choice
      Strategy strategy = new Strategy(name, fingers, choice);
      // Set the strategy to TopLevel
      strategy.setStrategy(new TopLevel(historyOfChoices));
      // Play the game using the TopLevel strategy
      strategy.playGame();
      // Get the winner of the round
      winner = strategy.getWinner();
      // Add the winner to the history of winners
      historyOfWinners.add(winner);
    } else {
      // If the flag is not set to true, continue using the Random strategy
      // Create a new Strategy instance with the player's name, number of fingers, and choice
      Strategy strategy = new Strategy(name, fingers, choice);
      // Set the strategy to Random
      strategy.setStrategy(new Random());
      // Play the game using the Random strategy
      strategy.playGame();
      // Get the winner of the round
      winner = strategy.getWinner();
      // Add the winner to the history of winners
      historyOfWinners.add(winner);
    }
  }
}

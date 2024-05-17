package nz.ac.auckland.se281.difficulty;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.strategy.Random;
import nz.ac.auckland.se281.strategy.Strategy;

public class Easy extends GameLevel {
  private String winner; // Variable to store the winner of the round

  /**
   * Play the game with the given number of fingers, player name, choice, and round number.
   *
   * @param fingers The number of fingers the player is holding out
   * @param name The name of the player
   * @param choice The choice the player made
   * @param round The round number
   */
  @Override
  public void play(int fingers, String name, Choice choice, int round) {
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

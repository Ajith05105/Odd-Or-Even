package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Medium extends GameLevel {
  private String winner; // Variable to store the winner of the round

  @Override
  public void play(int fingers, String name, Choice choice, int round) {
    // If the round number is less than 4, use the Random strategy
    if (round < 4) {
      Strategy strategy = new Strategy(name, fingers, choice); // Create a new Strategy instance
      strategy.setStrategy(new Random()); // Set the strategy to Random
      strategy.playGame(); // Play the game using the Random strategy
      winner = strategy.getWinner(); // Get the winner of the round
      historyOfWinners.add(winner); // Add the winner to the history of winners
    } else { // If the round number is 4 or more, use the TopLevel strategy
      Strategy strategy = new Strategy(name, fingers, choice); // Create a new Strategy instance
      strategy.setStrategy(
          new TopLevel(historyOfChoices)); // Set the strategy to TopLevel with history
      strategy.playGame(); // Play the game using the TopLevel strategy
      winner = strategy.getWinner(); // Get the winner of the round
      historyOfWinners.add(winner); // Add the winner to the history of winners
    }
  }
}

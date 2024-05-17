package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Easy extends GameLevel {
  private String winner; // Variable to store the winner of the round

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

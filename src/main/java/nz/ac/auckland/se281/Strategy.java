package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Strategy {
  // Variables to store the player's name, number of fingers, and choice
  private String name;
  private int fingers;
  private Choice choice;
  // Reference to the strategy interface
  private Execute strategy;

  // Constructor to initialize the Strategy object with player information
  public Strategy(String name, int fingers, Choice choice) {
    this.name = name;
    this.fingers = fingers;
    this.choice = choice;
  }

  // Method to set the strategy for the current game
  public void setStrategy(Execute strategy) {
    this.strategy = strategy;
  }

  // Method to play the game using the selected strategy
  public void playGame() {
    strategy.playGame(fingers, name, choice);
  }

  // Method to retrieve the winner of the game from the strategy
  public String getWinner() {
    return strategy.getWinner();
  }
}

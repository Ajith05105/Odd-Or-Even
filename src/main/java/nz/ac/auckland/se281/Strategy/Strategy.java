package nz.ac.auckland.se281.Strategy;

import nz.ac.auckland.se281.Main.Choice;

public class Strategy {
  // Variables to store the player's name, number of fingers, and choice
  private String name;
  private int fingers;
  private Choice choice;
  // Reference to the strategy interface
  private Execute strategy;

  /**
   * Constructor for the Strategy class
   *
   * @param name
   * @param fingers
   * @param choice
   */
  public Strategy(String name, int fingers, Choice choice) {
    this.name = name;
    this.fingers = fingers;
    this.choice = choice;
  }

  /**
   * Method to set the strategy for the game
   *
   * @param strategy
   */
  public void setStrategy(Execute strategy) {
    this.strategy = strategy;
  }

  /** Method to play the game */
  public void playGame() {
    strategy.playGame(fingers, name, choice);
  }

  /**
   * Method to get the winner of the game
   *
   * @return
   */
  public String getWinner() {
    return strategy.getWinner();
  }
}

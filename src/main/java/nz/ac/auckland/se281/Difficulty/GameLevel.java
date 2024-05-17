package nz.ac.auckland.se281.Difficulty;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public abstract class GameLevel {
  // List to store the history of choices made by the player
  protected ArrayList<Choice> historyOfChoices = new ArrayList<Choice>();
  // List to store the history of winners for each round
  protected ArrayList<String> historyOfWinners = new ArrayList<String>();

  // Abstract method to be implemented by subclasses, defining how the game is played
  public abstract void play(int fingers, String name, Choice choice, int round);

  // Method to get the history of winners
  public ArrayList<String> getHistoryOfWins() {
    return historyOfWinners;
  }

  /**
   * @param winner
   */
  public void addWinner(String winner) {
    historyOfWinners.add(winner);
  }

  /**
   * @param roundChoice
   */
  public void addChoice(Choice roundChoice) {
    historyOfChoices.add(roundChoice);
  }
}

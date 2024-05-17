package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class TopLevel implements Execute {
  private int aiFingersEven =
      Utils.getRandomEvenNumber(); // AI's fingers when AI expects even choice
  private int aiFingersOdd = Utils.getRandomOddNumber(); // AI's fingers when AI expects odd choice
  private int total = 0; // Total fingers (player + AI)
  private Choice playerChoice; // Player's choice (EVEN or ODD)
  private Choice likelyChoice; // AI's likely choice based on history
  private ArrayList<Choice> historyOfChoices = new ArrayList<Choice>();
  private String winner = ""; // Winner of the current round
  private int even = 0; // Count of EVEN choices in history
  private int odd = 0; // Count of ODD choices in history

  // Constructor to initialize the history of choices
  public TopLevel(ArrayList<Choice> historyOfChoices) {
    this.historyOfChoices = historyOfChoices;
  }

  // Method to play the game
  @Override
  public void playGame(int fingers, String name, Choice choice) {
    // Count the occurrences of EVEN and ODD choices in history
    for (int i = 0; i < historyOfChoices.size(); i++) {
      if (historyOfChoices.get(i) == Choice.EVEN) {
        even++;
      } else {
        odd++;
      }
    }

    // Determine the likely choice based on history
    if (even > odd) {
      likelyChoice = Choice.EVEN;
    } else if (even == odd) {
      Strategy strategy =
          new Strategy(name, fingers, choice); // Use random strategy if counts are equal
      strategy.setStrategy(new Random());
      strategy.playGame();
      return; // Exit after playing with random strategy
    } else {
      likelyChoice = Choice.ODD;
    }

    playerChoice = choice; // Set the player's choice

    // Determine AI's move based on likely choice and player's choice
    if (likelyChoice == Choice.EVEN && playerChoice == Choice.EVEN) {
      MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(aiFingersOdd));
      total = fingers + aiFingersOdd;
    } else if (likelyChoice == Choice.ODD && playerChoice == Choice.ODD) {
      MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(aiFingersOdd));
      total = fingers + aiFingersOdd;
    } else if (likelyChoice == Choice.EVEN && playerChoice == Choice.ODD) {
      MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(aiFingersEven));
      total = fingers + aiFingersEven;
    } else {
      MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(aiFingersEven));
      total = fingers + aiFingersEven;
    }

    // Determine and print the outcome of the round
    if (total % 2 == 0) {
      if (playerChoice == Choice.EVEN) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "EVEN", name);
        winner = name;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "EVEN", "HAL-9000");
        winner = "HAL-9000";
      }
    } else {
      if (playerChoice == Choice.ODD) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "ODD", name);
        winner = name;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "ODD", "HAL-9000");
        winner = "HAL-9000";
      }
    }
  }

  // Method to get the winner of the round
  public String getWinner() {
    return winner;
  }
}

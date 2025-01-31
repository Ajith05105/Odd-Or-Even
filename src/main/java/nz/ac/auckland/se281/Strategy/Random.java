package nz.ac.auckland.se281.strategy;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.MessageCli;
import nz.ac.auckland.se281.Utils;

public class Random implements Execute {

  // Randomly generated number of fingers for the AI, between 0 and 5
  private int aiFingers = Utils.random.nextInt(6);
  // Variable to store the winner of the round
  private String winner;

  /**
   * Play the game with the given number of fingers, player name, and choice.
   *
   * @param fingers The number of fingers the player is holding out
   * @param name The name of the player
   * @param choice The choice the player made
   */
  @Override
  public void playGame(int fingers, String name, Choice choice) {
    // Print the AI's chosen number of fingers
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(aiFingers));
    // Calculate the total number of fingers shown by both player and AI
    int total = fingers + aiFingers;

    // Determine if the total is even
    if (total % 2 == 0) {
      // If the total is even and the player's choice is EVEN, the player wins
      if (choice == Choice.EVEN) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "EVEN", name);
        winner = name;
      } else {
        // If the total is even and the player's choice is ODD, the AI wins
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "EVEN", "HAL-9000");
        winner = "HAL-9000";
      }
    } else {
      // If the total is odd and the player's choice is ODD, the player wins
      if (choice == Choice.ODD) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "ODD", name);
        winner = name;
      } else {
        // If the total is odd and the player's choice is EVEN, the AI wins
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "ODD", "HAL-9000");
        winner = "HAL-9000";
      }
    }
  }

  /**
   * Get the winner of the round.
   *
   * @return The winner of the round
   */
  @Override
  public String getWinner() {
    // Return the winner of the round
    return winner;
  }
}

package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Game {
  protected ArrayList<String> historyOfWinners =
      new ArrayList<String>(); // List to keep track of game winners
  private String name; // Name of the player
  private int round = 0; // Current round number
  private Difficulty chosenDifficulty = null; // Chosen difficulty level
  private Choice roundChoice = null; // Player's choice for the current round (EVEN or ODD)
  private Choice chosenChoice = null; // Player's overall choice (EVEN or ODD)
  private GameLevel game = null; // Current game level object
  private int aiWins = 0; // Number of wins for AI
  private int playerWins = 0; // Number of wins for player

  // Method to start a new game
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    round = 0; // Reset round number
    playerWins = 0; // Reset player wins
    aiWins = 0; // Reset AI wins
    chosenDifficulty = difficulty; // Set chosen difficulty
    chosenChoice = choice; // Set chosen choice
    name = options[0]; // Set player name
    MessageCli.WELCOME_PLAYER.printMessage(options[0]); // Welcome the player
    game = GameFactory.createGame(chosenDifficulty); // Create a game object based on difficulty
    historyOfWinners = game.getHistoryOfWins(); // Initialize history of winners
  }

  // Method to play a round of the game
  public void play() {
    round++; // Increment round number
    if (chosenChoice == null) {
      MessageCli.GAME_NOT_STARTED.printMessage(); // Print error if the game has not started
      return;
    }

    MessageCli.START_ROUND.printMessage(String.valueOf(round)); // Print the start of the round

    boolean validInput = false; // Flag to check valid input
    int fingers = 0; // Number of fingers input by player

    // Loop to get valid input from player
    while (!validInput) {
      MessageCli.ASK_INPUT.printMessage(); // Ask for input
      String input = Utils.scanner.nextLine(); // Read input

      try {
        fingers = Integer.parseInt(input); // Try to parse input as an integer
        if (fingers < 0 || fingers > 5) {
          MessageCli.INVALID_INPUT.printMessage(); // Print error if input is out of range
        } else {
          validInput = true; // Set valid input flag
        }
      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage(); // Print error if input is not a number
      }
    }

    MessageCli.PRINT_INFO_HAND.printMessage(
        name, String.valueOf(fingers)); // Print the player's input

    // Determine if the input number is even or odd
    if (Utils.isEven(fingers)) {
      roundChoice = Choice.EVEN; // Set choice to EVEN
    } else {
      roundChoice = Choice.ODD; // Set choice to ODD
    }
    game.addChoice(roundChoice); // Add choice to game history
    game.play(fingers, name, chosenChoice, round); // Play the game round
  }

  // Method to end the game and print the outcome
  public void endGame() {
    System.out.println(historyOfWinners); // Print history of winners for debugging
    if (chosenChoice == null) {
      MessageCli.GAME_NOT_STARTED.printMessage(); // Print error if the game has not started
      return;
    }

    playerWins = 0; // Reset player wins
    aiWins = 0; // Reset AI wins

    // Count the wins for player and AI
    for (String winner : historyOfWinners) {
      if (winner.equals(name)) {
        playerWins++; // Increment player wins
      } else {
        aiWins++; // Increment AI wins
      }
    }

    // Determine and print the overall game outcome
    if (playerWins > aiWins) {
      MessageCli.PRINT_END_GAME.printMessage(name); // Print if player wins
    } else if (playerWins < aiWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000"); // Print if AI wins
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage(); // Print if it's a tie
    }
    chosenChoice = null; // Reset chosen choice
  }

  // Method to show game statistics
  public void showStats() {
    if (chosenChoice == null) {
      MessageCli.GAME_NOT_STARTED.printMessage(); // Print error if the game has not started
      return;
    }

    playerWins = 0; // Reset player wins
    aiWins = 0; // Reset AI wins

    // Count the wins for player and AI
    for (String winner : historyOfWinners) {
      if (winner.equals(name)) {
        playerWins++; // Increment player wins
      } else {
        aiWins++; // Increment AI wins
      }
    }

    // Print the win statistics for player and AI
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        name, String.valueOf(playerWins), String.valueOf(aiWins));

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", String.valueOf(aiWins), String.valueOf(playerWins));
  }
}

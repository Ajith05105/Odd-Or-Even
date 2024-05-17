package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Game {
  protected ArrayList<String> historyOfWinners = new ArrayList<String>();
  private String name;
  private int round = 0;
  private Difficulty chosenDifficulty = null;
  private Choice roundChoice = null;
  private Choice chosenChoice = null;
  private GameLevel game = null;
  private int aiWins = 0;
  private int playerWins = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // The first element of options[0] is the name of the player
    round = 0;
    playerWins = 0;
    aiWins = 0;
    chosenDifficulty = difficulty;
    chosenChoice = choice;
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    game = GameFactory.createGame(chosenDifficulty);
    historyOfWinners = game.getHistoryOfWins();
  }

  public void play() {
    round++;
    if (chosenChoice == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.START_ROUND.printMessage(String.valueOf(round));

    boolean validInput = false;
    int fingers = 0;

    while (!validInput) {
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();

      try {
        fingers = Integer.parseInt(input);
        if (fingers < 0 || fingers > 5) {
          MessageCli.INVALID_INPUT.printMessage();
        } else {
          validInput = true;
        }
      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }

    MessageCli.PRINT_INFO_HAND.printMessage(name, String.valueOf(fingers));

    if (Utils.isEven(fingers)) {
      roundChoice = Choice.EVEN;
    } else {
      roundChoice = Choice.ODD;
    }
    game.addChoice(roundChoice);
    game.play(fingers, name, chosenChoice, round);
  }

  public void endGame() {
    System.out.println(historyOfWinners);
    if (chosenChoice == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    playerWins = 0;
    aiWins = 0;

    for (String winner : historyOfWinners) {
      if (winner.equals(name)) {
        playerWins++;
      } else {
        aiWins++;
      }
    }

    if (playerWins > aiWins) {
      MessageCli.PRINT_END_GAME.printMessage(name);
    } else if (playerWins < aiWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
    chosenChoice = null;
  }

  public void showStats() {
    if (chosenChoice == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    playerWins = 0;
    aiWins = 0;

    for (String winner : historyOfWinners) {
      if (winner.equals(name)) {
        playerWins++;
      } else {
        aiWins++;
      }
    }

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        name, String.valueOf(playerWins), String.valueOf(aiWins));

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", String.valueOf(aiWins), String.valueOf(playerWins));
  }
}

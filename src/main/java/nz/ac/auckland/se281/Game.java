package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private String name;
  private int round = 0;
  Difficulty chosenDifficulty = null;
  Choice chosenChoice = null;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    chosenDifficulty = difficulty;
    chosenChoice = choice;
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    round++;

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
    GameLevel game = GameFactory.createGame(chosenDifficulty);
    game.play(fingers, name, chosenChoice);
  }

  public void endGame() {}

  public void showStats() {}
}

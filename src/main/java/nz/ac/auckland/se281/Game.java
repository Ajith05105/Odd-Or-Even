package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private String name;
  private int round = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    round++;

    MessageCli.START_ROUND.printMessage(String.valueOf(round));

    MessageCli.ASK_INPUT.printMessage();
    String fingers = Utils.scanner.nextLine();

    if (Integer.parseInt(fingers) < 0 || Integer.parseInt(fingers) > 5) {
      MessageCli.INVALID_INPUT.printMessage();
    } else {
      MessageCli.PRINT_INFO_HAND.printMessage(name, fingers);
    }
  }

  public void endGame() {}

  public void showStats() {}
}

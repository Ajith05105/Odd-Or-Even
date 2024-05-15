package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game  {
  private String name;
  private int round = 0;
  Difficulty chosenDifficulty = null;
  Choice roundChoice = null;
  Choice chosenChoice = null;
  GameLevel game = null;
 
   
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    chosenDifficulty = difficulty;
    chosenChoice = choice;
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    game = GameFactory.createGame(chosenDifficulty);
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

    // if statments to check wether user input is odd or even

    MessageCli.PRINT_INFO_HAND.printMessage(name, String.valueOf(fingers));
    
    if(Utils.isEven(fingers)) {
      roundChoice = Choice.EVEN;
    } else {
      roundChoice = Choice.ODD;
    }
    game.addChoice(roundChoice);
    game.play(fingers, name, chosenChoice, round);
    
  }

 
  public void endGame() {}

  public void showStats() {}
}

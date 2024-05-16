package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class TopLevel implements Execute {
  private int aiFingersEven = Utils.getRandomEvenNumber();
  private int aiFingersOdd = Utils.getRandomOddNumber();
  private int total = 0;
  private Choice playerChoice;
  private Choice likelyChoice;
  private ArrayList<Choice> historyOfChoices = new ArrayList<Choice>();
  String winner = "";
  int even = 0;
  int odd = 0;

  public TopLevel(ArrayList<Choice> historyOfChoices) {
    this.historyOfChoices = historyOfChoices;
  }

  @Override
  public void playGame(int fingers, String name, Choice choice) {
    for (int i = 0; i < historyOfChoices.size(); i++) {
      if (historyOfChoices.get(i) == Choice.EVEN) {
        even++;
      } else {
        odd++;
      }
    }
    if (even > odd) {
      likelyChoice = Choice.EVEN;

    } else if (even == odd) {
      Strategy strategy = new Strategy(name, fingers, choice);
      strategy.setStrategy(new Random());
      strategy.playGame();
    } else {
      likelyChoice = Choice.ODD;
    }
    playerChoice = choice;

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

  public String getWinner() {
    return winner;
  }
}

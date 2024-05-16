package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopLevel implements Execute {
  private int aiFingersEven = Utils.getRandomEvenNumber();
  private int aiFingersOdd = Utils.getRandomOddNumber();
  private int total = 0;
  private Choice playerChoice;
  private Choice likelyChoice;

  public TopLevel(Choice playerChoice) {
    this.playerChoice = playerChoice;
  }

  @Override
  public void playGame(int fingers, String name, Choice choice) {

    if (choice == Choice.EVEN) {
      MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(aiFingersOdd));
      total = fingers + aiFingersOdd;
    } else {
      MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(aiFingersEven));
      total = fingers + aiFingersEven;
    }

    if (total % 2 == 0) {
      if (choice == Choice.EVEN) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "EVEN", name);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "EVEN", "HAL-9000");
      }
    } else {
      if (choice == Choice.ODD) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "ODD", name);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "ODD", "HAL-9000");
      }
    }
  }
}

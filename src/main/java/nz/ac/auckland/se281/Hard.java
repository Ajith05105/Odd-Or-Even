package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Hard extends GameLevel {
  @Override
  public void play(int fingers, String name, Choice choice) {
    int aiFingers = Utils.random.nextInt(6);
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(aiFingers));
    int total = fingers + aiFingers;
    if (total % 2 == 0) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "EVEN", "HAL-9000");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(total), "ODD", name);
    }
  }
}

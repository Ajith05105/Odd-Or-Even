package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Medium extends GameLevel {

  private int odd = 0;
  private int even = 0;
  private Choice likelyChoice;

  @Override
  public void play(int fingers, String name, Choice choice, int round) {

    if (round < 4) {
      Strategy strategy = new Strategy(name, fingers, choice);
      strategy.setStrategy(new Random());
      strategy.playGame();
    } else {
      System.out.println(historyOfChoices);
      for (int i = 0; i < historyOfChoices.size(); i++) {
        if (historyOfChoices.get(i) == Choice.EVEN) {
          even++;
        } else {
          odd++;
        }
      }
      if (even > odd) {
        likelyChoice = Choice.EVEN;

      } else {
        likelyChoice = Choice.ODD;
      }
      Strategy strategy = new Strategy(name, fingers, likelyChoice);
      strategy.setStrategy(new TopLevel(choice));
      strategy.playGame();
    }
  }
}

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Medium extends GameLevel {
  private String winner;

  @Override
  public void play(int fingers, String name, Choice choice, int round) {

    if (round < 4) {
      Strategy strategy = new Strategy(name, fingers, choice);
      strategy.setStrategy(new Random());
      strategy.playGame();
      winner = strategy.getWinner();
    } else {
      Strategy strategy = new Strategy(name, fingers, choice);
      strategy.setStrategy(new TopLevel(historyOfChoices));
      strategy.playGame();
      winner = strategy.getWinner();
    }
  }
}

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Hard extends GameLevel {
  private String winner;
  private boolean switchStrategy = false;

  @Override
  public void play(int fingers, String name, Choice choice, int round) {

    if (round < 4) {
      Strategy strategy = new Strategy(name, fingers, choice);
      strategy.setStrategy(new Random());
      strategy.playGame();
      winner = strategy.getWinner();
      historyOfWinners.add(winner);
    }
    for (int i = 0; i < historyOfWinners.size(); i++) {
      if (historyOfWinners.get(i) == name) {
        switchStrategy = true;
      }
    }
    if (switchStrategy) {
      Strategy strategy = new Strategy(name, fingers, choice);
      strategy.setStrategy(new TopLevel(historyOfChoices));
      strategy.playGame();
      winner = strategy.getWinner();
      historyOfWinners.add(winner);
    } else {
      Strategy strategy = new Strategy(name, fingers, choice);
      strategy.setStrategy(new Random());
      strategy.playGame();
      winner = strategy.getWinner();
      historyOfWinners.add(winner);
    }
  }
}

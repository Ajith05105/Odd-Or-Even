package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Strategy {
  private String name;
  private int fingers;
  private Choice choice;
  private Execute strategy;

  public Strategy(String name, int fingers, Choice choice) {
    this.name = name;
    this.fingers = fingers;
    this.choice = choice;
  }

  public void setStrategy(Execute strategy) {
    this.strategy = strategy;
  }

  public void playGame() {
    strategy.playGame(fingers, name, choice);
  }
}

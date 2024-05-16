package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Easy extends GameLevel {

  @Override
  public void play(int fingers, String name, Choice choice, int round) {
   Strategy strategy = new Strategy(name, fingers, choice);
   strategy.setStrategy(new Random());
    strategy.playGame();

    
  }
}

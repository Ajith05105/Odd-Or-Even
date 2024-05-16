package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class Medium extends GameLevel {
 

  private int odd = 0;
  private int even = 0;

  @Override
  public void play(int fingers, String name, Choice choice, int round) {
    System.out.println("Medium Level");

    if (round < 4) {
      Strategy strategy = new Strategy(name, fingers, choice);
      strategy.setStrategy(new Random());
      strategy.playGame();
    }
    else{
      System.out.println(historyOfChoices);
      for (int i = 0; i < historyOfChoices.size(); i++) {
        if (historyOfChoices.get(i) == Choice.EVEN) {
          even++;
        } else {
          odd++;
        }
      }
      if (even > odd) {
        choice = Choice.EVEN;
        
      }
      else{
        choice = Choice.ODD;
      }
      Strategy strategy = new Strategy(name, fingers, choice);
      strategy.setStrategy(new TopLevel());
      strategy.playGame();
    }
  }
}

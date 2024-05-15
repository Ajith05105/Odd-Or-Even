package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class Medium extends GameLevel {
 

  private int Odd = 0;
  private int Even = 0;

  @Override
  public void play(int fingers, String name, Choice choice, int round) {

    GameLevel initialRoundsStratergy = new Easy();
    

    if (round < 4) {
      initialRoundsStratergy.play(fingers, name, choice, round);
    }
    else{
      for (int i = 0; i < historyOfChoices.size(); i++) {
        if (historyOfChoices.get(i) == Choice.EVEN) {
          Even++;
        } else {
          Odd++;
        }
      }


    }
  }
}

package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.Choice;

public abstract class GameLevel {
  protected ArrayList<Choice> historyOfChoices = new ArrayList<Choice>();
  

  public abstract void play(int fingers, String name, Choice choice, int round);


  public void addChoice(Choice roundChoice) {
    historyOfChoices.add(roundChoice);}

  
  }
  

  


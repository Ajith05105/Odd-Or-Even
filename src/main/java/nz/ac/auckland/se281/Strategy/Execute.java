package nz.ac.auckland.se281.Strategy;

import nz.ac.auckland.se281.Main.Choice;

/** Interface for the Execute class */
public interface Execute {
  public abstract void playGame(int fingers, String name, Choice choice);

  public abstract String getWinner();
}

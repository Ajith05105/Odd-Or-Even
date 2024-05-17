package nz.ac.auckland.se281.Difficulty;
import nz.ac.auckland.se281.Strategy.Random;
import nz.ac.auckland.se281.Strategy.Strategy;
import nz.ac.auckland.se281.Strategy.TopLevel;
import nz.ac.auckland.se281.Main.Choice;

public class Medium extends GameLevel {
  private String winner; // Variable to store the winner of the round

  @Override
  public void play(int fingers, String name, Choice choice, int round) {
    // If the round number is less than 4, use the Random strategy
    if (round < 4) {
      Strategy strategy = new Strategy(name, fingers, choice); // Create a new Strategy instance
      strategy.setStrategy(new Random()); 
      strategy.playGame(); 
      winner = strategy.getWinner(); 
      historyOfWinners.add(winner); 
    } else { 
      Strategy strategy = new Strategy(name, fingers, choice); // Create a new Strategy instance
      strategy.setStrategy(
          new TopLevel(historyOfChoices)); // Set the strategy to TopLevel with history
      strategy.playGame(); 
      winner = strategy.getWinner();
      historyOfWinners.add(winner); 
    }
  }
}

package com.carl.game;

import java.util.List;

import com.carl.game.fighter.Fighter;
import com.carl.game.parse.CSVParser;

/**
 * This Class will coordinate between the fighters and the parser in order to start the match.  
 * 
 * @author Carl
 *
 */
public class Game {
	
	/**
	 * This is the reference to the list of fighters.
	 */
	private List<Fighter> fighters;

	/**
	 * Reference to the Parser class that will create each fighters after reading the CSV file.
	 */
	CSVParser parser;
	
	/**
	 * Reference to the <code>Match</code> class that will begin the fight.
	 */
	Match match;

	/**
	 * Constructor of the {@link Game} class which will set the List of fighters and iterate through each fighter.
	 * The match will go from the first 2 fighters in the list.  Once the match has ended, the first index is removed
	 * in order to make sure no fighters fight the same opponents.
	 */
	public Game() {

		//Set the Parser class.
		this.parser = new CSVParser();
		
		//Set the fighters List from the CSVParser instance
		this.fighters = this.parser.getFighters();

		// Loop through the list of fighters until there is no one else to match up with.
		while (this.fighters.size() != 1) 
		{	
			//iterate each fighter setting the first 2 fighters as the players 
			for (int i = 1; i < this.fighters.size(); i++) 
			{
				//Create an instance of the Match class and enter the 2 fighters to fight.
				this.match = new Match(fighters.get(0), fighters.get(i));
			}
			//Dynamically change the list so that no fighters fight the same opponents.
			this.fighters.remove(0);
		}
	}
}

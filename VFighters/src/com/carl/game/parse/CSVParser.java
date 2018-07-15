package com.carl.game.parse;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.carl.game.Game;
import com.carl.game.fighter.Fighter;

/**
 * 
 * This is the class that will read the file from the {@link DataSource} and parse each line to create the fighter object.  
 * The fighter created and added to a list which will be used by the {@link Game} class. 
 * @author Carl
 *
 */
public class CSVParser implements IParser{

	/**
	 * Reference to the list of fighters
	 */
	private List<Fighter> fighters;
	
	/**
	 * Reference to the Data holding the CSV String
	 */
	private DataSource dataSource;
	
	/**
	 * Represent the String of the CSV
	 */
	private String fileString;
	
	/**
	 * Reference to the fighter object that will be added to List.
	 */
	Fighter fighter;
	
	
	/**
	 * This is the constructor that will retrieve the CSV String and set it to the class.  The string will be used to
	 * parse its information to create the fighter objects
	 */
	public CSVParser() 
	{
		this.fighters = new LinkedList<>();
		this.dataSource = new DataSource();
		parse(dataSource);
	}

	@SuppressWarnings("resource")
	@Override
	/**
	 * This method will take in the {@link DataSource} which holds the CSV String.  Once parsed, it will allows
	 * us to create the Fighter object which can be added to the list.
	 */
	public void parse(final IDataSource theDataSource)
	{
		//Set the CSV String 
		this.fileString = ((DataSource) theDataSource).getCSVString();
		
		//Scan the String
		Scanner inputStream = null;
		inputStream = new Scanner(fileString);
		
		//While there is a next line
		while (inputStream.hasNext()) 
		{
			//Set next line
			String line = inputStream.next();
			
			//Split the line delimited by the comma, into an array of strings
			String [] string = line.split(",");
			
			//Create the fighter object.
			this.fighter = new Fighter(string[0], 
					Integer.parseInt(string[1]),
					Integer.parseInt(string[2]),
					Integer.parseInt(string[3]));
			
			//Add to the list.
			this.fighters.add(fighter);
		}		
	}


	/**
	 * 
	 * @return The list of fighters
	 */
	public List<Fighter> getFighters() {
		return fighters;
	}


}

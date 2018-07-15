package com.carl.game.parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class will read the provided CSV file and allow the {@link CSVParser} to obtain the String of entire file.
 * 
 * @author Carl
 *
 */
public class DataSource implements IDataSource {
	
	/*
	 * Reference to the name of CSV file
	 */
	private String fileName;
	
	/**
	 * Reference to the entire string read from file
	 */
	private String CSVString;
	
	
	/**
	 * The constructor that will set the name and string 
	 */
	public DataSource() 
	{
		//Set file name
		this.fileName = "vendor_fighters.csv";
		
		//Set the entire file to string.
		this.CSVString = getData();
	}

	
	/**
	 * This method will read line by line of the CSV file and translate to string.
	 */
	@Override
	public String getData() 
	{
		//Create the file instance
		File file = new File(fileName);
		Scanner inputStream = null;
		
		//Is file valid
		try {
			inputStream = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		inputStream.nextLine();
		StringBuilder sb = new StringBuilder();
		
		//Read each line an set it to the stringbuilder
		while (inputStream.hasNext()) {
			String data = inputStream.next();
			sb.append(data);
			sb.append("\n");
		}
		//Return entire file's string
		return sb.toString();
	}

	
	/**
	 * 
	 * @return The CSV String
	 */
	public String getCSVString() {
		return this.CSVString;
	}
}

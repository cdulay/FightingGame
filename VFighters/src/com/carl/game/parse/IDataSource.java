package com.carl.game.parse;

/**
 * This is the interface that will be used by the {@link CSVParser} class to retrieve the data of CSV file.
 * @author tony
 *
 */
public interface IDataSource {

	/**
	 * @return The string of entire CSV file.
	 */
	public String getData();
}

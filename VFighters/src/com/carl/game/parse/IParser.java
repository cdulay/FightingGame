package com.carl.game.parse;

/**
 * This interface will be used by the {@link CSVParser} class to read through the CSV String and
 * create the fighter objects.
 * @author tony
 *
 */
public interface IParser {
	/**
	 * This will parse through the {@link DataSource} to create the fighter objects.
	 * @param dataSource
	 */
	public void parse(IDataSource dataSource);
}

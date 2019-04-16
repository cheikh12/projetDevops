package interfaces;

import dataframe.Dataframe;

public interface Dataframe_itf {
	/**
	 * Displays the elements, if any, in all rows in the Dataframe 
	 */
	public void showAll();
	
		
	/**
	 * Displays the first n rows of elements, if any, in the dataframe
	 *  
	 * @param n an integer, representing the first n rows of elements in the Dataframe to display. If n is less than 0, n is set to the default value of 5. 
	 */
	public void showHead(int n);
	
		
	/**
	 * Displays the last n rows of elements, if any, in the dataframe
	 *  
	 * @param n an integer, representing the last n rows of elements in the Dataframe to display. If n is less than 0, n is set to the default value of 5. 
	 */
	public void showTail(int n);
	
	
	/**
	 * Returns a Dataframe object of the elements at row idx.  
	 * <p>
	 * Dataframe rows follow a zero-based numbering. The returned Dataframe object has the same definition as the original Dataframe.  
	 * 
	 * @param idx the row index to select from the Dataframe
	 * @return a Dataframe that contains the row selected from the current Dataframe
	 * @throws Exception if argument idx is not between zero (inclusive) and the number of rows in the Dataframe (exclusive).
	 */
	public Dataframe selectRow(int idx) throws Exception;
	
	
	/**
	 * Returns a Dataframe object from this Dataframe of the elements at the rows in argument idx.
	 * <p>
	 * Dataframe rows follow a zero-based numbering. The returned Dataframe object has the same definition as the original Dataframe. 
	 * 
	 * @param idx an integer array, containing the row indexes to select from the Dataframe 
	 * @return a Dataframe that contains the rows selected from the current Dataframe
	 * @throws Exception if any value in idx is not between zero (inclusive) and the number of rows in the Dataframe (exclusive). 
	 */
	public Dataframe selectRows(int[] idx) throws Exception;
	
	
	/**
	 * Returns a Dataframe object from this Dataframe of the elements in the column name passed as argument. The returned Dataframe object has the same definition as the original column in the original Dataframe. 
	 * 
	 * @param column a String, representing the name of the column in the Dataframe to select from 
	 * @return a Dataframe that contains all the elements in the specified column
	 * @throws Exception if there is no column in the Dataframe with the name passed as argument. 
	 */
	public Dataframe selectColumn(String column) throws Exception;
	
	
	/**
	 * Returns a Dataframe object from this Dataframe of the elements in the columns name passed as argument. The columns in the returned Dataframe object have the same definition as the original columns in the original Dataframe. 
	 * 
	 * @param columns a String array, representing the name of the columns in the Dataframe to select from
	 * @return a Dataframe that contains all the elements in the specified columns
	 * @throws Exception if there is any element in argument columns that is not the name of a column in the Dataframe.
	 */
	public Dataframe selectColumns(String[] columns) throws Exception;
	
	
	/**
	 * Returns a Double array where each index contains either null or the minimum value of a column in columns.
	 * <p>
	 * There is an implicit mapping of the values in the returned array to the columns in the columns argument, using the array indexes. 
	 * 
	 * @param columns a String array of column names in the Dataframe 
	 * @return an array of Doubles with same dimension as columns, containing the minimum value in each column of argument columns 
	 * @throws Exception if there is any element in argument columns that is not the name of a column in the Dataframe.
	 */
	public Double[] min(String[] columns) throws Exception;
	
	
	/**
	 * Returns a Double array where each index contains either null or the maximum value of a column in columns.
	 * <p>
	 * There is an implicit mapping of the values in the returned array to the columns in the columns argument, using the array indexes. 
	 * 
	 * @param columns a String array of column names in the Dataframe 
	 * @return an array of Doubles with same dimension as columns, containing the maximum value in each column of argument columns 
	 * @throws Exception if there is any element in argument columns that is not the name of a column in the Dataframe.
	 */
	public Double[] max(String[] columns) throws Exception;
	
	
	/**
	 * Returns a Double array that contains either null or the mean value of a column in columns.
	 * <p>
	 * There is an implicit mapping of the values in the returned array to the columns in the columns argument, using the array indexes. 
	 * 
	 * @param columns a String array of column names in the Dataframe 
	 * @return an array of Doubles with same dimension as columns, containing the mean value in each column of  argument columns 
	 * @throws Exception if there is any element in argument columns that is not the name of a column in the Dataframe.
	 */
	public Double[] mean(String[] column) throws Exception;

}

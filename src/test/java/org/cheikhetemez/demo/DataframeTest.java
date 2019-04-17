/**
 * 
 */
package org.cheikhetemez.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import column.Column;
import dataframe.Dataframe;
import interfaces.Type_t_itf;
import type_t.T_Bool;
import type_t.T_Double;
import type_t.T_Int;
import type_t.T_String;


/**
 * @author mbeng
 *
 */
public class DataframeTest {
	private String[][] correctData = {
			{"id", "fname", "lname", "balance", "age"}, 
			{"int", "string", "string", "double", "int"},
			{"1", "Charles", "Dickens", "41983.23", "22"}, 
			{"2", "Tony", "Stark", "292849.11", "44"}, 
			{"3", "Bruce", "Banner", "983777.98", "43"},
			{"4", "Peter", "Parker", "9800.98", "19"},
			{"5", "Lizzy", "Mcguire", "9880.98", "19"},
			{"6", "Aunt", "May", "34610.98", "68"}
	};

	/**
	 * @throws java.lang.Exception 
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	public boolean isSameData( String[][] tabString, Dataframe data) {
		Object tabValue;
		Object dataframeValue;
		String[][] dataFromdataframe = data.getDataSet2DArray();
		String[] typesOfdataframe = data.getColumnTypes();
		int lineOfType = 1;
		int lineOfColumnName = 0;
		
		for(int i = 0; i<tabString[lineOfType].length; i++) {
			if(tabString[lineOfType][i] != typesOfdataframe[i]) {
				return false;
			}
		}
		// test now if column names match
		for(int i = 0; i<tabString[lineOfColumnName].length; i++) {
			if(tabString[lineOfColumnName][i] != dataFromdataframe[lineOfColumnName][i]) {
				return false;
			}
		}
		//Now we test if all the data match
		int nbRow = tabString.length;
		int nbCol = tabString[0].length;
		for(int i = 2; i< nbRow; i++) {
			for(int j = 0; j<nbCol; j++) {
				if(tabString[i][j] != dataFromdataframe[i-1][j]) {
					return false;
				}
			}
		}
		return true;
	}
	 
	@Test
	public void testConstructor() throws Exception {
		Dataframe dataframe = new Dataframe(correctData);
		if(dataframe == null)
		fail("TEST FAILED : the constructor of dataframe does not work correctly");
	}
	
	/*@Test
	public void testConstructorWithNoValues() throws Exception {
		try {
			String[][] data = null;
			Dataframe emptyDataframe = new Dataframe(data); 
			if(emptyDataframe == null) {
				fail("TEST FAILED : We must be able to create empty dataframe");
			}
			
			 * Badges git
			 * qualite code / couverture
			 * authors
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail("TEST FAILED : We must be able to create empty dataframe");
		}
		
	}*/
	
	@Test
	public void testConstructorWithBadType() throws Exception {
		try {
			String[][] data = {
					{"id", "fname", "lname", "balance", "age"}, 
					{"int", "string", "string", "float", "int"},
					{"1", "Charles", "Dickens", "41983.23f", "22"}, 
					{"2", "Tony", "Stark", "292849.11f", "44"}, 
					{"3", "Bruce", "Banner", "983777.98f", "43"},
					{"4", "Peter", "Parker", "9800.98f", "19"},
					{"5", "Lizzy", "Mcguire", "9880.98f", "19"},
					{"6", "Aunt", "May", "34610.98f", "68"}
			};
			Dataframe dataframe = new Dataframe(data);
			if(data != null) {
				fail("TEST FAILED : Dataframe must contain only type of int, string, double, bool");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}
	
	/*@Test
	public void testConstructorWithMissingValues() throws Exception {
		try {
			String[][] data = {
					{"id", "fname", "", "balance", "age"}, 
					{"int", "string", "string", "double", "int"},
					{"1", "", "Dickens", "41983.23", "22"}, 
					{"2", "Tony", "", "292849.11", "44"}, 
					{"3", "Bruce", "Banner", "", "43"},
					{"4", "Peter", "", "9800.98", "19"}, 
					{"5", "Lizzy", "Mcguire", "9880.98", ""},
					{"", "Aunt", "May", "34610.98", "68"}
			};
			Dataframe dataframe = new Dataframe(data);
			if(data == null || !isSameData(data, dataframe)) {
				//fail("TEST FAILED : Dataframe must support missing values");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			fail("TEST FAILED : Dataframe must support missing values");
		}
		
	}*/
	
	@Test
	public void testConstructorCSV() throws Exception {
		Dataframe newData = new Dataframe("\\identites.csv", ";");
	}
	
	@Test
	public void testShowAllMethod() throws Exception {
		String[][] theData = {
				{"id", "fname", "lname", "question", "age"}, 
				{"int", "string", "string", "bool", "int"},
				{"1", "Charles", "Dickens", "false", "22"}, 
				{"2", "Tony", "Stark", "true", "44"}, 
				{"3", "Bruce", "Banner", "true", "43"},
				{"4", "Peter", "Parker", "true", "19"},
				{"5", "Lizzy", "Mcguire", "true", "19"},
				{"6", "Aunt", "May", "true", "68"}
		};
		Dataframe newData = new Dataframe(theData);
		newData.showAll();
		System.out.println("######################################## TESTING METHODS OF SHOW ##################################");
	}
	
	@Test
	public void testShowHeadMethod() throws Exception {
		String[][] theData = {
				{"id", "fname", "lname", "question", "age"}, 
				{"int", "string", "string", "bool", "int"},
				{"1", "Charles", "Dickens", "false", "22"}, 
				{"2", "Tony", "Stark", "true", "44"}, 
				{"3", "Bruce", "Banner", "true", "43"},
				{"4", "Peter", "Parker", "true", "19"},
				{"5", "Lizzy", "Mcguire", "true", "19"},
				{"6", "Aunt", "May", "true", "68"}
		};
		Dataframe newData = new Dataframe(theData);
		newData.showHead(3);;
		System.out.println("######################################## TESTING METHODS OF SHOW ##################################");
	}

	@Test
	public void testShowHeadWithNegativeIndex() throws Exception {
		String[][] theData = {
				{"id", "fname", "lname", "question", "age"}, 
				{"int", "string", "string", "bool", "int"},
				{"1", "Charles", "Dickens", "false", "22"}, 
				{"2", "Tony", "Stark", "true", "44"}, 
				{"3", "Bruce", "Banner", "true", "43"},
				{"4", "Peter", "Parker", "true", "19"},
				{"5", "Lizzy", "Mcguire", "true", "19"},
				{"6", "Aunt", "May", "true", "68"}
		};
		int index = -4;
		
		Dataframe newData = new Dataframe(theData);
		newData.showHead(index);;
		System.out.println("######################################## TESTING METHODS OF SHOW ##################################");
	}
	
	@Test
	public void testShowHeadOutOfboundIndex() throws Exception {
		String[][] theData = {
				{"id", "fname", "lname", "question", "age"}, 
				{"int", "string", "string", "bool", "int"},
				{"1", "Charles", "Dickens", "false", "22"}, 
				{"2", "Tony", "Stark", "true", "44"}, 
				{"3", "Bruce", "Banner", "true", "43"},
				{"4", "Peter", "Parker", "true", "19"},
				{"5", "Lizzy", "Mcguire", "true", "19"},
				{"6", "Aunt", "May", "true", "68"}
		};
		int index = theData.length + 10;
		Dataframe newData = new Dataframe(theData);
		newData.showHead(index);;
		System.out.println("######################################## TESTING METHODS OF SHOW ##################################");
	}
	
	@Test
	public void testShowTail() throws Exception {
		String[][] theData = {
				{"id", "fname", "lname", "question", "age"}, 
				{"int", "string", "string", "bool", "int"},
				{"1", "Charles", "Dickens", "false", "22"}, 
				{"2", "Tony", "Stark", "true", "44"}, 
				{"3", "Bruce", "Banner", "true", "43"},
				{"4", "Peter", "Parker", "true", "19"},
				{"5", "Lizzy", "Mcguire", "true", "19"},
				{"6", "Aunt", "May", "true", "68"}
		};
		int index = theData.length-2;
		Dataframe newData = new Dataframe(theData);
		newData.showTail(index);;
		System.out.println("######################################## TESTING METHODS OF SHOW ##################################");
	}
	
	@Test
	public void testShowTailNegativeIndex() throws Exception {
		String[][] theData = {
				{"id", "fname", "lname", "question", "age"}, 
				{"int", "string", "string", "bool", "int"},
				{"1", "Charles", "Dickens", "false", "22"}, 
				{"2", "Tony", "Stark", "true", "44"}, 
				{"3", "Bruce", "Banner", "true", "43"},
				{"4", "Peter", "Parker", "true", "19"},
				{"5", "Lizzy", "Mcguire", "true", "19"},
				{"6", "Aunt", "May", "true", "68"}
		};
		int index = -4;
		
		Dataframe newData = new Dataframe(theData);
		newData.showTail(index);
		System.out.println("######################################## TESTING METHODS OF SHOW ##################################");
	}
	
	@Test
	public void testShowTailOutOfboundIndex() throws Exception {
		String[][] theData = {
				{"id", "fname", "lname", "question", "age"}, 
				{"int", "string", "string", "bool", "int"},
				{"1", "Charles", "Dickens", "false", "22"}, 
				{"2", "Tony", "Stark", "true", "44"}, 
				{"3", "Bruce", "Banner", "true", "43"},
				{"4", "Peter", "Parker", "true", "19"},
				{"5", "Lizzy", "Mcguire", "true", "19"},
				{"6", "Aunt", "May", "true", "68"}
		};
		int index = theData.length + 10;
		Dataframe newData = new Dataframe(theData);
		newData.showTail(index);
		System.out.println("######################################## TESTING METHODS OF SHOW ##################################");
	}
	@Test
	public void testConstrucWithNoType() throws Exception {
		try {
			String[][] data = {
					{"id", "fname", "lname", "balance", "age"}, 
					{"1", "Charles", "Dickens", "41983.23", "22"}, 
					{"2", "Tony", "Stark", "292849.11", "44"}, 
					{"3", "Bruce", "Banner", "983777.98", "43"},
					{"4", "Peter", "Parker", "9800.98", "19"},
					{"5", "Lizzy", "Mcguire", "9880.98", "19"},
					{"6", "Aunt", "May", "34610.98", "68"}
			};		
			Dataframe dataNoTyped = new Dataframe(data);
			if(dataNoTyped != null) {
				fail("TEST FAILED : Dataframe must not support data without type");		
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testSelectRow() throws Exception {
		Dataframe newData = new Dataframe(correctData);
		int index = 2;
		Dataframe rowData = newData.selectRow(2);
		
		if(rowData == null) {
			fail("TEST FAILED : the method selectRow of dataframe does not work");
		}
	}
	
	@Test
	public void testSelectRowOutOfBounds() throws Exception {
		try {
			Dataframe newData = new Dataframe(correctData);
			int index = newData.getDataSet2DArray().length+2;
			Dataframe rowData = newData.selectRow(index);
			if(rowData != null) {
				fail("TEST FAILED : the method selectRow of dataframe does not work if index is out of bounds");
			}
		} catch (Exception e) {
			// TODO: handle exception
		    System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testSelectRowNegativeIndex() throws Exception {
		try {
			Dataframe newData = new Dataframe(correctData);
			int index = -4;
			Dataframe rowData = newData.selectRow(index);
			if(rowData != null) {
				fail("TEST FAILED : the method selectRow of dataframe does not work if index is negative");
			}
		} catch (Exception e) {
			// TODO: handle exception
		    System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testSelectRows() throws Exception {
		try {
			Dataframe newData = new Dataframe(correctData);
			int[] index = {1, 2, 3};
			Dataframe rowsData = newData.selectRows(index);
			if(rowsData != null) {
			//	fail("TEST FAILED : the method selectRow of dataframe does not work if index is negative");
			}
		} catch (Exception e) {
			// TODO: handle exception
		    System.out.println(e.getMessage());
		}
	}
	@Test
	public void testMin() throws Exception {
		Dataframe myData = new Dataframe(correctData);
		double min = 19;
		String[] columnNames = {"age"};
		Double[] result = myData.min(columnNames);
		if(result[0] != min) {
			fail("method min of dataframe does not work");
		}
	}
	
	@Test
	public void testMax() throws Exception {
		Dataframe myData = new Dataframe(correctData);
		double max = 68;
		String[] columnNames = {"age"};
		Double[] result = myData.max(columnNames);
		if(result[0] != max) {
			fail("method max of dataframe does not work");
		}
	}
	@Test
	public void testMean() throws Exception {
		Dataframe myData = new Dataframe(correctData);
		double mean = 215/6;
		String[] columnNames = {"age"};
		Double[] result = myData.mean(columnNames);
		if(result[0]-mean<0.00) { 
			fail("method mean of dataframe does not work"); 
		}
	}
	
	@Test
	public void testSelectColumns() throws Exception {
		String[] columnNames = {"balance","age"};
		Dataframe myData = new Dataframe(correctData);
		Dataframe resultSelected = myData.selectColumns(columnNames);
		
		if(resultSelected.getColumnTypes()==null || resultSelected.getDataset()==null) {
			fail("method selecColumns does not work");
		}
	}
	
	@Test
	public void mainTest() throws Exception {
		Dataframe myData = new Dataframe(correctData);
		myData.main(null);
	}
}

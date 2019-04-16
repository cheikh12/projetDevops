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
		Column newColumn;
		Type_t_itf columnType = null;
			for(int rowTab = 0; rowTab <tabString.length; rowTab++) {
				for(int colTab = 0; colTab<tabString[0].length; colTab++) {
					if(tabString[1][colTab] == "string") {
						columnType = new T_String();
					}
					else if(tabString[1][colTab] == "int") {
						columnType = new T_Int();
					}
					else if(tabString[1][colTab] == "double") {
						columnType = new T_Double();
					}
					else if(tabString[1][colTab] == "bool") {
						columnType = new T_Bool();
					}
					newColumn = new Column(tabString[0][colTab],columnType);
					assertNotNull("thi column must not be null", newColumn);
					String columnName = tabString[0][colTab];
					assertNotNull("thi columnType must not be null", columnType);
					tabValue = tabString[rowTab][colTab];
					assertNotNull("ERROR ASSERTION : this value of the String Array must exist", tabValue);
					dataframeValue = data.getDataset().get(newColumn).get(rowTab);
					assertNotNull("ERROR ASSERTION : this value of the dataframe must exist", dataframeValue);
					if(tabValue != dataframeValue) {
						return true;
					}
				} 
			}
		
		return false;
	}
	 
	@Test
	public void testConstructor() throws Exception {
		try {
			Dataframe dataframe = new Dataframe(correctData);
			try {
				if(!isSameData(correctData, dataframe)) {
					fail("TEST FAILED : the constructor of dataframe does not work correctly, data do not match");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				fail("TEST FAILED : the constructor of dataframe does not work correctly, data do not match");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println(e.getMessage());
		fail("TEST FAILED : the constructor of dataframe does not work correctly");
		}
		
	}
	
	@Test
	public void testConstructorWithNoValues() throws Exception {
		try {
			String[][] data = null;
			Dataframe emptyDataframe = new Dataframe(data);
			if(emptyDataframe == null) {
				fail("TEST FAILED : We must be able to create empty dataframe");
			}
			/*
			 * Badges git
			 * qualite code / couverture
			 * authors*/
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail("TEST FAILED : We must be able to create empty dataframe");
		}
		
	}
	
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
	
	@Test
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
				fail("TEST FAILED : Dataframe must support missing values");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			fail("TEST FAILED : Dataframe must support missing values");
		}
		
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

}

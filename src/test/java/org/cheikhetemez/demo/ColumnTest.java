package org.cheikhetemez.demo;

import column.Column;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import type_t.T_Bool;
import type_t.T_Double;
import type_t.T_Int;
import type_t.T_String;

public class ColumnTest extends TestCase {
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		//creation of column of integers for the tests cases parameters
		T_Int  intColumnType = new T_Int();
    	assertNotNull("The object intColumnType must not be null for this tests", intColumnType); 
    	String intColumnName = "columnOfInt";
    	Column columOfIntegers = new Column(intColumnName, intColumnType);
    	assertNotNull("the object columOfIntegers must exit for this tests", columOfIntegers);
    	
    	//creation of column of doubles for the tests cases parameters
    	T_Double doubleColumnType = new T_Double();
    	assertNotNull("The object doubleColumnType must not be null for this tests", doubleColumnType); 
    	String doubleColumnName = "columOfDoubles";
    	Column columnOfbooleans = new Column(doubleColumnName, doubleColumnType);
    	assertNotNull("the object columnOfbooleans must exit for this tests", columnOfbooleans);
    	
    	//creation of column of Strings for the tests cases parameters
    	T_String stringColumnType = new T_String();
    	assertNotNull("The object stringColumnType must not be null for this tests", stringColumnType); 
    	String stringColumnName = "columOfStrings";
    	Column columnOfStrings = new Column(stringColumnName, stringColumnType);
    	assertNotNull("the object columnOfStrings must exit for this tests", columnOfStrings);
    	
    	//creation of column of booleans for the tests cases parameters
    	T_Bool booleanColumnType = new T_Bool();
    	assertNotNull("The object booleanColumnType must not be null for this tests", booleanColumnType); 
    	String booleanColumnName = "columOfBooleans";
    	Column columnOfBooleans = new Column(booleanColumnName, booleanColumnType);
    	assertNotNull("the object columnOfbooleans must exit for this tests", columnOfBooleans);
    	
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public static Test suite()
    {
        return new TestSuite( ColumnTest.class );
    }
	
	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	public ColumnTest(String testName) {
		super(testName);
	}
	
	 /**
     * @return the suite of tests being tested
     */
    /*public static Test suite() {
        return new TestSuite( ColumnTest.class );
    }
    
    /**
     * test the constructor method 
     */
    public void testColumn() {
    	String columnName = "intColumn";
    	T_Int  columnType = new T_Int();
    	assertNotNull("The object columType must not be null for this test", columnType); 
    	Column myColumn = new Column(columnName, columnType);
    	assertNotNull("the object myColum must exit for this test case", myColumn);
    	
    	if(myColumn.getName() != columnName) {
    		fail("The column of integers myColumn is not created correctly || names do not match");
    	}
    	else if(myColumn.getType()!="int") {
    		fail("The column of integers myColumn is not created correctly || type is not an int");
    	}
    }
    
    public void testGetType() {
    	String columnName = "intColumn";
    	T_Int  columnType = new T_Int();
    	assertNotNull("columTyp must not be null for this test", columnType); // assume the type of the column is created
    	Column myColumn = new Column(columnName, columnType);
    	assertNotNull("the object myColum must exit for this test case", columnType);
    	
    	if(myColumn.getType() != columnType.getType()) {
    		fail("The method getType() of class Column does not work correctly");
    	}
    }
    
    public void testGetName() {
    	String columnName = "intColumn";
    	T_Int  columnType = new T_Int();
    	assertNotNull("columTyp must exit for this test", columnType);
    	Column myColumn = new Column(columnName, columnType);
    	assertNotNull("myColum must exist for this test", myColumn);
    	
    	if(myColumn.getName() != columnName) {
    		fail("The method getName() of class Column does not work correctly");
    	}
    }
   
    public void testSetName() {
    	String columnName = "stringColumn";
    	T_String  columnType = new T_String();
    	assertNotNull("the objetc columnType mus exist for this test case", columnType);
    	Column myStringColumn = new Column(columnName, columnType);
    	String newName = "newName";
    	myStringColumn.setName(newName);
    	
    	if(myStringColumn.getName() != newName) {
    		fail("function setName() of the class Column does not work correctly");
    	}
    }
    
    public void testSetBadColumnName() {
    	int name = 1;
    	//fail("not yet implemented");
    }
     public void testSetBadColumn() {
    	// fail("Not yet implemented");
     }
    
     public void testSuccessCompareTo() {
    	// fail("Not yet implemented");
     }
     
     public void testFailureCompareToTest() {
    	// fail("Not yet implemented");
     }


}

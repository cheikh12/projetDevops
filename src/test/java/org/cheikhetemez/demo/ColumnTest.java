package org.cheikhetemez.demo;

import column.Column;
import interfaces.Type_t_itf;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import type_t.T_Bool;
import type_t.T_Double;
import type_t.T_Int;
import type_t.T_String;

public class ColumnTest extends TestCase {
	
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
    
    public void testSetType() {
    	Type_t_itf newType = new T_String();
    	assertNotNull(newType);
    	Type_t_itf typeForChange = new T_Bool();
    	assertNotNull(typeForChange);
    	Column newColumn = new Column("MyColumn", newType);
    	assertNotNull(newColumn);
    	newColumn.setType(typeForChange);
    	
    	if(newColumn.getType() != "bool") {
    		fail("TEST FAILDE : Method setType of Column does not work");
    	}
    	
    }
    public void testCompareTo() {
    	Type_t_itf newType = new T_String();
    	assertNotNull(newType);
    	Column newColumn = new Column("MyColumn", newType);
    	Column sameColumn = newColumn;
    	
    	
    	if(!(newColumn.compareTo(sameColumn) == 0)) {
    		fail("TEST FAILDE : Method compareTo of Column does not work");
    	}
    }
    
    public void testCompareToWithDifferentValue() {

    	    Type_t_itf newType = new T_String();
	       	assertNotNull(newType); 
	       	Column newColumn = new Column("MyColumn", newType);
	       	assertNotNull(newColumn);
	       	Column anothercol = new Column("nouveau", newType);
	       	
	       	if((newColumn.compareTo(anothercol) == 0)) {
	       		fail("TEST FAILDE : Method compareTo of Column does not work");
	       	}

    	
    }
    

    
    
    public void testEquals() {
    	Type_t_itf newType = new T_String();
    	assertNotNull(newType);
    	Type_t_itf anotherType = new T_Int();
    	assertNotNull(anotherType);
    	Column newColumn = new Column("MyColumn", newType);
    	assertNotNull(newColumn);
    	Column anotherColumn = new Column("anotherColum", anotherType);
    	
    	if(anotherColumn.equals(newColumn)) {
    		fail("TEST FAILDE : Method equals of Column does not work");
    	}
    } 
    
    public void testEqualsWithBadValue() {
    	try {
    		Type_t_itf newType = new T_String();
        	Object newObject = new Object();
        	Column newColumn = new Column("MyColumn", newType);
        	assertNotNull(newColumn);

        	if(newColumn.equals(newObject)) { 
        		fail("TEST FAILDE : Method equals of Column does not work");
        	}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
    }
    
    public void testUtilitaries() {
    	Column forTest = new Column("col", new T_Int());
    	forTest.setName("changed");
    	forTest.setType(new T_Bool());
    	boolean b = forTest.equals(forTest);
    	
    	if(forTest == null) {
    		fail("");
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

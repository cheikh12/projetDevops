/**
 * 
 */
package org.cheikhetemez.demo;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import interfaces.Type_t_itf;
import junit.framework.TestCase;
import row.Row;
import type_t.T_Bool;
import type_t.T_Double;
import type_t.T_Int;
import type_t.T_String;

/**
 * @author mbeng
 *
 */
public class RowTest extends TestCase {
	private static Type_t_itf intType;
	private static Type_t_itf stringType;
	private static Type_t_itf boolType;
	private static Type_t_itf doubleType;
	private static Row intRow;
	private static Row stringRow;
	private static Row boolRow;
	private static Row doubleRow;
	/**
	 * @param name
	 */
	public RowTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		intType = new T_Int();
		intRow = new Row(intType);
		assertNotNull("the object intType must exist for this tests", intType);
		assertNotNull("The object intRow must exist for this tests", intRow);
		stringType = new T_String();
		stringRow = new Row(stringType);
		assertNotNull("the object stringType must exist for this tests", stringType);
		assertNotNull("The object stringRow must exist for this tests", stringRow);
		boolType = new T_Bool();
		boolRow = new Row(boolType);
		assertNotNull("the object boolType must exist for this tests", boolType);
		assertNotNull("The object boolRow must exist for this tests", boolRow);
		doubleType = new T_Double();
		doubleRow = new Row(doubleType);
		assertNotNull("the object doubleType must exist for this tests", doubleType);
		assertNotNull("The object doubleRow must exist for this tests", doubleRow);
	}
	
	/*@Test
	public void testGetElement() {
		if(!intRow.getElement().equals(intType)) {
			fail("Method getElement of Row does not work correctly");
		}
    }*/
	
	@Test
	public void testSetElement() {
		Type_t_itf newType = new T_Int();
		//assertNotNull("The newTpe must exist for this test", newType);
		Row newIntRow = new Row(intType);
		//assertNotNull("The object newIntRow must exist for this test");
		Type_t_itf test = newIntRow.getElement();
		//assertNotNull("the method getElement of the class Row lust work for this test", test); //assume getElement method is functional
		newIntRow.setElement(newType);
		
		if(!newIntRow.getElement().equals(newType)) {
			fail("Method setElement of Row does not work correctly");
		}
		
}
	
	@Test
	public void testSetNullElement() {
		Type_t_itf n = null;
		Row newRow = new Row(n);
	   	 //fail("Not yet implemented");
	    }
	@Test
	public void testRow() {
	   	 //fail("Not yet implemented");
	    }
	

}

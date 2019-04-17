package org.cheikhetemez.demo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import interfaces.Type_t_itf;
import type_t.T_Bool;
import type_t.T_Double;
import type_t.T_Int;
import type_t.T_String;

public class T_IntTest {

	@Test
	public void testPrint() {
		Type_t_itf tInt =new T_Int();
		Type_t_itf tBool =new T_Bool();
		Type_t_itf tString =new T_String();
		Type_t_itf tDouble =new T_Double();
		tInt.print();
		tBool.print();
		tString.print();
		tDouble.print();
	}
	
	@Test
	public void testIsNull() {
		Type_t_itf t =new T_Int();
		if(t.isNull()) {
			fail("constructor is not correct");
		}
	}
}

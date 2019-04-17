package org.cheikhetemez.demo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import interfaces.Type_t_itf;
import type_t.T_Bool;

public class T_BoolTest {
	@Test
	public void testPrint() {
		Type_t_itf t = new T_Bool();
		t.print();
		
	}

}

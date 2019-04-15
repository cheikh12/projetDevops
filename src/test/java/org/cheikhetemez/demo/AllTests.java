package org.cheikhetemez.demo;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTest(AppTest.suite());
		suite.addTest(ColumnTest.suite());
		//$JUnit-END$
		return suite;
	}

}

package br.com.caelum.argentum;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ NegocioTest.class, br.com.caelum.argentum.reader.AllTests.class, br.com.caelum.argentum.indicadores.AllTests.class })
public class AllTests {

	@BeforeClass
	public static void setUpClass() {
		System.out.println("br.com.caelum.argentum.AllTests setup");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("br.com.caelum.argentum.AllTests tearDown");
	}

}

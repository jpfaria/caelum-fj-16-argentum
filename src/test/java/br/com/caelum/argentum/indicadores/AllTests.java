package br.com.caelum.argentum.indicadores;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = { MediaMovelSimplesTest.class, MediaMovelPonderadaTest.class })
public class AllTests {
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("br.com.caelum.argentum.indicadores.AllTests setup");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("br.com.caelum.argentum.indicadores.AllTests tearDown");
	}
	
}

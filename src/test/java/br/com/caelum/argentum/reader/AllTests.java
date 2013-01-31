package br.com.caelum.argentum.reader;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = { CandlestickFactoryTest.class, LeitorXMLTest.class })
public class AllTests {
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("br.com.caelum.argentum.reader.AllTests setup");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("br.com.caelum.argentum.reader.AllTests tearDown");
	}
	
}

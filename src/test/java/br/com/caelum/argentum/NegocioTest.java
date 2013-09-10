package br.com.caelum.argentum;

import java.util.Calendar;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NegocioTest {

	@BeforeClass
	public static void setUpClass() {
		System.out.println("br.com.caelum.argentum.NegocioTest setup");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("br.com.caelum.argentum.NegocioTest tearDown");
	}
	
	@Test
	public void testDataDoNegocioEhImutavel() {
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		
		Negocio n = new Negocio(10, 5, c);
		
		// essa mudança não deveria ficar visível, vamos testar:
		n.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		Assert.assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDataDoNegocioNaoPodeSerNulo() {
		
		@SuppressWarnings("unused")
		Negocio n = new Negocio(10, 5, null);
				
	}

}

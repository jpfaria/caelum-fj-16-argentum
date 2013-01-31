package br.com.caelum.argentum.reader;

import java.io.StringReader;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

//Permite utilizar todos os metodos estaticos do Assert
import static org.junit.Assert.*;

import br.com.caelum.argentum.Negocio;

public class LeitorXMLTest {

	@BeforeClass
	public static void setUpClass() {
		System.out.println("br.com.caelum.argentum.reader.LeitorXMLTest setup");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("br.com.caelum.argentum.reader.LeitorXMLTest tearDown");
	}
	
	@Test
	public void testLeitorDeXmlCarregaListaDeNegocio() {

		String xmlDeTeste = "<list><negocio><preco>43.5</preco><quantidade>1000</quantidade><data><time>555454646</time></data></negocio></list>";

		LeitorXML leitor = new LeitorXML();
		List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));
		
		assertEquals(1, negocios.size());
		
		for ( Negocio negocio : negocios  ) {
			
			assertEquals(43.5, negocio.getPreco(), 0.00001);
			assertEquals(1000, negocio.getQuantidade());
			
		}
		
	}

}

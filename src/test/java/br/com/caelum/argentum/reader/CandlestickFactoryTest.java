package br.com.caelum.argentum.reader;

import java.util.Arrays;

import java.util.Calendar;
import java.util.List;

// Permite utilizar todos os metodos estaticos do Assert
import static org.junit.Assert.*;
//import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.argentum.Candlestick;
import br.com.caelum.argentum.Negocio;

public class CandlestickFactoryTest {

	@BeforeClass
	public static void setUpClass() {
		System.out.println("br.com.caelum.argentum.reader.CandlestickFactoryTest setup");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("br.com.caelum.argentum.reader.CandlestickFactoryTest tearDown");
	}
	
	@Test
	public void testSimplesSequenciaDeNegocios() {

		Calendar hoje = Calendar.getInstance();

		Negocio negocio1 = new Negocio(40.5, 100, hoje);
		Negocio negocio2 = new Negocio(45.0, 100, hoje);
		Negocio negocio3 = new Negocio(39.8, 100, hoje);
		Negocio negocio4 = new Negocio(42.3, 100, hoje);

		List<Negocio> negocios = Arrays.asList(negocio1, negocio2, negocio3,
				negocio4);

		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);

		// metodos estaticos do org.junit.Assert
		assertEquals(40.5, candle.getAbertura(), 0.00001);
		assertEquals(42.3, candle.getFechamento(), 0.00001);
		assertEquals(39.8, candle.getMinimo(), 0.00001);
		assertEquals(45.0, candle.getMaximo(), 0.00001);
		assertEquals(16760.0, candle.getVolume(), 0.00001);

	}

	@Test
	public void testSemNegocios() {

		Calendar hoje = Calendar.getInstance();
		List<Negocio> negocios = Arrays.asList();

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);

		assertEquals(0.0, candle.getVolume(), 0.00001);

	}

	@Test
	public void testComApenasUmNegocio() {

		Calendar hoje = Calendar.getInstance();
		Negocio negocio1 = new Negocio(40.5, 100, hoje);

		List<Negocio> negocios = Arrays.asList(negocio1);
		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);

		assertEquals(40.5, candle.getAbertura(), 0.00001);
		assertEquals(40.5, candle.getFechamento(), 0.00001);
		assertEquals(40.5, candle.getMinimo(), 0.00001);
		assertEquals(40.5, candle.getMaximo(), 0.00001);
		assertEquals(4050.0, candle.getVolume(), 0.00001);

	}

	@Test
	public void testDataDoMesmoDia() {

		CandlestickFactory factory = new CandlestickFactory();
		Calendar data1 = Calendar.getInstance();
		Calendar data2 = Calendar.getInstance();

		assertEquals(true, factory.isMesmoDia(data1, data2));

	}

	@Test
	public void testConstruirCandlesDeMuitosNegociosComDatasDifentes() {
		
		Calendar hoje = Calendar.getInstance();
		
		Negocio negocio1 = new Negocio(40.5, 100, hoje);
		Negocio negocio2 = new Negocio(45.0, 100, hoje);
		Negocio negocio3 = new Negocio(39.8, 100, hoje);
		Negocio negocio4 = new Negocio(42.3, 100, hoje);

		Calendar amanha = (Calendar) hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		Negocio negocio5 = new Negocio(48.8, 100, amanha);
		Negocio negocio6 = new Negocio(49.3, 100, amanha);
		
		Calendar depois = (Calendar) amanha.clone();
		depois.add(Calendar.DAY_OF_MONTH, 1);

		Negocio negocio7 = new Negocio(51.8, 100, depois);
		Negocio negocio8 = new Negocio(52.3, 100, depois);

		List<Negocio> negocios = Arrays.asList(negocio1, negocio2, negocio3,
				negocio4, negocio5, negocio6, negocio7, negocio8);

		CandlestickFactory fabrica = new CandlestickFactory();

		List<Candlestick> candles = fabrica.constroiCandles(negocios);

		assertEquals(3, candles.size());
		assertEquals(40.5, candles.get(0).getAbertura(), 0.00001);
		assertEquals(42.3, candles.get(0).getFechamento(), 0.00001);
		assertEquals(48.8, candles.get(1).getAbertura(), 0.00001);
		assertEquals(49.3, candles.get(1).getFechamento(), 0.00001);
		assertEquals(51.8, candles.get(2).getAbertura(), 0.00001);
		assertEquals(52.3, candles.get(2).getFechamento(), 0.00001);
		
	}

}

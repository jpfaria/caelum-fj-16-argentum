package br.com.caelum.argentum.indicadores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.Candlestick;
import br.com.caelum.argentum.SerieTemporal;

public class MediaMovelPonderadaTest {

	private SerieTemporal criaSerie(double... valores) {

		List<Candlestick> candles = new ArrayList<Candlestick>();
		for (double d : valores) {
			// cria candle com todos valores iguais, mil de quantidade e uma
			// data qualquer
			candles.add(new Candlestick(d, d, d, d, 1000, Calendar
					.getInstance()));
		}
		return new SerieTemporal(candles);

	}

	@Test
	public void testMediaPonderada() {
		
		SerieTemporal serie = criaSerie(1, 2, 3, 4, 5, 6);
		MediaMovelPonderada mmp = new MediaMovelPonderada();
		
		// exemplo: calcula(2) é 1*1 + 2*2 +3*3 = 14. Divide por 6, da 14/6
		Assert.assertEquals(14d / 6, mmp.calcula(2, serie), 0.00001);
		Assert.assertEquals(20d / 6, mmp.calcula(3, serie), 0.00001);
		Assert.assertEquals(26d / 6, mmp.calcula(4, serie), 0.00001);
		Assert.assertEquals(32d / 6, mmp.calcula(5, serie), 0.00001);

	}

}

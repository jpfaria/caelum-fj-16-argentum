package br.com.caelum.argentum;

import java.util.GregorianCalendar;

import br.com.caelum.argentum.reader.CandlestickBuilder;

public class TestaCandlestickBuilder {

	public static void main(String[] args) {

		Candlestick candle = new CandlestickBuilder().abertura(40.5)
				.fechamento(42.3).minimo(39.8).maximo(45).volume(145234.20)
				.data(new GregorianCalendar(2008, 8, 12, 0, 0, 0)).geraCandle();

		System.out.println(candle);

	}

}

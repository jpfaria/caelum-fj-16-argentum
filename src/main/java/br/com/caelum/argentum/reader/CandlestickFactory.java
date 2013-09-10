package br.com.caelum.argentum.reader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.Candlestick;
import br.com.caelum.argentum.Negocio;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data,
			List<Negocio> negocios) {

		double abertura = negocios.isEmpty() ? 0.0 : negocios.get(0).getPreco();

		double fechamento = negocios.isEmpty() ? 0.0 : negocios.get(
				negocios.size() - 1).getPreco();

		double minimo = Double.MAX_VALUE;
		double maximo = Double.MIN_VALUE;
		double volume = 0;

		for (Negocio negocio : negocios) {

			volume += negocio.getVolume();

			if (negocio.getPreco() > maximo) {
				maximo = negocio.getPreco();
			}

			if (negocio.getPreco() < minimo) {
				minimo = negocio.getPreco();
			}

		}

		return new CandlestickBuilder().abertura(abertura)
				.fechamento(fechamento).minimo(minimo).maximo(maximo)
				.volume(volume).data(data).geraCandle();
	}

	public boolean isMesmoDia(Calendar data1, Calendar data2) {

		return data1.get(Calendar.DATE) == data2.get(Calendar.DATE)
				&& data1.get(Calendar.MONTH) == data2.get(Calendar.MONTH)
				&& data1.get(Calendar.YEAR) == data2.get(Calendar.YEAR);
	}

	public List<Candlestick> constroiCandles(List<Negocio> todosNegocios) {

		List<Candlestick> candles = new ArrayList<Candlestick>();

		// lista com negocios que sejam do mesmo dia que dataPrimeiro
		List<Negocio> negociosMesmoDia = new ArrayList<Negocio>();

		// pega data do primeiro item
		Calendar data = todosNegocios.get(0).getData();

		for (Negocio negocio : todosNegocios) {

			// se não for mesmo dia, fecha candle e reinicia variáveis
			if (!isMesmoDia(data, negocio.getData())) {

				fechaCandle(candles, negociosMesmoDia, data);

				negociosMesmoDia = new ArrayList<Negocio>();
				data = negocio.getData();
			}

			negociosMesmoDia.add(negocio);

		}

		fechaCandle(candles, negociosMesmoDia, data);

		return candles;

	}

	private void fechaCandle(List<Candlestick> candles,
			List<Negocio> negociosMesmoDia, Calendar data) {
		
		candles.add(constroiCandleParaData(data, negociosMesmoDia));
		
	}

}
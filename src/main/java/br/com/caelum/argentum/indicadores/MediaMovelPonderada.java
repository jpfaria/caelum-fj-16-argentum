package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.Candlestick;
import br.com.caelum.argentum.SerieTemporal;

public class MediaMovelPonderada  implements Indicador{

	public double calcula(int posicao, SerieTemporal serie) {
		
		double soma = 0.0;
		int peso = 1;
		for (int i = posicao - 2; i <= posicao; i++) {
			Candlestick c = serie.getCandle(i);
			soma += c.getFechamento() * peso;
			peso++;
		}
		return soma / 6;
	}

}

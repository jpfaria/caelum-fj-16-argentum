package br.com.caelum.argentum.reader;

import java.util.Calendar;

import br.com.caelum.argentum.Candlestick;

public class CandlestickBuilder {

	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;
	 
	public CandlestickBuilder abertura(double abertura) {
		this.abertura = abertura;
		return this;
	}

	public CandlestickBuilder fechamento(double fechamento) {
		this.fechamento = fechamento;
		return this;
	}
	
	public CandlestickBuilder minimo(double minimo) {
		this.minimo = minimo;
		return this;
	}
	
	public CandlestickBuilder maximo(double maximo) {
		this.maximo = maximo;
		return this;
	}
	
	public CandlestickBuilder volume(double volume) {
		this.volume = volume;
		return this;
	}
	
	public CandlestickBuilder data(Calendar data) {
		this.data = data;
		return this;
	}
	
	public Candlestick geraCandle() {
		
		return new Candlestick(abertura, fechamento, minimo, maximo, volume,
				data);
		
	}

}

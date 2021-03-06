package br.com.caelum.argentum.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import br.com.caelum.argentum.Negocio;

public class ArgentumUI {

	private JFrame janela;
	private JPanel painelPrincipal;
	private JTable tabela;

	public static void main(String[] args) {

		Locale.setDefault(new Locale("pt", "BR"));

		new ArgentumUI().montaTela();
	}

	public void montaTela() {

		montaJanela();
		montaPainelPrincipal();
		montaTitulo();
		montaTabelaComScroll();
		montaBotaoCarregar();
		montaBotaoSair();
		mostraJanela();

	}

	private void montaJanela() {

		janela = new JFrame("Argentum");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void montaPainelPrincipal() {
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);
	}

	private void montaBotaoCarregar() {
		JButton botaoCarregar = new JButton("Carregar XML");
		botaoCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Negocio> negocios = new EscolheXML().escolher();
				NegociosTableModel ntm = new NegociosTableModel(negocios);
				tabela.setModel(ntm);
			}
		});
		painelPrincipal.add(botaoCarregar);
	}

	private void montaBotaoSair() {
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		painelPrincipal.add(botaoSair);
	}

	private void mostraJanela() {
		janela.pack();
		janela.setSize(540, 540);
		janela.setVisible(true);
	}

	private void montaTabelaComScroll() {

		tabela = new JTable();
		tabela.setBorder(new LineBorder(Color.black));
		tabela.setGridColor(Color.black);
		tabela.setShowGrid(true);

		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().setBorder(null);
		scroll.getViewport().add(tabela);
		scroll.setSize(450, 450);

		painelPrincipal.add(scroll);

	}

	private void montaTitulo() {

		JLabel titulo = new JLabel("Lista de Negócios");
		titulo.setFont(new Font("Verdana", Font.BOLD, 25));
		titulo.setForeground(new Color(50, 50, 100));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		painelPrincipal.add(titulo);
	}

}

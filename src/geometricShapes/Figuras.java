package geometricShapes;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dados.GetProperties;

/**
 * Classe Abstrata, que ir� se extender para as outras classes do pacote
 * geometricShapes, � a responsavel pelos atributos e m�todos de configura��o
 * que as outras classes de figuras v�o herdar.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public abstract class Figuras extends GetProperties {
	protected final static JButton bCalcular = new JButton("Calcular");
	protected static final Font fonte = new Font("Arial", Font.CENTER_BASELINE, 20); // Personalizado uma fonte padr�o
	protected static double volume;
	protected static JPanel painel2;
	protected static double area;
	protected final JLabel rArea = new JLabel();
	protected final JLabel rVolume = new JLabel();
	protected static DecimalFormat df = new DecimalFormat("0.##");
	protected static String dV, dA, figura;
	protected static JLabel image;

	/**
	 * Metodo responsavel por retornar o valor do calculo da area.
	 * 
	 * @return area
	 */
	public double getArea() {
		return area;
	}

	/**
	 * Metodo responsavel por retornar o valor do calculo de volume
	 * 
	 * @return
	 */
	public double getVolume() {
		return volume;
	}

	/**
	 * Metodo responsavel por realizar o calculo da area
	 */
	protected abstract void calcArea();

	/**
	 * Metodo responsavel por realizar o calculo do Volume
	 */
	protected void calcVolume() {
		volume = 0;
	}

	/**
	 * Metodo responsavel por obter os valores para resolu��o do calculo do volume.
	 */
	public void setVolume() {
		calcVolume();
	}

	/**
	 * Metodo responsavel por obter os valores para resolu��o do calculo do volume.
	 */
	public void setVolume(double opcao1) {
		calcVolume();
	}

	/**
	 * Metodo responsavel por obter os valores para resolu��o do calculo do volume.
	 */
	public void setVolume(double opcao1, double opcao2) {
		calcVolume();
	}

	/**
	 * Metodo responsavel por obter os valores para resolu��o do calculo do volume.
	 */
	public void setVolume(double opcao1, double opcao2, double opcao3) {
		calcVolume();
	}

	/**
	 * Metodo responsavel por obter os valores para resolu��o dos calculos de area.
	 */
	public void setArea(double opcao1) {
		calcArea();
	}

	/**
	 * Metodo responsavel por obter os valores para resolu��o dos calculos de area.
	 */
	public void setArea(double opcao1, double opcao2) {
		calcArea();
	}

	/**
	 * Metodo responsavel por obter os valores para resolu��o dos calculos de area.
	 */
	public void setArea(double opcao1, double opcao2, double opcao3) {
		calcArea();
	}

	/**
	 * Metodo responsavel por definir os JLabel,JTEXTFIELD e a figura que vai
	 * carregar na tela, e chamar os metodos necessarios para a resolu�ao dos
	 * calculos.
	 * 
	 * @return JPanel
	 */
	public abstract JPanel montaRequisitos();

	/**
	 * Metodo responsavel por chamar por chamar a classe responsavel por armazenar
	 * os dados da opera��o em um arquivo txt.
	 * 
	 * @throws IOException
	 */
	protected abstract void salvarDates() throws IOException;

	/**
	 * Metodo responsavel por verificar se algum campo n�o foi preenchido.
	 * 
	 * @param opcao
	 * @return boolean
	 */
	protected boolean checkinformation(String opcao) {
		if (!opcao.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo responsavel por verificar se algum campo n�o foi preenchido.
	 * 
	 * @param opcao
	 * @return boolean
	 */
	protected boolean checkinformation(String opcao, String opcao2) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Metodo responsavel por verificar se algum campo n�o foi preenchido.
	 * 
	 * @param opcao
	 * @return boolean
	 */
	protected boolean checkinformation(String opcao, String opcao2, String opcao3) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Metodo responsavel por verificar se algum campo n�o foi preenchido.
	 * 
	 * @param opcao
	 * @return boolean
	 */
	protected boolean checkinformation(String opcao, String opcao2, String opcao3, String opcao4) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Adicionar o Evento aos JTextField's
	 */
	protected void eventPut(JTextField opcao1) {
		opcao1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					bCalcular.doClick();
				}
			}
		});
	}
}

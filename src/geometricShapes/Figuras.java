package geometricShapes;

import java.awt.Font;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dados.GetProperties;

/**
 * Classe mãe das outras classes de figuras,ela é a responsavel pelos atributos
 * de configuração que as outras classes de figuras vão herdar e os seus
 * metodos.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public abstract class Figuras extends GetProperties {
	protected final JButton bCalcular = new JButton("Calcular");
	protected final Font fonte = new Font("Arial", Font.CENTER_BASELINE, 20); // Personalizado uma fonte para o JButton
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
	protected void calcVolume() {}

	/**
	 * Metodo responsavel por definir os JLabel,JTEXTFIELD e figura que vai carregar
	 * na tela, e chama os metodos necessarios para a resoluçao dos calculos
	 * 
	 * @return JPanel
	 */
	public abstract JPanel montaRequisitos();

	/**
	 * Metodo responsavel por chamar por chamar a classe responsavel por armazenar
	 * os dados da operação em um arquivo txt.
	 * 
	 * @throws IOException
	 */
	protected abstract void salvarDates() throws IOException;

	/**
	 * Metodo responsavel por obter os valores para resolução do calculo do volume.
	 */
	public void setVolume() {
	}

	/**
	 * Metodo responsavel por obter os valores para resolução dos calculos de area.
	 */
	public void setArea() {

	}
}

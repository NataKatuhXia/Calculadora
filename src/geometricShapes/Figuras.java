package geometricShapes;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe mãe das outras classes de figuras,ela é a responsavel pelos atributos
 * de configuração que as outras classes de figuras vão herdar e alguns metodos.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public abstract class Figuras {
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
	protected static Properties prop = new Properties();

	public double getArea() {
		return area;
	}

	public double getVolume() {
		return volume;
	}

	protected abstract void calcArea();

	public abstract JPanel montaRequisitos();

	protected abstract void salvarDates() throws IOException;

	public void setVolume() {
		// Metodo
	}

	public void setArea() {

	}

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./src/properties/listFiguras.properties");
		props.load(file);

		return props;
	}

}

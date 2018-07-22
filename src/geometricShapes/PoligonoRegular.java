package geometricShapes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dados.SaveData;
import geometricShapes.Figuras;
import interfaceG.InterfaceGrafica;

/**
 * Classe utilizada para realizar os cálculos de area do PoligonoRegular ,e
 * apresentar os seus resultados na interface,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class PoligonoRegular extends Figuras {
	private double perimetro;
	private double apotema;
	private JTextField Tapotema;
	private JTextField Tperimetro;

	@Override
	public void setArea(double perimetro, double apotema) {
		// Metodo para o calculo da area do Poligono Regular, recebe como parametro
		// perimetro e a apotema
		this.perimetro = perimetro;
		this.apotema = apotema;
		calcArea();

	}

	@Override
	protected boolean checkinformation(String opcao, String opcao2) {
		if (!opcao.isEmpty() && (!opcao2.isEmpty())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	protected void calcArea() {
		// Calculo da Area
		area = (perimetro * apotema) / 2;
	}

	@Override
	public JPanel montaRequisitos() {
		painel2 = new JPanel();
		painel2.setLayout(null);
		painel2.setVisible(true);
		painel2.setBounds(0, 157, 994, 604);

		figura = "Polígono Regular";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((Tperimetro.getText()), (Tapotema.getText()))) {
					try {
						setArea(Double.parseDouble(Tperimetro.getText()), Double.parseDouble(Tapotema.getText()));
						dA = df.format(getArea());
						rArea.setText("Área:      " + dA + " cm²");
						rArea.setBounds(550, 300, 250, 30);
						rArea.setFont(fonte);
						painel2.add(rArea);
						painel2.repaint();
						salvarDates();

					} catch (NumberFormatException x) {
						JOptionPane.showMessageDialog(null, "Por favor, preencha apenas com números inteiros!",
								"Aviso!", JOptionPane.WARNING_MESSAGE);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Não é permitido campos em branco!", "Aviso!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		bCalcular.setFont(fonte);// O JButton recebendo a fonte
		bCalcular.setBounds(350, 307, 130, 40); // Informando a localizacao e o tamanho do JButton
		bCalcular.setVisible(true);// Informando que o JButton ficara visível
		painel2.add(bCalcular);

		JLabel Lperimetro = new JLabel("Perimetro:");
		Lperimetro.setFont(fonte);
		Lperimetro.setBounds(104, 45, 104, 24);
		Lperimetro.setVisible(true);
		painel2.add(Lperimetro);

		JLabel Lapotema = new JLabel("Apótema:");
		Lapotema.setFont(fonte);
		Lapotema.setBounds(104, 110, 104, 24);
		Lapotema.setVisible(true);
		painel2.add(Lapotema);

		Tperimetro = new JTextField();
		eventPut(Tperimetro);
		Tperimetro.setFont(fonte);
		Tperimetro.setBounds(213, 43, 145, 30);
		Tperimetro.setVisible(true);
		painel2.add(Tperimetro);

		Tapotema = new JTextField();
		eventPut(Tapotema);
		Tapotema.setFont(fonte);
		Tapotema.setBounds(213, 108, 145, 30);
		Tapotema.setVisible(true);
		painel2.add(Tapotema);

		image = new JLabel();
		image.setIcon(new ImageIcon(InterfaceGrafica.class.getResource("/figures/" + figura + ".jpg")));
		image.setBounds(450, 0, 356, 280);
		painel2.add(image);

		return painel2;
	}

	@Override
	protected void salvarDates() throws IOException {
		new SaveData(figura, dA);

	}

}

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
 * Classe utilizada para realizar os cálculos de volume e area da CunhaEsferica
 * ,e apresentar os seus resultados na interface,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class CunhaEsferica extends Figuras {

	private double raio;
	private double angulo;
	private JTextField Traio;
	private JTextField Tangulo;

	public void setVolume(double raio, double angulo) {
		// Metodo para o calculo do volume da Cunha esferica, recebe como parametro raio
		// da esfera e o angulo da Cunha
		this.raio = raio;
		this.angulo = angulo;
		calcVolume();

	}

	public void setArea(double raio, double angulo) {
		// Metodo para o calculo do volume da Cunha esferica, recebe como parametro raio
		// da esfera e o angulo da Cunha
		this.raio = raio;
		this.angulo = angulo;
		calcArea();
	}

	@Override
	protected void calcArea() {
		// Calculo da Area
		area = ((3.14 * Math.pow(raio, 2)) * angulo) / 90;
	}

	private void calcVolume() {
		// Calculo do Volume
		volume = ((angulo / 360) * ((4 * Math.PI)) * Math.pow(raio, 3));
	}

	protected boolean checkinformation(String opcao, String opcao2) {
		if (!opcao.isEmpty() && (!opcao2.isEmpty())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public JPanel montaRequisitos() {
		painel2 = new JPanel();
		painel2.setLayout(null);
		painel2.setVisible(true);
		painel2.setBounds(0, 157, 994, 604);

		figura = "Cunha Esférica";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((Traio.getText()), (Tangulo.getText()))) {
					try {
						setArea(Integer.parseInt(Traio.getText()), Integer.parseInt(Tangulo.getText()));
						setVolume(Integer.parseInt(Traio.getText()), Integer.parseInt(Tangulo.getText()));
						dV = df.format(getVolume());
						dA = df.format(getArea());
						rArea.setText("Área:      " + dA + " cm²");
						rVolume.setText(" Volume: " + dV + " cm³");
						rArea.setBounds(550, 300, 250, 30);
						rVolume.setBounds(545, 320, 250, 30);
						rVolume.setFont(fonte);
						rArea.setFont(fonte);
						painel2.add(rVolume);
						painel2.add(rArea);
						painel2.repaint();
						salvarDates();

					} catch (NumberFormatException | IOException x) {
						JOptionPane.showMessageDialog(null, "Por favor, preencha apenas com números inteiros!",
								"Aviso!", JOptionPane.WARNING_MESSAGE);
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

		JLabel Lraio = new JLabel("Raio:");
		Lraio.setFont(fonte);
		Lraio.setBounds(114, 45, 104, 24);
		Lraio.setVisible(true);
		painel2.add(Lraio);

		Traio = new JTextField();
		Traio.setFont(fonte);
		Traio.setBounds(213, 43, 145, 30);
		Traio.setVisible(true);
		painel2.add(Traio);

		JLabel Langulo = new JLabel("Angulo:");
		Langulo.setFont(fonte);
		Langulo.setBounds(114, 110, 104, 24);
		Langulo.setVisible(true);
		painel2.add(Langulo);

		Tangulo = new JTextField();
		Tangulo.setFont(fonte);
		Tangulo.setBounds(213, 108, 145, 30);
		Tangulo.setVisible(true);
		painel2.add(Tangulo);

		image = new JLabel();
		image.setIcon(new ImageIcon(InterfaceGrafica.class.getResource("/figures/" + figura + ".jpg")));
		image.setBounds(450, 0, 356, 280);
		painel2.add(image);

		return painel2;
	}

	@Override
	protected void salvarDates() throws IOException {
		new SaveData(figura, dA, dV);

	}

}
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
 * Classe utilizada para realizar os cálculos de volume e area do
 * TetraedroRegular ,e apresentar os seus resultados na interface,e os salva em
 * um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class TetraedroRegular extends Figuras {
	private double tamLado;
	private JTextField Tlado;

	/**
	 * 
	 * @param tamLado
	 */
	public void setVolume(double tamLado) {

		this.tamLado = tamLado;

		this.calcVolume();

	}

	/**
	 * 
	 * @param tamLado
	 */
	public void setArea(double tamLado) {
		this.tamLado = Math.abs(tamLado);

		this.calcArea();

	}

	@Override
	protected void calcVolume() {
		volume = ((Math.pow(tamLado, 3)) * Math.sqrt(2)) / 12;
	}

	@Override
	protected void calcArea() {
		area = Math.pow(tamLado, 2) * Math.sqrt(3);
	}

	/**
	 * Metodo responsavel por verificar se algum campo não foi preenchido.
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

	@Override
	public JPanel montaRequisitos() {
		painel2 = new JPanel();
		painel2.setLayout(null);
		painel2.setVisible(true);
		painel2.setBounds(0, 157, 994, 604);

		figura = "Tetaedro Regular";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((Tlado.getText()))) {
					try {
						setArea(Double.parseDouble(Tlado.getText()));
						setVolume(Double.parseDouble(Tlado.getText()));
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

		JLabel Llado = new JLabel("T. Lado:");
		Llado.setFont(fonte);
		Llado.setBounds(114, 45, 104, 24);
		Llado.setVisible(true);
		painel2.add(Llado);

		Tlado = new JTextField();
		Tlado.setFont(fonte);
		Tlado.setBounds(213, 43, 145, 30);
		Tlado.setVisible(true);
		painel2.add(Tlado);

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
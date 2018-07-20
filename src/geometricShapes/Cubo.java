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
 * Classe utilizada para realizar os cálculos de volume e area do Cubo ,e
 * apresentar os seus resultados na interface,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class Cubo extends Figuras {

	private double aresta;
	private JTextField Taresta;

	public void setVolume(int aresta) {
		// Metodo para receber os valores necessarios para realizar os calculos
		this.aresta = aresta;
		calcVolume();

	}

	protected boolean checkinformation(String opcao) {
		if (!opcao.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	public void setArea(int aresta) {
		// Metodo para receber os valores necessarios para realizar os calculos
		this.aresta = aresta;
		calcArea();

	}

	private void calcVolume() {
		// Calculo do Volume
		volume = Math.pow(aresta, 3);
	}

	@Override
	protected void calcArea() {
		// Calculo da Area
		area = (6 * Math.pow(aresta, 2));

	}

	@Override
	public JPanel montaRequisitos() {
		painel2 = new JPanel();
		painel2.setLayout(null);
		painel2.setVisible(true);
		painel2.setBounds(0, 157, 994, 604);

		figura = "Cubo";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((Taresta.getText()))) {
					try {
						setArea(Integer.parseInt(Taresta.getText()));
						setVolume(Integer.parseInt(Taresta.getText()));
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

		JLabel Laresta = new JLabel("Aresta:");
		Laresta.setFont(fonte);
		Laresta.setBounds(114, 45, 104, 24);
		Laresta.setVisible(true);
		painel2.add(Laresta);

		Taresta = new JTextField();
		Taresta.setFont(fonte);
		Taresta.setBounds(213, 43, 145, 30);
		Taresta.setVisible(true);
		painel2.add(Taresta);

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
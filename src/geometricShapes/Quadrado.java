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
 * Classe utilizada para realizar o cálculo de area do Quadrado ,e apresentar os
 * seus resultados na interface,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class Quadrado extends Figuras {

	private double lado;
	private JTextField Tlado;

	@Override
	public void setArea(double lado) {
		// Metodo para receber os valores necessarios para realizar os calculos
		this.lado = lado;
		calcArea();

	}

	@Override
	protected void calcArea() {
		// Calculo da Area
		area = Math.pow(lado, 2);
	}

	@Override
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

		figura = "Quadrado";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((Tlado.getText()))) {
					try {
						setArea(Double.parseDouble(Tlado.getText()));
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

		JLabel Llado = new JLabel("Lado:");
		Llado.setFont(fonte);
		Llado.setBounds(114, 45, 104, 24);
		Llado.setVisible(true);
		painel2.add(Llado);

		Tlado = new JTextField();
		eventPut(Tlado);
		Tlado.setFont(fonte);
		Tlado.setBounds(213, 43, 145, 30);
		Tlado.setVisible(true);
		painel2.add(Tlado);

		image = new JLabel();
		image.setIcon(new ImageIcon(InterfaceGrafica.class.getResource("/figures/" + figura + ".jpg")));
		image.setBounds(500, 0, 356, 280);
		painel2.add(image);

		return painel2;
	}

	@Override
	protected void salvarDates() throws IOException {
		new SaveData(figura, dA);

	}

}
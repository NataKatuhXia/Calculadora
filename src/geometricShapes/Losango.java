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
 * Classe utilizada para realizar o cálculo de area do Losango ,e apresentar os
 * seus resultados na interface,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class Losango extends Figuras {
	private double diagonalMaior;
	private double diagonalMenor;
	private JTextField TdiagonalMaior;
	private JTextField TdiagonalMenor;

	public void setArea(double diagonalMaior, double diagonalMenor) {
		// Metodo para receber os valores necessarios para realizar os calculos
		this.diagonalMaior = diagonalMaior;
		this.diagonalMenor = diagonalMenor;
		calcArea();

	}

	@Override
	protected void calcArea() {
		// Calculo da area
		area = (diagonalMaior * diagonalMenor) / 2;
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

		figura = "Losango";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((TdiagonalMaior.getText()), (TdiagonalMenor.getText()))) {
					try {
						setArea(Integer.parseInt(TdiagonalMaior.getText()), Integer.parseInt(TdiagonalMenor.getText()));
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

		JLabel LdiagonalMaior = new JLabel("Diagonal Maior:");
		LdiagonalMaior.setFont(fonte);
		LdiagonalMaior.setBounds(50, 45, 150, 24);
		LdiagonalMaior.setVisible(true);
		painel2.add(LdiagonalMaior);

		JLabel LdiagonalMenor = new JLabel("Diagonal Menor:");
		LdiagonalMenor.setFont(fonte);
		LdiagonalMenor.setBounds(50, 110, 160, 24);
		LdiagonalMenor.setVisible(true);
		painel2.add(LdiagonalMenor);

		TdiagonalMaior = new JTextField();
		TdiagonalMaior.setFont(fonte);
		TdiagonalMaior.setBounds(213, 43, 145, 30);
		TdiagonalMaior.setVisible(true);
		painel2.add(TdiagonalMaior);

		TdiagonalMenor = new JTextField();
		TdiagonalMenor.setFont(fonte);
		TdiagonalMenor.setBounds(213, 108, 145, 30);
		TdiagonalMenor.setVisible(true);
		painel2.add(TdiagonalMenor);

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

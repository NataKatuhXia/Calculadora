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
 * Classe utilizada para realizar o cálculo de area da CoroaCircular ,e
 * apresentar os seus resultados na interface,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class CoroaCircular extends Figuras {

	private double raiomaior;
	private double raiomenor;
	private JTextField TraioMaior;
	private JTextField TraioMenor;

	@Override
	public void setArea(double raiomenor, double raiomaior) {
		// Metodo para receber os valores necessarios para realizar os calculos
		this.raiomaior = raiomaior;
		this.raiomenor = raiomenor;

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
		// Calculo da area
		area = 3.14 * (Math.pow(raiomaior, 2) - Math.pow(raiomenor, 2));
	}

	@Override
	public JPanel montaRequisitos() {
		painel2 = new JPanel();
		painel2.setLayout(null);
		painel2.setVisible(true);
		painel2.setBounds(0, 157, 994, 604);

		figura = "Coroa Circular";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((TraioMenor.getText()), (TraioMaior.getText()))) {
					try {
						setArea(Double.parseDouble(TraioMenor.getText()), Double.parseDouble(TraioMaior.getText()));
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

		JLabel LraioMaior = new JLabel("Raio Maior:");
		LraioMaior.setFont(fonte);
		LraioMaior.setBounds(90, 45, 120, 24);
		LraioMaior.setVisible(true);
		painel2.add(LraioMaior);

		JLabel LraioMenor = new JLabel("Raio Menor:");
		LraioMenor.setFont(fonte);
		LraioMenor.setBounds(90, 110, 120, 24);
		LraioMenor.setVisible(true);
		painel2.add(LraioMenor);

		TraioMaior = new JTextField();
		eventPut(TraioMaior);
		TraioMaior.setFont(fonte);
		TraioMaior.setBounds(213, 43, 145, 30);
		TraioMaior.setVisible(true);
		painel2.add(TraioMaior);

		TraioMenor = new JTextField();
		eventPut(TraioMenor);
		TraioMenor.setFont(fonte);
		TraioMenor.setBounds(213, 108, 145, 30);
		TraioMenor.setVisible(true);
		painel2.add(TraioMenor);

		image = new JLabel();
		image.setIcon(new ImageIcon(InterfaceGrafica.class.getResource("/figures/" + figura + ".jpg")));
		image.setBounds(480, 0, 356, 320);
		painel2.add(image);

		return painel2;
	}

	@Override
	protected void salvarDates() throws IOException {
		new SaveData(figura, dA);
	}

}
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
 * Classe utilizada para realizar os cálculos de volume e area do TroncodeCone
 * ,e apresentar os seus resultados na interface,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class TroncodeCone extends Figuras {
	private double raioMaior;
	private double raioMenor;
	private double geratriz;
	private double altura;
	private JTextField TraioMaior;
	private JTextField TraioMenor;
	private JTextField Tgeratriz;
	private JTextField Taltura;

	public void setArea(double raioMaior, double raioMenor, double geratriz) {
		// Metodo para receber os valores necessarios para realizar os calculos
		this.raioMaior = raioMaior;
		this.raioMenor = raioMenor;
		this.geratriz = geratriz;

		this.calcArea();

	}

	public void setVolume(double raioMaior, double raioMenor, double altura) {
		// Metodo para receber os valores necessarios para realizar os calculos
		this.raioMaior = raioMaior;
		this.raioMenor = raioMenor;
		this.altura = altura;
		this.calcVolume();
	}

	private void calcVolume() {
		// Calculo do Volume
		volume = 3.14 * (altura / 3) * (Math.pow(raioMaior, 2) + raioMaior * raioMenor + Math.pow(raioMenor, 2));
	}

	@Override
	protected void calcArea() {
		// Calculo da area
		area = 3.14 * ((raioMaior + raioMenor) * geratriz + Math.pow(raioMaior, 2) + Math.pow(raioMenor, 2));
	}

	protected boolean checkinformation(String opcao, String opcao2, String opcao3, String opcao4) {
		if (!opcao.isEmpty() && (!opcao2.isEmpty()) && (!opcao3.isEmpty()) && (!opcao4.isEmpty())) {
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
		painel2.setBounds(0, 130, 994, 604);

		figura = "Tronco do Cone";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((TraioMaior.getText()), (TraioMenor.getText()), (Tgeratriz.getText()),
						(Taltura.getText()))) {
					try {
						setArea(Integer.parseInt(TraioMaior.getText()), Integer.parseInt(TraioMenor.getText()),
								Integer.parseInt(Tgeratriz.getText()));
						setVolume(Integer.parseInt(TraioMaior.getText()), Integer.parseInt(TraioMenor.getText()),
								Integer.parseInt(Taltura.getText()));
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
						salvarDates();
						painel2.repaint();
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
		LraioMaior.setBounds(90, 40, 120, 24);
		LraioMaior.setVisible(true);
		painel2.add(LraioMaior);

		JLabel LraioMenor = new JLabel("Raio Menor:");
		LraioMenor.setFont(fonte);
		LraioMenor.setBounds(90, 105, 120, 24);
		LraioMenor.setVisible(true);
		painel2.add(LraioMenor);

		JLabel Lgeratriz = new JLabel("Geratriz:");
		Lgeratriz.setFont(fonte);
		Lgeratriz.setBounds(90, 170, 104, 24);
		Lgeratriz.setVisible(true);
		painel2.add(Lgeratriz);

		JLabel Laltura = new JLabel("Altura:");
		Laltura.setFont(fonte);
		Laltura.setBounds(90, 235, 104, 24);
		Laltura.setVisible(true);
		painel2.add(Laltura);

		TraioMaior = new JTextField();
		TraioMaior.setFont(fonte);
		TraioMaior.setBounds(213, 38, 145, 30);
		TraioMaior.setVisible(true);
		painel2.add(TraioMaior);

		TraioMenor = new JTextField();
		TraioMenor.setFont(fonte);
		TraioMenor.setBounds(213, 103, 145, 30);
		TraioMenor.setVisible(true);
		painel2.add(TraioMenor);

		Taltura = new JTextField();
		Taltura.setFont(fonte);
		Taltura.setBounds(213, 233, 145, 30);
		Taltura.setVisible(true);
		painel2.add(Taltura);

		Tgeratriz = new JTextField();
		Tgeratriz.setFont(fonte);
		Tgeratriz.setBounds(213, 168, 145, 30);
		Tgeratriz.setVisible(true);
		painel2.add(Tgeratriz);

		image = new JLabel();
		image.setIcon(new ImageIcon(InterfaceGrafica.class.getResource("/figures/" + figura + ".jpg")));
		image.setBounds(380, 0, 410, 280);
		painel2.add(image);

		return painel2;
	}

	@Override
	protected void salvarDates() throws IOException {
		new SaveData(figura, dA, dV);

	}
}

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
 * Classe utilizada para realizar os cálculos de volume e área do Cilindro ,e
 * apresentar os seus resultados na interface ,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class Cilindro extends Figuras {
	private double raio;
	private double altura;
	private JTextField Traio;
	private JTextField Taltura;

	/**
	 * 
	 * @param raio
	 * @param altura
	 */
	public void setVolume(double raio, double altura) {
		this.raio = Math.abs(raio);
		this.altura = Math.abs(altura);
		calcVolume();
	}

	/**
	 * 
	 * @param raio
	 * @param altura
	 */
	public void setArea(double raio, double altura) {
		this.raio = Math.abs(raio);
		this.altura = Math.abs(altura);

		calcArea();

	}

	@Override
	protected void calcArea() {
		area = (double) (2 * Constante.PI * raio * (raio + altura));
	}

	@Override
	protected void calcVolume() {
		volume = (double) (Constante.PI * altura * Math.pow(raio, 2));
	}

	/**
	 * Metodo responsavel por verificar se algum campo não foi preenchido.
	 * 
	 * @param opcao
	 * @param opcao2
	 * @return boolean
	 */
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

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((Traio.getText()), (Taltura.getText()))) {
					try {
						setArea(Double.parseDouble(Traio.getText()), Double.parseDouble(Taltura.getText()));
						setVolume(Double.parseDouble(Traio.getText()), Double.parseDouble(Taltura.getText()));
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
						JOptionPane.showMessageDialog(null, "Por favor, preencha apenas com números!",
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

		JLabel Lraio = new JLabel("Raio:");
		Lraio.setFont(fonte);
		Lraio.setBounds(114, 45, 104, 24);
		Lraio.setVisible(true);
		painel2.setLayout(null);
		painel2.add(Lraio);

		JLabel Laltura = new JLabel("Altura:");
		Laltura.setFont(fonte);
		Laltura.setBounds(114, 110, 104, 24);
		Laltura.setVisible(true);
		painel2.add(Laltura);

		Traio = new JTextField();
		Traio.setFont(fonte);
		Traio.setBounds(213, 43, 145, 30);
		Traio.setVisible(true);
		painel2.add(Traio);

		Taltura = new JTextField();
		Taltura.setFont(fonte);
		Taltura.setBounds(213, 108, 145, 30);
		Taltura.setVisible(true);
		painel2.add(Taltura);

		image = new JLabel();
		image.setIcon(new ImageIcon(InterfaceGrafica.class.getResource("/figures/Cilindro.jpg")));
		image.setBounds(500, 0, 356, 280);
		painel2.add(image);

		return painel2;
	}

	@Override
	protected void salvarDates() throws IOException {
		new SaveData("Cilindro", dA, dV);
	}

}

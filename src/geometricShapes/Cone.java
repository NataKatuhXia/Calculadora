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
 * Classe utilizada para realizar o cálculo da area do Cone ,e apresentar o seus
 * resultado na interface,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class Cone extends Figuras {

	private double raio;
	private double geratriz;
	private JTextField Traio;
	private JTextField Tgeratriz;
	private double altura;
	private JTextField Taltura;

	/**
	 * 
	 * @param raio
	 * @param geratriz
	 */
	public void setArea(double raio, double geratriz) {
		this.raio = Math.abs(raio);
		this.geratriz = Math.abs(geratriz);

		this.calcArea();
	}

	@Override
	protected void calcArea() {
		area = 3.14 * raio * (geratriz + raio);
	}

	/**
	 * Metodo responsavel por verificar se algum campo não foi preenchido.
	 * 
	 * @param opcao
	 * @param opcao2
	 * @param opcao3
	 * @return boolean
	 */
	protected boolean checkinformation(String opcao, String opcao2, String opcao3) {
		if (!opcao.isEmpty() && (!opcao2.isEmpty()) && (!opcao3.isEmpty())) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @param raio
	 * @param altura
	 */
	protected void setVolume(double raio, double altura) {
		this.raio = Math.abs(raio);
		this.altura = Math.abs(altura);
		calcVolume();
	}

	protected void calcVolume() {
		volume = (3.14 * Math.pow(raio, 2) * altura) / 3;

	}

	@Override
	public JPanel montaRequisitos() {
		painel2 = new JPanel();
		painel2.setLayout(null);
		painel2.setVisible(true);
		painel2.setBounds(0, 120, 994, 604);

		figura = "Cone";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((Traio.getText()), (Tgeratriz.getText()), (Taltura.getText()))) {
					try {
						setArea(Double.parseDouble(Traio.getText()), Double.parseDouble(Tgeratriz.getText()));
						setVolume(Double.parseDouble(Traio.getText()), Double.parseDouble(Taltura.getText()));
						dV = df.format(getVolume());
						dA = df.format(getArea());
						rArea.setText("Área:      " + dA + " cm²");
						rVolume.setText(" Volume: " + dV + " cm³");
						rArea.setBounds(550, 315, 190, 30);
						rVolume.setBounds(545, 335, 200, 30);
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

		JLabel Lraio = new JLabel("Raio:");
		Lraio.setFont(fonte);
		Lraio.setBounds(114, 45, 104, 24);
		Lraio.setVisible(true);
		painel2.add(Lraio);

		JLabel Lgeratriz = new JLabel("Geratriz:");
		Lgeratriz.setFont(fonte);
		Lgeratriz.setBounds(114, 175, 104, 24);
		Lgeratriz.setVisible(true);
		painel2.add(Lgeratriz);

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

		Tgeratriz = new JTextField();
		Tgeratriz.setFont(fonte);
		Tgeratriz.setBounds(213, 173, 145, 30);
		Tgeratriz.setVisible(true);
		painel2.add(Tgeratriz);

		Taltura = new JTextField();
		Taltura.setFont(fonte);
		Taltura.setBounds(213, 108, 145, 30);
		Taltura.setVisible(true);
		painel2.add(Taltura);

		image = new JLabel();
		image.setIcon(new ImageIcon(InterfaceGrafica.class.getResource("/figures/" + figura + ".jpg")));
		image.setBounds(460, 0, 320, 320);
		painel2.add(image);

		return painel2;
	}

	@Override
	protected void salvarDates() throws IOException {
		new SaveData(figura, dA, dV);

	}

}
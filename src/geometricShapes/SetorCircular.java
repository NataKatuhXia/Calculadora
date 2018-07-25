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
 * Classe utilizada para realizar o cálculo area do SetorCircular ,e apresentar
 * os seus resultados na interface,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class SetorCircular extends Figuras {
	private double angulocentral;
	private double raio;
	private JTextField Traio;
	private JTextField Tangulo;

	/**
	 * 
	 * @param angulocentral
	 * @param raio
	 */
	public void setArea(double angulocentral, double raio) {
		this.angulocentral = Math.abs(angulocentral);
		this.raio = Math.abs(raio);

		calcArea();
	}

	@Override
	protected void calcArea() {
		area = angulocentral * 3.14 * (Math.pow(raio, 2)) / 360;

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

		figura = "Setor Circular";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((Tangulo.getText()), (Traio.getText()))) {
					try {
						setArea(Double.parseDouble(Tangulo.getText()), Double.parseDouble(Traio.getText()));
						dA = df.format(getArea());
						rArea.setText("Área:      " + dA + " cm²");
						rArea.setBounds(550, 300, 250, 30);
						rArea.setFont(fonte);
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
		Lraio.setBounds(100, 45, 104, 24);
		Lraio.setVisible(true);
		painel2.add(Lraio);

		Traio = new JTextField();
		Traio.setFont(fonte);
		Traio.setBounds(213, 43, 145, 30);
		Traio.setVisible(true);
		painel2.add(Traio);

		JLabel Langulo = new JLabel("Angulo C. : ");
		Langulo.setFont(fonte);
		Langulo.setBounds(100, 110, 114, 24);
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
		new SaveData(figura, dA);

	}
}
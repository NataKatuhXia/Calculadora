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
 * Classe utilizada para realizar os cálculos de volume e area do Paralelepipedo
 * ,e apresentar os seus resultados na interface,e os salva em um arquivo txt.
 * @author R-CALC
 * @since 1.0	
 * @version 1.0	 
 */
public class Paralelepipedo extends Figuras {
	private double aresta1;
	private double aresta2;
	private double aresta3;
	private JTextField Taresta1;
	private JTextField Taresta2;
	private JTextField Taresta3;

	public void setVolume(double aresta1, double aresta2, double aresta3) {
		// Metodo para o calculo do volume do paralelepipedo, recebe como parametro o
		// comprimento das arestas
		this.aresta1 = aresta1;
		this.aresta2 = aresta2;
		this.aresta3 = aresta3;
		calcVolume();

	}

	public void setArea(double aresta1, double aresta2, double aresta3) {
		// Metodo para o calculo da area do paralelepipedo, recebe como parametro o
		// comprimento das arestas
		this.aresta1 = aresta1;
		this.aresta2 = aresta2;
		this.aresta3 = aresta3;
		calcArea();

	}

	@Override
	protected void calcArea() {
		// Calculo da Area
		area = (2 * aresta1 * aresta2) + (2 * aresta1 * aresta3) + (2 * aresta2 * aresta3);
	}

	private void calcVolume() {
		// Calculo do Volume
		volume = aresta1 * aresta2 * aresta3;
	}

	protected boolean checkinformation(String opcao, String opcao2, String opcao3) {
		if (!opcao.isEmpty() && (!opcao2.isEmpty()) && (!opcao3.isEmpty())) {
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

		figura = "Paralelepípedo";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((Taresta1.getText()), (Taresta2.getText()), (Taresta3.getText()))) {
					try {
						setVolume(Integer.parseInt(Taresta1.getText()), Integer.parseInt(Taresta2.getText()),
								Integer.parseInt(Taresta3.getText()));
						setArea(Integer.parseInt(Taresta1.getText()), Integer.parseInt(Taresta2.getText()),
								Integer.parseInt(Taresta3.getText()));
						dV = df.format(getVolume());
						dA = df.format(getArea());
						rArea.setText("Área:      " + dA+" cm²");
						rVolume.setText(" Volume: " + dV+" cm³");
						rArea.setBounds(550, 300,250, 30);
						rVolume.setBounds(545, 320,250, 30);
						rVolume.setFont(fonte);
						rArea.setFont(fonte);
						painel2.add(rVolume);
						painel2.add(rArea);
						painel2.repaint();
						salvarDates();

					} catch (NumberFormatException x) {
						JOptionPane.showMessageDialog(null, "Por favor, preencha corretamente todos os campos!",
								"Aviso!", JOptionPane.WARNING_MESSAGE);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, preencha corretamente todos os campos!", "Aviso!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		bCalcular.setFont(fonte);// O JButton recebendo a fonte
		bCalcular.setBounds(350, 307, 130, 40); // Informando a localizacao e o tamanho do JButton
		bCalcular.setVisible(true);// Informando que o JButton ficara visível
		painel2.add(bCalcular);

		JLabel Laresta1 = new JLabel("Aresta 'a':");
		Laresta1.setFont(fonte);
		Laresta1.setBounds(110, 45, 104, 24);
		Laresta1.setVisible(true);
		painel2.add(Laresta1);

		JLabel Laresta2 = new JLabel("Aresta 'b':");
		Laresta2.setFont(fonte);
		Laresta2.setBounds(110, 110, 104, 24);
		Laresta2.setVisible(true);
		painel2.add(Laresta2);

		JLabel Laresta3 = new JLabel("Aresta 'c':");
		Laresta3.setFont(fonte);
		Laresta3.setBounds(110, 175, 104, 24);
		Laresta3.setVisible(true);
		painel2.add(Laresta3);

		Taresta1 = new JTextField();
		Taresta1.setFont(fonte);
		Taresta1.setBounds(213, 43, 145, 30);
		Taresta1.setVisible(true);
		painel2.add(Taresta1);

		Taresta2 = new JTextField();
		Taresta2.setFont(fonte);
		Taresta2.setBounds(213, 108, 145, 30);
		Taresta2.setVisible(true);
		painel2.add(Taresta2);

		Taresta3 = new JTextField();
		Taresta3.setFont(fonte);
		Taresta3.setBounds(213, 173, 145, 30);
		Taresta3.setVisible(true);
		painel2.add(Taresta3);

		image = new JLabel();
		image.setIcon(new ImageIcon(InterfaceGrafica.class.getResource("/figures/" + figura + ".jpg")));
		image.setBounds(400, 0, 380, 280);
		painel2.add(image);

		return painel2;
	}

	@Override
	protected void salvarDates() throws IOException {
		new SaveData(figura, dA, dV);

	}

}
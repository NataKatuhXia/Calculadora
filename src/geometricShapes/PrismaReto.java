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
 * Classe utilizada para realizar os cálculos de volume e area do PrismaReto ,e
 * apresentar os seus resultados na interface,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class PrismaReto extends Figuras {
	private double altura;
	private double areaBase;
	private double perimetroBase;
	private JTextField Tabase;
	private JTextField Taltura;
	private JTextField Tpbase;

	@Override
	public void setVolume(double altura, double areaBase) {
		// Metodo para o calculo do volume do prisma reto, recebe como parametro altura
		// e area da base
		this.altura = altura;
		this.areaBase = areaBase;
		calcVolume();

	}

	@Override
	public void setArea(double altura, double perimetroBase, double areaBase) {
		// Metodo para o calculo da area do prisma reto, recebe como parametro altura,
		// perimetro da base e area da base
		this.altura = altura;
		this.areaBase = areaBase;
		this.perimetroBase = perimetroBase;
		calcArea();

	}

	@Override
	protected void calcArea() {
		// Calculo da Area
		area = (altura * perimetroBase) + (2 * areaBase); // Area lateral mais area da base x 2
	}

	@Override
	protected void calcVolume() {
		// Calculo do Volume
		volume = areaBase * altura;
	}

	@Override
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

		figura = "Prisma Reto";
		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((Taltura.getText()), (Tpbase.getText()), (Tabase.getText()))) {
					try {
						setArea(Double.parseDouble(Taltura.getText()), Double.parseDouble(Tpbase.getText()),
								Double.parseDouble(Tabase.getText()));
						setVolume(Double.parseDouble(Taltura.getText()), Double.parseDouble(Tabase.getText()));
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

		JLabel Lbase = new JLabel("A. Base:");
		Lbase.setFont(fonte);
		Lbase.setBounds(114, 45, 104, 24);
		Lbase.setVisible(true);
		painel2.add(Lbase);

		JLabel Laltura = new JLabel("Altura:");
		Laltura.setFont(fonte);
		Laltura.setBounds(114, 110, 104, 24);
		Laltura.setVisible(true);
		painel2.add(Laltura);

		JLabel LPbase = new JLabel("P. Base:");
		LPbase.setFont(fonte);
		LPbase.setBounds(114, 175, 104, 24);
		LPbase.setVisible(true);
		painel2.add(LPbase);

		Tabase = new JTextField();
		eventPut(Tabase);
		Tabase.setFont(fonte);
		Tabase.setBounds(213, 43, 145, 30);
		Tabase.setVisible(true);
		painel2.add(Tabase);

		Taltura = new JTextField();
		eventPut(Taltura);
		Taltura.setFont(fonte);
		Taltura.setBounds(213, 108, 145, 30);
		Taltura.setVisible(true);
		painel2.add(Taltura);

		Tpbase = new JTextField();
		eventPut(Tpbase);
		Tpbase.setFont(fonte);
		Tpbase.setBounds(213, 173, 145, 30);
		Tpbase.setVisible(true);
		painel2.add(Tpbase);

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
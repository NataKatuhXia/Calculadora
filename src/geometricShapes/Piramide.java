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
import interfaceG.InterfaceGrafica;

/**
 * Classe utilizada para realizar os cálculos de volume e area da Piramide ,e
 * apresentar os seus resultados na interface,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */

public class Piramide extends Figuras {
	private double altura;
	private double areaBase;
	private double numeroLados;
	private double areaLateral;
	private JTextField TareaBase;
	private JTextField TareaLateral;
	private JTextField Taltura;
	private JTextField TnumeroLados;

	@Override
	public void setArea(double areaLateral, double areaBase, double numeroLados) {
		this.areaBase = areaBase;
		this.numeroLados = numeroLados;
		this.areaLateral = areaLateral;

		this.calcArea();

	}

	@Override
	public void setVolume(double areaBase, double altura) {
		this.altura = altura;
		this.areaBase = areaBase;

		this.calcVolume();

	}

	protected void calcVolume() {
		// Calculo do Volume
		volume = (areaBase * altura) / 3;
	}

	@Override
	protected void calcArea() {
		// Calculo da Area
		area = (areaBase + (areaLateral * numeroLados));
	}

	@Override
	protected boolean checkinformation(String opcao, String opcao2, String opcao3, String opcao4) {
		if (!opcao.isEmpty() && (!opcao2.isEmpty()) && (!opcao3.isEmpty() && (!opcao4.isEmpty()))) {
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
		painel2.setBounds(0, 150, 994, 604);

		figura = "Pirâmide Reta";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((TareaBase.getText()), (TareaLateral.getText()), (TnumeroLados.getText()),
						(Taltura.getText()))) {
					try {
						setArea(Double.parseDouble(TareaLateral.getText()), Double.parseDouble(TareaBase.getText()),
								Double.parseDouble(TnumeroLados.getText()));
						setVolume(Double.parseDouble(TareaBase.getText()), Double.parseDouble(Taltura.getText()));
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

		JLabel LareaBase = new JLabel("A. Base:");
		LareaBase.setFont(fonte);
		LareaBase.setBounds(90, 40, 120, 24);
		LareaBase.setVisible(true);
		painel2.add(LareaBase);

		JLabel LareaLateral = new JLabel("A. Lateral:");
		LareaLateral.setFont(fonte);
		LareaLateral.setBounds(90, 105, 120, 24);
		LareaLateral.setVisible(true);
		painel2.add(LareaLateral);

		JLabel LnumeroLados = new JLabel("N° Lados:");
		LnumeroLados.setFont(fonte);
		LnumeroLados.setBounds(90, 170, 104, 24);
		LnumeroLados.setVisible(true);
		painel2.add(LnumeroLados);

		JLabel Laltura = new JLabel("Altura:");
		Laltura.setFont(fonte);
		Laltura.setBounds(90, 235, 104, 24);
		Laltura.setVisible(true);
		painel2.add(Laltura);

		TareaBase = new JTextField();
		eventPut(TareaBase);
		TareaBase.setFont(fonte);
		TareaBase.setBounds(213, 38, 145, 30);
		TareaBase.setVisible(true);
		painel2.add(TareaBase);

		TareaLateral = new JTextField();
		eventPut(TareaLateral);
		TareaLateral.setFont(fonte);
		TareaLateral.setBounds(213, 103, 145, 30);
		TareaLateral.setVisible(true);
		painel2.add(TareaLateral);

		Taltura = new JTextField();
		eventPut(Taltura);
		Taltura.setFont(fonte);
		Taltura.setBounds(213, 233, 145, 30);
		Taltura.setVisible(true);
		painel2.add(Taltura);

		TnumeroLados = new JTextField();
		eventPut(TnumeroLados);
		TnumeroLados.setFont(fonte);
		TnumeroLados.setBounds(213, 168, 145, 30);
		TnumeroLados.setVisible(true);
		painel2.add(TnumeroLados);

		image = new JLabel();
		image.setIcon(new ImageIcon(InterfaceGrafica.class.getResource("/figures/" + figura + ".jpg")));
		image.setBounds(460, 0, 320, 325);
		painel2.add(image);

		return painel2;
	}

	@Override
	protected void salvarDates() throws IOException {
		new SaveData(figura, dA, dV);

	}

}
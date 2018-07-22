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
 * Classe utilizada para realizar o cálculo de area do Retangulo ,e apresentar
 * os seus resultados na interface,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class Retangulo extends Figuras {

	private double base;
	private double altura;
	private JTextField Tbase;
	private JTextField Taltura;

	@Override
	public void setArea(double base, double altura) {
		// Metodo para receber os valores necessarios para realizar os calculos
		this.base = base;
		this.altura = altura;
		calcArea();

	}

	@Override
	protected void calcArea() {
		// Calculo da Area
		area = (base * altura);
	}

	@Override
	protected boolean checkinformation(String opcao, String opcao2) {
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

		figura = "Retângulo";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((Taltura.getText()), (Tbase.getText()))) {
					try {
						setArea(Double.parseDouble(Taltura.getText()), Double.parseDouble(Tbase.getText()));
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

		JLabel Lbase = new JLabel("Base:");
		Lbase.setFont(fonte);
		Lbase.setBounds(114, 45, 104, 24);
		Lbase.setVisible(true);
		painel2.add(Lbase);

		JLabel Laltura = new JLabel("Altura:");
		Laltura.setFont(fonte);
		Laltura.setBounds(114, 110, 104, 24);
		Laltura.setVisible(true);
		painel2.add(Laltura);

		Tbase = new JTextField();
		eventPut(Tbase);
		Tbase.setFont(fonte);
		Tbase.setBounds(213, 43, 145, 30);
		Tbase.setVisible(true);
		painel2.add(Tbase);

		Taltura = new JTextField();
		eventPut(Taltura);
		Taltura.setFont(fonte);
		Taltura.setBounds(213, 108, 145, 30);
		Taltura.setVisible(true);
		painel2.add(Taltura);

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
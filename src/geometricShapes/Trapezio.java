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
 * Classe utilizada para realizar o cálculo area do Trapezio ,e apresentar os
 * seus resultados na interface,e os salva em um arquivo txt.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class Trapezio extends Figuras {

	private double basemaior;
	private double basemenor;
	private double altura;
	private JTextField TbaseMaior;
	private JTextField Taltura;
	private JTextField TbaseMenor;

	/**
	 * 
	 * @param basemaior
	 * @param basemenor
	 * @param altura
	 */
	public void setArea(double basemaior, double basemenor, double altura) {
		this.basemaior = Math.abs(basemaior);
		this.basemenor = Math.abs(basemenor);
		this.altura = Math.abs(altura);

		calcArea();

	}

	@Override
	protected void calcArea() {
		area = (((basemaior + basemenor) * altura) / 2);
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

	@Override
	public JPanel montaRequisitos() {
		painel2 = new JPanel();
		painel2.setLayout(null);
		painel2.setVisible(true);
		painel2.setBounds(0, 157, 994, 604);

		figura = "Trapézio";

		bCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkinformation((TbaseMaior.getText()), (TbaseMenor.getText()), (Taltura.getText()))) {
					try {
						setArea(Double.parseDouble(TbaseMaior.getText()), Double.parseDouble(TbaseMenor.getText()),
								Double.parseDouble(Taltura.getText()));
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

		JLabel LbaseMaior = new JLabel("Base Maior:");
		LbaseMaior.setFont(fonte);
		LbaseMaior.setBounds(80, 45, 130, 24);
		LbaseMaior.setVisible(true);
		painel2.add(LbaseMaior);

		JLabel Laltura = new JLabel("Altura:");
		Laltura.setFont(fonte);
		Laltura.setBounds(80, 110, 104, 24);
		Laltura.setVisible(true);
		painel2.add(Laltura);

		JLabel LbaseMenor = new JLabel("Base Menor:");
		LbaseMenor.setFont(fonte);
		LbaseMenor.setBounds(80, 175, 130, 24);
		LbaseMenor.setVisible(true);
		painel2.add(LbaseMenor);

		TbaseMaior = new JTextField();
		TbaseMaior.setFont(fonte);
		TbaseMaior.setBounds(213, 43, 145, 30);
		TbaseMaior.setVisible(true);
		painel2.add(TbaseMaior);

		Taltura = new JTextField();
		Taltura.setFont(fonte);
		Taltura.setBounds(213, 108, 145, 30);
		Taltura.setVisible(true);
		painel2.add(Taltura);

		TbaseMenor = new JTextField();
		TbaseMenor.setBounds(213, 173, 145, 30);
		TbaseMenor.setFont(fonte);
		TbaseMenor.setVisible(true);
		painel2.add(TbaseMenor);

		image = new JLabel();
		image.setIcon(new ImageIcon(InterfaceGrafica.class.getResource("/figures/" + figura + ".jpg")));
		image.setBounds(410, 0, 370, 280);
		painel2.add(image);

		return painel2;
	}

	@Override
	protected void salvarDates() throws IOException {
		new SaveData(figura, dA);

	}

}
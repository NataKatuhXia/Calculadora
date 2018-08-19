package interfaceG;

import java.awt.Font;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import dados.GetProperties;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AboutFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.util.Properties prop = GetProperties.getProp();

	/**
	 * Create the frame.
	 */
	public AboutFrame() {
		setRootPaneCheckingEnabled(false);
		getMostRecentFocusOwner();
		getContentPane().setBackground(Color.WHITE);
		setFrameIcon(new ImageIcon(getClass().getResource(prop.getProperty("icons.JFrame"))));
		try {
			setIcon(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Sobre");
		setBounds(100, 100, 532, 402);
		getContentPane().setLayout(null);

		Font fonte = new Font("Times", Font.CENTER_BASELINE, 30);
		JLabel lblTitle1 = new JLabel("Calculadora Geom\u00E9trica");
		lblTitle1.setIcon(new ImageIcon(AboutFrame.class.getResource(prop.getProperty(("icons.Iabout")))));
		lblTitle1.setFont(fonte);
		lblTitle1.setBounds(59, 11, 391, 49);
		getContentPane().add(lblTitle1);

		JSeparator linhaSeparador = new JSeparator();
		linhaSeparador.setBounds(10, 72, 496, 2);
		getContentPane().add(linhaSeparador);

		fonte = new Font("Times", Font.PLAIN, 25);
		JLabel lblTitulo2 = new JLabel("R-Calc Calculadora");
		lblTitulo2.setFont(fonte);
		lblTitulo2.setBounds(101, 85, 234, 22);
		getContentPane().add(lblTitulo2);

		JLabel imageTela = new JLabel("");
		imageTela.setIcon(new ImageIcon(getClass().getResource(prop.getProperty("icons.JFrame"))));
		imageTela.setBounds(35, 103, 56, 54);
		getContentPane().add(imageTela);

		JLabel version = new JLabel("Vers�o: 1.0 (25/07/2018)");
		version.setBounds(111, 118, 125, 14);
		getContentPane().add(version);

		JTextPane textoApresentacao = new JTextPane();
		textoApresentacao.setEnabled(false);
		textoApresentacao.setEditable(false);
		textoApresentacao.setText(
				"A Calculadora Geom�trica foi criada com objetivo de conclus�o da disciplina de Programa��o Orientada a "
						+ "Objetos - MATA55 do curso de Licenciatura em Computa��o da Universidade Federal da Bahia - UFBA, sob "
						+ "orienta��o do Professor Frederico Dur�o e Monitoria de Paulo Roberto. \nEsse trabalho tem por finalidade a "
						+ "uni�o da teoria com a pr�tica realizada durante todo o curso, fazendo o uso da linguagem de programa��o Java. "
						+ "\nPara esta calculadora foram utilizadas 24 figuras geom�tricas, sendo poss�vel calcular �rea e volume e tamanho."
						+ " Este trabalho foi elaborado pela equipe R-CAL, composta pelos discentes Andr�, Cainan Lima, Luis Fernando Guerra, "
						+ "Matheus Barbosa e Rafael Bahia.");
		textoApresentacao.setBounds(101, 143, 361, 181);
		textoApresentacao.setBackground(Color.WHITE);
		getContentPane().add(textoApresentacao);

		JButton btnokay = new JButton("OK");
		btnokay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnokay.setBounds(417, 339, 89, 23);
		getContentPane().add(btnokay);

	}
}

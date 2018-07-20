package interfaceG;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;

/**
 * Classe responsavel por toda interface grafica do programa.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class InterfaceGrafica extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel painel1;
	private JFrame calcGeometrica;
	private JComboBox<ImageIcon> OpcaoFiguras;
	private JPanel painel2;
	private Properties prop = GetProperties.getProp();

	public InterfaceGrafica() {
		/*
		 * Metodo para Instanciar a JFrame E logo apos chama a Funçao para configurar a
		 * JFrame
		 */
		calcGeometrica = new JFrame("Calculadora Geometrica"); // Inicializando a JFrame
		calcGeometrica.setBackground(Color.LIGHT_GRAY);
		calcGeometrica.setDefaultCloseOperation(EXIT_ON_CLOSE); // Encerrar o processo quando fecha a JFrame
		inicializaComponente();

	}

	private void inicializaComponente() {
		/*
		 * Este metodo configura a JFrame de forma personalizada
		 */

		montaJanela();// Metodo para montar a primeira parte do Panel
		calcGeometrica.setSize(800, 600); // Informando o tamanho da janela
		calcGeometrica.getContentPane().setLayout(null); // Permitindo que a janela seja livre para ser modificado

		calcGeometrica.setVisible(true); // Permitindo que a Janela fique visível na tela
		calcGeometrica.setResizable(false); // Nega a maximizacao da Janela
		calcGeometrica.setLocationRelativeTo(null); // Faz a Janela ser carregada no centro da Tela

	}

	private void montaJanela() {

		/*
		 * Metodo para montar a JFrame A JFrame vai conter 3 Jpanel
		 */
		painel2 = new JPanel();
		painel2.setLayout(null);
		painel2.setVisible(true);
		painel2.setBounds(0, 157, 994, 604);

		painel1 = new JPanel(); // Instanciando o Primeiro JPanel
		painel1.setBackground(Color.WHITE);
		painel1.setLayout(null); // Permitindo que o Painel seja livre para ser modificado
		painel1.setBounds(0, 0, 994, 157); // Informando a localização e o tamanho que ele sera iniciado na tela

		calcGeometrica.setContentPane(montaPainel1());// Adiciona o JPanel_1 a Janela

		calcGeometrica.setJMenuBar(montaMenuBar()); // Adciona o JMenuBar na Janela

	}

	private JPanel montaPainel1() {
		/*
		 * Metodo para montar o JPanel_1 JPanel vai conter o JLabel "Figura" e o
		 * JComboBox Localizada na parte Superior da JFrame
		 */
		painel1.add(montaComboBox()); // Recebe os atributos que vao ser adicionados a ele

		Font fonte = new Font("Arial", Font.CENTER_BASELINE, 20); // Personalizado uma fonte para o JLabel
		JLabel LFigura = new JLabel("Figura:"); // Adicionando a JLabel para acompanhar o JComboBox
		LFigura.setFont(fonte); // A JLabel recebendo a fonte
		LFigura.setBounds(44, 40, 80, 30); // Informando a localizacao e o tamanho da JLabel
		LFigura.setVisible(true); // Informando que a JLabel ficara visível
		painel1.add(LFigura); // Adicionando a JLabel ao JPanel

		fonte = new Font("Arial", Font.CENTER_BASELINE, 14); // Personalizado uma fonte para o JButton
		JButton bSelecionar = new JButton("Selecionar");// Adicionando o JButton para acompanhar o JComboBox
		bSelecionar.addActionListener(new ActionListener() { // Criando a ação do JButton
			public void actionPerformed(ActionEvent e) {
				if (OpcaoFiguras.getSelectedIndex() > 0) { // Condicional para o usuario escolher uma figura
					montaPainel2(OpcaoFiguras.getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "Escolha uma Figura !", "Aviso!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		bSelecionar.setFont(fonte);// O JButton recebendo a fonte
		bSelecionar.setBounds(634, 42, 120, 30); // Informando a localizacao e o tamanho do JButton
		bSelecionar.setVisible(true);// Informando que o JButton ficara visível
		painel1.add(bSelecionar);// Adicionando o JButton ao JPanel

		return painel1; // Retorna o JPanel personalizado
	}

	private JComboBox<ImageIcon> montaComboBox() {
		/*
		 * Metodo para montar o ComboBox] Metodo vai retornar o ComboBox pronto para ser
		 * adicionado ao JPanel;
		 */

		OpcaoFiguras = new JComboBox<ImageIcon>(); // Instanciando o JComboBox

		OpcaoFiguras.setForeground(Color.WHITE);
		OpcaoFiguras.setBackground(Color.WHITE);

		OpcaoFiguras.setBounds(129, 42, 495, 30);// Informando a localizacao e o tamanho do JComboBox

		/*
		 * Nas linhas a seguir estão sendo adicionados itens ao JComboBox O JComboBox é
		 * um tipo de ArrayList
		 * 
		 * A adicao é feita por meio de uma leitura de um arquivo properties
		 */

		/*
		 * Leitura do arquivo txt com a lista de Figuras
		 */
		for (Integer i = 0; i < 24; i++) {
			OpcaoFiguras.addItem(new ImageIcon(InterfaceGrafica.class.getResource(prop.getProperty(i.toString()))));
		}

		return OpcaoFiguras; // Retorna o JComboBox personalizado
	}

	private void montaPainel2(int opcao) {

		painel2.setVisible(false); // Desativo o JPanel para poder substituir os itens sem que o usuário perceba
		painel2.removeAll(); // Retiro todos os campos adicionados anteriormente

		/*
		 * 
		 * Método para criar o segundo JPanel Recebendo como paremetro a Opcao que o
		 * usuario escolheu
		 *
		 */
		painel2 = new Formulario().montaPainel(opcao);
		painel2.setVisible(true);
		painel2.setBackground(Color.WHITE);

		calcGeometrica.getContentPane().add(painel2); // Adiciona o JPanel_2 a Janela

		painel2.repaint(); // Atualiza a JFrame para carregar o novo Formulario

	}

	private JMenuBar montaMenuBar() {
		// Objeto que desenha a barra de Menu
		JMenuBar barra = new JMenuBar();
		// Cria o menu Arquivo que ficará na barra de Menu
		JMenuItem menuArquivo = new JMenu("Arquivo");
		// Adiciona um ícone ao MenuArquivo
		menuArquivo.setIcon(new ImageIcon(InterfaceGrafica.class.getResource(prop.getProperty("icons.arquivo"))));
		// Cria um submenu Historico
		JMenuItem itemMenuHistorico = new JMenuItem("Histórico");
		// Adiciona um ícone ao SubMenuHistorico
		itemMenuHistorico
				.setIcon(new ImageIcon(InterfaceGrafica.class.getResource(prop.getProperty("icons.historico"))));
		// Adiciona a ação do MenuSair
		itemMenuHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new History();
			}
		});

		// Cria um submenu Sair
		JMenuItem itemMenuSair = new JMenuItem("Sair");
		// Adiciona um ícone ao SubMenuSair
		itemMenuSair.setIcon(new ImageIcon(InterfaceGrafica.class.getResource(prop.getProperty("icons.sair"))));
		// Adiciona a ação do MenuSair
		itemMenuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		calcGeometrica.setIconImage(new ImageIcon(getClass().getResource(prop.getProperty("icons.JFrame"))).getImage());

		// Adiciona o Submenu no Menu Arquivo
		menuArquivo.add(itemMenuHistorico);
		// Adciona um Separador de itens no menu Arquivo
		((JMenu) menuArquivo).addSeparator();
		// Adiciona o Submenu no Menu Arquivo
		menuArquivo.add(itemMenuSair);
		// Adiciona o menu Arquivo na barra de Menu
		barra.add(menuArquivo);

		return barra;
	}
}

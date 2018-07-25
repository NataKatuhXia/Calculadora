package interfaceG;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

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

import dados.GetProperties;

import java.awt.Color;
import javax.swing.JDesktopPane;

/**
 * Classe responsavel por toda interface grafica do programa.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class InterfaceGrafica extends GetProperties {

	private JPanel painel1;
	private JFrame calcGeometrica;
	private JComboBox<ImageIcon> OpcaoFiguras;
	private JPanel painel2;

	/**
	 * Metodo para Instanciar a JFrame E logo apos chama a Fun�ao para configurar a
	 * JFrame
	 */
	public InterfaceGrafica() {

		// Inicializando a JFrame
		calcGeometrica = new JFrame("Calculadora Geometrica");

		// Encerrar o processo quando fecha a JFrame
		calcGeometrica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// M�todo para preparar a JFrame
		inicializaComponente();

	}

	/**
	 * Este metodo configura a JFrame de forma personalizada
	 */
	private void inicializaComponente() {

		// Metodo para montar a primeira parte do Panel
		montaJanela();

		// Definindo a Cor de fundo da JFrame
		calcGeometrica.setBackground(Color.LIGHT_GRAY);

		// Informando o tamanho da janela
		calcGeometrica.setSize(800, 600);

		// Permitindo que a janela seja livre para ser modificado
		calcGeometrica.getContentPane().setLayout(null);

		JDesktopPane TelaSobre = new JDesktopPane();
		TelaSobre.setBounds(10, 542, 774, -530);
		painel1.add(TelaSobre);

		// Permitindo que a Janela fique vis�vel na tela
		calcGeometrica.setVisible(true);

		// Nega a maximizacao da Janela
		calcGeometrica.setResizable(false);

		// Faz a Janela ser carregada no centro da Tela
		calcGeometrica.setLocationRelativeTo(null);

		// Defininco o �cone para a JFrame
		calcGeometrica.setIconImage(new ImageIcon(getClass().getResource(prop.getProperty("icons.JFrame"))).getImage());

	}

	/**
	 * Metodo para montar a JFrame A JFrame vai conter 3 Jpanel
	 */
	private void montaJanela() {

		painel2 = new JPanel();
		painel2.setLayout(null);
		painel2.setVisible(true);
		painel2.setBounds(0, 157, 994, 604);

		// Instanciando o Primeiro JPanel
		painel1 = new JPanel();

		// Permitindo que o Painel seja livre para ser modificado
		painel1.setBackground(Color.WHITE);

		// Definindo com null um Layout pr� definido
		painel1.setLayout(null);

		// Informando a localiza��o e o tamanho que ele sera iniciado na tela
		painel1.setBounds(0, 0, 994, 157);

		// Adiciona o JPanel_1 a Janela
		calcGeometrica.setContentPane(montaPainel1());

		// Adciona o JMenuBar na Janela
		calcGeometrica.setJMenuBar(montaMenuBar());

	}

	/**
	 * Metodo para montar o JPanel1
	 * 
	 * @return JPanel
	 */
	private JPanel montaPainel1() {

		// Recebe os atributos que vao ser adicionados a ele
		painel1.add(montaComboBox());

		// Personalizado uma fonte para o JLabel
		Font fonte = new Font("Arial", Font.CENTER_BASELINE, 20);

		// Instanciando a JLabel para acompanhar o JComboBox
		JLabel LFigura = new JLabel("Figura:");

		// A JLabel recebendo a fonte
		LFigura.setFont(fonte);

		// Informando a localizacao e o tamanho da JLabel
		LFigura.setBounds(44, 40, 80, 30);

		// Informando que a JLabel ficara vis�vel
		LFigura.setVisible(true);

		// Adicionando a JLabel ao JPanel
		painel1.add(LFigura);

		// Alterando a fonte
		fonte = new Font("Arial", Font.CENTER_BASELINE, 14);

		// Personalizado uma fonte para o JButton
		JButton bSelecionar = new JButton("Selecionar");// Adicionando o JButton para acompanhar o JComboBox

		// Criando a a��o do JButton
		bSelecionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Verificar qual a Figura foi selecionada e montar os Requisitos
				if (OpcaoFiguras.getSelectedIndex() > 0) { // Condicional para o usuario escolher uma figura
					montaPainel2(OpcaoFiguras.getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "Escolha uma Figura !", "Aviso!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		// O JButton recebendo a fonte
		bSelecionar.setFont(fonte);

		// Informando a localizacao e o tamanho do JButton
		bSelecionar.setBounds(634, 42, 120, 30);

		// Informando que o JButton ficara vis�vel
		bSelecionar.setVisible(true);

		// Adicionando o JButton ao JPanel
		painel1.add(bSelecionar);

		// Retorna o JPanel personalizado
		return painel1;
	}

	/**
	 * Metodo para montar o ComboBox] Metodo vai retornar o ComboBox pronto para ser
	 * adicionado ao JPanel;
	 * 
	 * @return JComboBox
	 */
	private JComboBox<ImageIcon> montaComboBox() {

		// Instanciando o JComboBox
		OpcaoFiguras = new JComboBox<ImageIcon>();

		// Definindo as Cores de fundo e sele��o do JComboBox
		OpcaoFiguras.setForeground(Color.WHITE);
		OpcaoFiguras.setBackground(Color.WHITE);

		// Informando a localizacao e o tamanho do JComboBox
		OpcaoFiguras.setBounds(129, 42, 495, 30);

		/*
		 * Nas linhas a seguir est�o sendo adicionados itens ao JComboBox O JComboBox �
		 * um tipo de ArrayList
		 * 
		 * A adicao � feita por meio de uma leitura de um arquivo properties
		 */

		/*
		 * Leitura do arquivo txt com a lista de Figuras
		 */
		for (Integer i = 0; i < 24; i++) {
			OpcaoFiguras.addItem(new ImageIcon(InterfaceGrafica.class.getResource(prop.getProperty(i.toString()))));
		}

		// Retorna o JComboBox personalizado
		return OpcaoFiguras;
	}

	/**
	 * Metodo para montar o JPanel2
	 * 
	 * @param opcao
	 */
	private void montaPainel2(int opcao) {

		// Desativo o JPanel para poder substituir os itens sem que o usu�rio perceba
		painel2.setVisible(false);

		// Retiro todos os campos adicionados anteriormente
		painel2.removeAll();

		/*
		 * 
		 * M�todo para criar o segundo JPanel Recebendo como paremetro a Opcao que o
		 * usuario escolheu
		 *
		 */
		painel2 = new Formulario().montaPainel(opcao);

		// Permitindo que o JPanel volte a aparecer na Frame
		painel2.setVisible(true);

		// Alterando a cor de Fundo da JPanel, caso tenha desconfigurado
		painel2.setBackground(Color.WHITE);

		// Adiciona o JPanel_2 a Janela
		calcGeometrica.getContentPane().add(painel2);

		// Atualiza a JFrame para carregar o novo Formulario
		painel2.repaint();

	}

	/**
	 * 
	 * @return JMenuBar
	 */
	private JMenuBar montaMenuBar() {
		// Objeto que desenha a barra de Menu
		JMenuBar barra = new JMenuBar();

		// Cria o menu Arquivo que ficar� na barra de Menu
		JMenu menuArquivo = new JMenu("Arquivo");

		// Cria o menu Arquivo que ficar� na barra de Menu
		JMenu menuSobre = new JMenu("Sobre");

		// Adiciona um �cone ao MenuArquivo
		menuArquivo.setIcon(new ImageIcon(InterfaceGrafica.class.getResource(prop.getProperty("icons.arquivo"))));

		// Adiciona um �cone ao MenuSobre
		menuSobre.setIcon(new ImageIcon(InterfaceGrafica.class.getResource(prop.getProperty("icons.about"))));

		// Cria um submenu Sobre
		JMenuItem itemMenuSobre = new JMenuItem("Sobre a R-Calc");

		// Adiciona um �cone ao SubMenuSobre
		itemMenuSobre.setIcon(new ImageIcon(InterfaceGrafica.class.getResource(prop.getProperty("icons.inform"))));

		itemMenuSobre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Abrir a Janela de Hist�rico
				AboutFrame telaAbout = new AboutFrame();
				telaAbout.moveToFront();
				painel1.add(telaAbout);
				telaAbout.setVisible(true);

			}
		});

		// Cria um submenu Historico
		JMenuItem itemMenuHistorico = new JMenuItem("Hist�rico");

		// Adiciona um �cone ao SubMenuHistorico
		itemMenuHistorico
				.setIcon(new ImageIcon(InterfaceGrafica.class.getResource(prop.getProperty("icons.historico"))));

		// Adiciona a a��o do MenuHistorico
		itemMenuHistorico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Abrir a Janela de Hist�rico
				new History();
			}
		});

		// Cria um submenu Sair
		JMenuItem itemMenuSair = new JMenuItem("Sair");

		// Adiciona um �cone ao SubMenuSair
		itemMenuSair.setIcon(new ImageIcon(InterfaceGrafica.class.getResource(prop.getProperty("icons.sair"))));

		// Adiciona a a��o do MenuSair
		itemMenuSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// M�tdo para definir as a��es que ocorrer� quando o Usu�rio sair do Progrma
				try {
					/*
					 * Retornar o caminho para Salvar o arquivo ao Destino Padr�o
					 */
					FileOutputStream out = new FileOutputStream("./src/properties/listComandos.properties");
					prop.remove("CustomSave");
					prop.store(out, "");

					// Limpando o hist�rico, caso o usu�rio n�o tenha salvado
					FileWriter arq = new FileWriter(prop.getProperty("saveData"));
					arq.close();

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});

		// Adiciona o Submenu no Menu Arquivo
		menuArquivo.add(itemMenuHistorico);

		// Adciona um Separador de itens no menu Arquivo
		((JMenu) menuArquivo).addSeparator();

		// Adiciona o Submenu no Menu Arquivo
		menuArquivo.add(itemMenuSair);

		// Adiciona o Submenu no Menu Sobre
		menuSobre.add(itemMenuSobre);

		// Adiciona o menu Arquivo na barra de Menu
		barra.add(menuArquivo);

		// Adiciona o menu Sobre na barra de Menu
		barra.add(menuSobre);

		// Retorna a JMenuBar definida
		return barra;
	}
}

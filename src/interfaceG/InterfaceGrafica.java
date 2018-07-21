package interfaceG;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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

		// Inicializando a JFrame
		calcGeometrica = new JFrame("Calculadora Geometrica");

		// Encerrar o processo quando fecha a JFrame
		calcGeometrica.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Método para preparar a JFrame
		inicializaComponente();

	}

	private void inicializaComponente() {
		/*
		 * Este metodo configura a JFrame de forma personalizada
		 */

		// Metodo para montar a primeira parte do Panel
		montaJanela();

		// Definindo a Cor de fundo da JFrame
		calcGeometrica.setBackground(Color.LIGHT_GRAY);

		// Informando o tamanho da janela
		calcGeometrica.setSize(800, 600);

		// Permitindo que a janela seja livre para ser modificado
		calcGeometrica.getContentPane().setLayout(null);

		// Permitindo que a Janela fique visível na tela
		calcGeometrica.setVisible(true);

		// Nega a maximizacao da Janela
		calcGeometrica.setResizable(false);

		// Faz a Janela ser carregada no centro da Tela
		calcGeometrica.setLocationRelativeTo(null);

		// Defininco o ícone para a JFrame
		calcGeometrica.setIconImage(new ImageIcon(getClass().getResource(prop.getProperty("icons.JFrame"))).getImage());

	}

	private void montaJanela() {

		/*
		 * Metodo para montar a JFrame A JFrame vai conter 3 Jpanel
		 */
		painel2 = new JPanel();
		painel2.setLayout(null);
		painel2.setVisible(true);
		painel2.setBounds(0, 157, 994, 604);

		// Instanciando o Primeiro JPanel
		painel1 = new JPanel();

		// Permitindo que o Painel seja livre para ser modificado
		painel1.setBackground(Color.WHITE);

		// Definindo com null um Layout pré definido
		painel1.setLayout(null);

		// Informando a localização e o tamanho que ele sera iniciado na tela
		painel1.setBounds(0, 0, 994, 157);

		// Adiciona o JPanel_1 a Janela
		calcGeometrica.setContentPane(montaPainel1());

		// Adciona o JMenuBar na Janela
		calcGeometrica.setJMenuBar(montaMenuBar());

	}

	private JPanel montaPainel1() {
		/*
		 * Metodo para montar o JPanel_1 JPanel vai conter o JLabel "Figura" e o
		 * JComboBox Localizada na parte Superior da JFrame
		 */

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

		// Informando que a JLabel ficara visível
		LFigura.setVisible(true);

		// Adicionando a JLabel ao JPanel
		painel1.add(LFigura);

		// Alterando a fonte
		fonte = new Font("Arial", Font.CENTER_BASELINE, 14);

		// Personalizado uma fonte para o JButton
		JButton bSelecionar = new JButton("Selecionar");// Adicionando o JButton para acompanhar o JComboBox

		// Criando a ação do JButton
		bSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		// Informando que o JButton ficara visível
		bSelecionar.setVisible(true);

		// Adicionando o JButton ao JPanel
		painel1.add(bSelecionar);

		// Retorna o JPanel personalizado
		return painel1;
	}

	private JComboBox<ImageIcon> montaComboBox() {
		/*
		 * Metodo para montar o ComboBox] Metodo vai retornar o ComboBox pronto para ser
		 * adicionado ao JPanel;
		 */

		// Instanciando o JComboBox
		OpcaoFiguras = new JComboBox<ImageIcon>();

		// Definindo as Cores de fundo e seleção do JComboBox
		OpcaoFiguras.setForeground(Color.WHITE);
		OpcaoFiguras.setBackground(Color.WHITE);

		// Informando a localizacao e o tamanho do JComboBox
		OpcaoFiguras.setBounds(129, 42, 495, 30);

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

		// Retorna o JComboBox personalizado
		return OpcaoFiguras;
	}

	private void montaPainel2(int opcao) {

		// Desativo o JPanel para poder substituir os itens sem que o usuário perceba
		painel2.setVisible(false);

		// Retiro todos os campos adicionados anteriormente
		painel2.removeAll();

		/*
		 * 
		 * Método para criar o segundo JPanel Recebendo como paremetro a Opcao que o
		 * usuario escolheu
		 *
		 */
		painel2 = new Formulario().montaPainel(opcao);
		painel2.setVisible(true);
		painel2.setBackground(Color.WHITE);

		// Adiciona o JPanel_2 a Janela
		calcGeometrica.getContentPane().add(painel2);

		// Atualiza a JFrame para carregar o novo Formulario
		painel2.repaint();

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

		// Adiciona a ação do MenuHistorico
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
				try {
					/*
					 * Retornar o caminho para Salvar o arquivo ao Destino Padrão
					 */
					FileOutputStream out = new FileOutputStream("./src/properties/listComandos.properties");
					prop.remove("CustomSave");
					prop.store(out, "");

					// Limpando o histórico, caso o usuário não tenha salvado
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

		// Adiciona o menu Arquivo na barra de Menu
		barra.add(menuArquivo);

		// Retorna a JMenuBar definida
		return barra;
	}
}

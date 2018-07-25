package interfaceG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dados.Directory;
import dados.GetProperties;
import dados.SaveData;

public class History extends GetProperties {

	private DefaultTableModel modelo = new DefaultTableModel();
	private ArrayList<String[]> lista = new ArrayList<>();
	private JFrame frameHist = new JFrame("Histórico");

	public History() {
		criaJanela();
	}

	private void criaJanela() {

		frameHist.setJMenuBar((montaBarra()));

		frameHist.setAlwaysOnTop(true);

		frameHist.setIconImage(new ImageIcon(getClass().getResource(prop.getProperty("icons.JFrame"))).getImage());

		JPanel painelBotoes = new JPanel();

		frameHist.setLayout(new BorderLayout());

		JButton btSair = new JButton("Sair");
		btSair.setVisible(true);
		btSair.setBounds(285, 300, 90, 23);
		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Ocultar a JFrame do Histórico
				frameHist.dispose();
			}
		});

		JButton btLimpar = new JButton("Limpar Histórico");
		btLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Limpar os dados do Histórico
				new SaveData().deleteDates();
				lista.clear();
				frameHist.dispose();
			}
		});
		btLimpar.setBounds(90, 300, 130, 23);

		JScrollPane barraRolagem = new JScrollPane(criarTable());

		painelBotoes.add(btSair);
		painelBotoes.add(btLimpar);

		painelBotoes.setEnabled(false);

		frameHist.add(BorderLayout.CENTER, barraRolagem);
		frameHist.add(BorderLayout.SOUTH, painelBotoes);

		frameHist.setBounds(400, 300, 500, 300); // Informando o tamanho da janela
		frameHist.setResizable(false);
		frameHist.setVisible(true);

	}

	private JMenuBar montaBarra() {
		JMenuBar barra = new JMenuBar();

		// Cria o menu Arquivo que ficará na barra de Menu
		JMenuItem menuArquivo = new JMenu("Arquivo");

		// Cria um submenu Salvar Como
		JMenuItem itemMenuSavarAs = new JMenuItem("Salvar como...");

		// Criando a função do JMenuItem SalvarAs
		itemMenuSavarAs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Abrir o JFileChooser para o usuário decidir o local para salvar
				new Directory().saveDirectory();

			}
		});

		// Cria um submenu Abrir
		JMenuItem itemMenuOpen = new JMenuItem("Abrir");

		// Criando a função do JMenuItem Abrir
		itemMenuOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Abrir um histórico já utilizada do Usuário
				if (new Directory().openDirectory() != 1) {
					frameHist.dispose();
				}

			}
		});

		// Adcionar um icone ao Menu Salvar
		JMenuItem itemMenuSavar = new JMenuItem("Salvar");

		// Criando a função do JMenuItem Salvar
		itemMenuSavar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * Verificando se o usuário já definiu o local do arquivo
				 * 
				 * Se não, o Sistema apresenta o JFileChooser para ele selecionar;
				 * 
				 * Se sim, como o sistema tem salvamento automático ele não irá apresentar
				 * nenhuma informação inédita.
				 */
				if (prop.getProperty("CustomSave") == null) {
					new Directory().saveDirectory();
				}
			}
		});

		// Defino os ícones de todos os elementos do JMenuBar
		menuArquivo.setIcon(new ImageIcon(History.class.getResource(prop.getProperty("icons.arquivo"))));
		itemMenuSavarAs.setIcon(new ImageIcon(History.class.getResource(prop.getProperty("icons.saveAs"))));
		itemMenuSavar.setIcon(new ImageIcon(History.class.getResource(prop.getProperty("icons.save"))));
		itemMenuOpen.setIcon(new ImageIcon(History.class.getResource(prop.getProperty("icons.open"))));

		// Adiciona o Submenu "Abrir" no Menu Arquivo
		menuArquivo.add(itemMenuOpen);

		// Adiciono um Separador entre os JMenusItens
		((JMenu) menuArquivo).addSeparator();

		// Adiciona o Submenu "Salvar" no Menu Arquivo
		menuArquivo.add(itemMenuSavar);

		// Adiciono um Separador entre os JMenusItens
		((JMenu) menuArquivo).addSeparator();

		// Adciono o Submenu "Salvar Como" no Menu Arquivo
		menuArquivo.add(itemMenuSavarAs);
		// Adiciona o menu Arquivo na barra de Menu
		barra.add(menuArquivo);

		return barra;

	}

	private JScrollPane criarTable() {

		JTable tabela = new JTable(modelo);
		Font fonte = new Font("Georgia", Font.CENTER_BASELINE, 16);

		DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer(); // Para receber o alinhamento da JTable

		/*
		 * Linhas seguintes responsáveis pelo alinhamento da JTabe Pela adição das
		 * respectivas colunas na Table
		 */
		JTableHeader header = tabela.getTableHeader();
		DefaultTableCellRenderer centralizado = (DefaultTableCellRenderer) header.getDefaultRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(fonte);
		header.setBackground(Color.GRAY);
		cellRender.setHorizontalAlignment(SwingConstants.CENTER); // Defino o alinhamento

		modelo.addColumn("Figura"); // Crio uma coluna na JTable
		modelo.addColumn("Área"); // Crio uma coluna na JTable
		modelo.addColumn("Volume"); // Crio uma coluna na JTable

		tabela.getColumnModel().getColumn(0).setCellRenderer(cellRender); // Insiro o alinhamento na coluna
		tabela.getColumnModel().getColumn(1).setCellRenderer(cellRender); // Insiro o alinhamento na coluna
		tabela.getColumnModel().getColumn(2).setCellRenderer(cellRender); // Insiro o alinhamento na coluna
		adicionarDates(modelo);

		tabela.setEnabled(false); // Desativo a opção de edição da JTable
		tabela.setCellSelectionEnabled(true);
		JScrollPane barraRolagem = new JScrollPane(tabela); // Adiciono a JTable na JScrollPane

		return barraRolagem;
	}

	private void adicionarDates(DefaultTableModel modelo) {
		modelo.setNumRows(0);

		FileReader arq = null;
		BufferedReader leitor = null;
		String linha;

		try {
			if (prop.getProperty("CustomSave") == null) {
				arq = new FileReader(prop.getProperty("saveData"));
			} else {
				arq = new FileReader(prop.getProperty("CustomSave"));
			}
			leitor = new BufferedReader(arq);

			while ((linha = leitor.readLine()) != null) {
				String[] array = new String[3];
				array = linha.split(" / ");
				lista.add(array);

			}
			arq.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String[] aux : lista) {
			modelo.addRow(aux);
		}

	}

}

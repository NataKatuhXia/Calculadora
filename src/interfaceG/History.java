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

import dados.SaveData;

public class History extends GetProperties {

	private DefaultTableModel modelo = new DefaultTableModel();
	private ArrayList<String[]> lista = new ArrayList<>();

	public History() {
		criaJanela();
	}

	private void criaJanela() {

		JFrame frameHist = new JFrame("Histórico");

		frameHist.setJMenuBar((montaBarra()));

		JPanel painelBotoes = new JPanel();

		frameHist.setLayout(new BorderLayout());

		JButton btSair = new JButton("Sair");
		btSair.setVisible(true);
		btSair.setBounds(285, 300, 90, 23);
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameHist.dispose();
			}
		});

		JButton btLimpar = new JButton("Limpar Histórico");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		JMenuItem menuOpcoes = new JMenu("Opções");

		// Cria um submenu Historico
		JMenuItem itemMenuSavarAs = new JMenuItem("Salvar como...");
		itemMenuSavarAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Directory();
			}
		});

		// Adcionar um icone ao Menu Salvar
		// JMenuItem itemMenuSave = new JMenuItem("Salvar");
		menuOpcoes.setIcon(
				new ImageIcon(History.class.getResource(GetProperties.getProp().getProperty("icons.options"))));
		itemMenuSavarAs
				.setIcon(new ImageIcon(History.class.getResource(GetProperties.getProp().getProperty("icons.save"))));
		// Adiciona o Submenu no Menu Arquivo
		menuOpcoes.add(itemMenuSavarAs);
		// Adciona um Separador de itens no menu Arquivo
		((JMenu) menuOpcoes).addSeparator();
		// Adiciona o menu Arquivo na barra de Menu
		barra.add(menuOpcoes);

		return barra;

	}

	private JScrollPane criarTable() {

		JTable tabela = new JTable(modelo);
		DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer(); // Para receber o alinhamento da JTable

		Font fonte = new Font("Georgia", Font.CENTER_BASELINE, 16);
		JTableHeader cabecalho = tabela.getTableHeader();
		cabecalho.setFont(fonte);
		cabecalho.setBackground(Color.LIGHT_GRAY);
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
			arq = new FileReader(GetProperties.getProp().getProperty("saveData"));
			leitor = new BufferedReader(arq);

			while ((linha = leitor.readLine()) != null) {
				String[] array = new String[3];
				array = linha.split(";");
				lista.add(array);

			}

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

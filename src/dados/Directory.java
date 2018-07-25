package dados;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import dados.SaveData;

/**
 * 
 * @author R-CALC
 *
 */
public class Directory extends GetProperties {

	public void saveDirectory() {
		JFileChooser file;

		if (prop.getProperty("CustomSave") == null) {
			file = new JFileChooser("C:\\Users");
		} else {
			file = new JFileChooser("CustomSave");
		}

		file.setDialogTitle("Salvar como");
		file.setMultiSelectionEnabled(false);

		file.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "Documentos de texto (*.txt)";
			}

			@Override
			public boolean accept(File f) {
				return (f.getName().endsWith(".txt")) || f.isDirectory();
			}
		});

		// Bloquear a opção todos os Arquivos, ao salvar o programa
		file.setAcceptAllFileFilterUsed(false); 
		file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int i = file.showSaveDialog(null);
		if (i != 1) {
			/*
			 * Salvar o arquivo com extensão .txt automaticamente
			 */
			File arquivo = file.getSelectedFile();
			if (!arquivo.getAbsolutePath().endsWith(".txt")) {
				arquivo = new File(arquivo.getAbsolutePath() + ".txt");
			}
			new SaveData().SaveDates(arquivo.getPath());
		}
	}

	/**
	 * 
	 * @return JFileChooser
	 */
	public int openDirectory() {

		JFileChooser file;

		if (prop.getProperty("CustomSave") == null) {
			file = new JFileChooser("C:\\Users");
		} else {
			file = new JFileChooser("CustomSave");
		}

		file.setDialogTitle("Salvar como");
		file.setMultiSelectionEnabled(false);

		file.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "Documentos de texto (*.txt)";
			}

			@Override
			public boolean accept(File f) {
				return (f.getName().endsWith(".txt")) || f.isDirectory();
			}
		});

		file.setAcceptAllFileFilterUsed(false); // Bloquear a opção todos os Arquivos, ao salvar o programa
		file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int i = file.showOpenDialog(null);
		if (i != 1) {
			try {
				File arquivo = file.getSelectedFile();
				prop.setProperty("CustomSave", arquivo.getPath());
				FileOutputStream out = new FileOutputStream("./src/properties/listComandos.properties");
				prop.store(out, "\n");
				out.close();

			} catch (IOException e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}

		return i;

	}
}

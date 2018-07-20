package interfaceG;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import dados.SaveData;

public class Directory {

	public Directory() {
		JFileChooser file = new JFileChooser();
		file.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Documentos de texto (*.txt)";
			}

			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return (f.getName().endsWith(".txt")) || f.isDirectory();
			}
		});

		file.setAcceptAllFileFilterUsed(false);
		file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int i = file.showSaveDialog(null);
		if (i == 1) {
			System.out.println("Nada");
		} else {
			File arquivo = file.getSelectedFile();
			new SaveData().SaveDates(arquivo.getPath());
		}

	}

}

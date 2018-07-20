package dados;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import static java.nio.file.StandardCopyOption. *;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import interfaceG.GetProperties;

/**
 * Classe responsavel por salvar os dados recebidos do programa em um arquivo
 * .txt;
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class SaveData {
	private String nome;
	private String area;
	private String volume = null;
	private Properties prop;

	public SaveData() {
		super();
	}

	public SaveData(String nome, String area, String volume) {
		this.nome = nome;
		this.area = area;
		this.volume = volume;
		SaveDates();
	}

	public SaveData(String figura, String area) throws IOException {
		this(figura, area, "-");
	}

	public void deleteDates() {

		try {
			FileWriter arq = null;
			prop = GetProperties.getProp();
			arq = new FileWriter(prop.getProperty("saveData"));
			arq.close();

		} catch (FileNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	private void SaveDates() {

		try {
			FileWriter arq = null;
			BufferedWriter escritor = null;
			prop = GetProperties.getProp();

			arq = new FileWriter(prop.getProperty("saveData"), true);
			escritor = new BufferedWriter(arq);
			escritor.write(nome + ";" + area + ";" + volume);
			escritor.newLine();

			escritor.close();
			arq.close();

		} catch (FileNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void SaveDates(String path) {
		prop = GetProperties.getProp();

		 Path path2 = FileSystems.getDefault().getPath(prop.getProperty("saveData"));
		 Path pathTarget = FileSystems.getDefault().getPath(path);
		 
		try {
			Files.copy(path2, pathTarget, REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro: "+e.getMessage());
		}

		prop.replace("saveData", path);
	}

}

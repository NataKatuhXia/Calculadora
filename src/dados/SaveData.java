package dados;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import interfaceG.GetProperties;

/**
 * Classe responsavel por salvar os dados recebidos do programa em um arquivo
 * txt.
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

	public SaveData(String nome, String area, String volume) throws IOException {
		this.nome = nome;
		this.area = area;
		this.volume = volume;
		SaveDates();
	}

	public SaveData(String figura, String area) throws IOException {
		this(figura, area, "-");
	}

	public void deleteDates() throws IOException {
		FileWriter arq = null;
		prop = GetProperties.getProp();

		try {
			arq = new FileWriter(prop.getProperty("saveData"));
			arq.close();

		} catch (FileNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	private void SaveDates() throws IOException {
		FileWriter arq = null;
		BufferedWriter escritor = null;
		prop = GetProperties.getProp();

		try {
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

}

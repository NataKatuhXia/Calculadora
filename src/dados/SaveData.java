package dados;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.Files;
import java.nio.file.Path;

import dados.GetProperties;

/**
 * Classe responsavel por salvar os dados recebidos do programa em um arquivo
 * .txt;
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class SaveData extends GetProperties {
	private String nome;
	private String area;
	private String volume = null;

	/**
	 * Construtor
	 */
	public SaveData() {
		super();
	}

	/**
	 * Construtor para receber os parâmetros que serão salvos
	 */
	public SaveData(String nome, String area, String volume) {
		this.nome = nome;
		this.area = area;
		this.volume = volume;
		SaveDates();
	}

	/**
	 * Construtor para receber os parâmetros que serão salvos
	 */
	public SaveData(String nome, String area) throws IOException {
		this(nome, area, "-");
	}

	/*
	 * Método para limpar a JTable e o arquivo txt
	 */
	public void deleteDates() {

		try {
			FileWriter arq = null;
			if (prop.getProperty("CustomSave") == null) {
				arq = new FileWriter(prop.getProperty("saveData"));
			} else {
				arq = new FileWriter(prop.getProperty("CustomSave"));
			}
			arq.close();

		} catch (FileNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	/*
	 * Salvar dados automaticamente no arquivo Txt
	 */
	private void SaveDates() {
		try {
			FileWriter arq = null;
			BufferedWriter escritor = null;
			if (prop.getProperty("CustomSave") == null) {
				arq = new FileWriter(prop.getProperty("saveData"), true);
			} else {
				arq = new FileWriter(prop.getProperty("CustomSave"), true);
			}
			escritor = new BufferedWriter(arq);
			escritor.write(nome + " / " + area + " / " + volume);
			escritor.newLine();

			escritor.close();
			arq.close();

		} catch (FileNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	/**
	 * Método para salvar o arquivo
	 * 
	 * @pam path = caminho que o usuário vai escolher para salvar o arquivo
	 */
	public void SaveDates(String path) {
		Path path2;

		if (prop.getProperty("CustomSave") == null) {
			path2 = FileSystems.getDefault().getPath(prop.getProperty("saveData"));
		} else {
			path2 = FileSystems.getDefault().getPath(prop.getProperty("CustomSave"));
		}

		Path pathTarget = FileSystems.getDefault().getPath(path);
		FileOutputStream out;
		try {
			Files.copy(path2, pathTarget, REPLACE_EXISTING);
			FileWriter arq = new FileWriter(prop.getProperty("saveData"));
			out = new FileOutputStream("./src/properties/listComandos.properties");
			prop.setProperty("CustomSave", path);
			prop.store(out, "\n");

			out.close();
			arq.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro: " + e.getMessage());
		}
	}

}

package dados;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe responsavel por carregar os diret�rios de todo programa como as
 * imagens,�cones e arquivos txt atrav�s de uma key.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class GetProperties {
	public static final Properties prop = getProp();

	public static Properties getProp() {
		Properties props = new Properties();
		try {
			FileInputStream file = new FileInputStream("./src/properties/listComandos.properties");
			props.load(file);
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return props;
	}

}

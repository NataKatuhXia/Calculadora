package interfaceG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Classe responsavel por carregar as urls de todo programa 
 * como as imagens,�cones e arquivos txt atrav�s de uma key.
 * @author R-CALC
 * @since 1.0	
 * @version 1.0 
 */
public class GetProperties {

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./src/properties/listImages.properties");
		props.load(file);

		return props;
	}

}

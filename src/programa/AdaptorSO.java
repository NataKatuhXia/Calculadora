package programa;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe responsável pela detecção do S.O do usuário e adaptar o programa a ele
 * 
 * @author R-Calc
 * @since 1.0
 * @version 1.0
 *
 */
public class AdaptorSO {

	public AdaptorSO() {

		/*
		 * Essa parte irá resgatar a aparência nativa do S.O., por exemplo se você
		 * estiver em um ambiente windows a sua JFrame terá a mesma aparência do
		 * windows, se estiver em linux, ela terá a aparência do linux e assim
		 * sucessivamente!
		 */

		String lookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeelClassName);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// Apresentar o erro no Console
			System.out.println("Erro: " + e.getMessage());
			;
		}
	}

}

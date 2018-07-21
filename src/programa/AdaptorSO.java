package programa;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

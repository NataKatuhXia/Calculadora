package programa;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AdaptorSO {

	public AdaptorSO() {

		/*
		 * Essa parte ir� resgatar a apar�ncia nativa do S.O., por exemplo se voc�
		 * estiver em um ambiente windows a sua JFrame ter� a mesma apar�ncia do
		 * windows, se estiver em linux, ela ter� a apar�ncia do linux e assim
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

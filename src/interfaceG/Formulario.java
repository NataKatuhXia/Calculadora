package interfaceG;

import javax.swing.JPanel;

import geometricShapes.Cilindro;
import geometricShapes.Circulo;
import geometricShapes.Cone;
import geometricShapes.CoroaCircular;
import geometricShapes.Cubo;
import geometricShapes.CunhaEsferica;
import geometricShapes.Esfera;
import geometricShapes.Losango;
import geometricShapes.OctaedroRegular;
import geometricShapes.Paralelepipedo;
import geometricShapes.Paralelogramo;
import geometricShapes.Piramide;
import geometricShapes.PoligonoRegular;
import geometricShapes.PrismaReto;
import geometricShapes.Quadrado;
import geometricShapes.Retangulo;
import geometricShapes.SetorCircular;
import geometricShapes.TampaEsferica;
import geometricShapes.TetraedroRegular;
import geometricShapes.Trapezio;
import geometricShapes.Triangulo;
import geometricShapes.TroncodeCone;
import geometricShapes.ZonaEsferica;

/**
 * Classe responsavel por selecionar as informações que iram aparecer na tela.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class Formulario {
	public JPanel painel2;

	/**
	 * 
	 * @param opcao
	 * @return JPanel
	 */
	public JPanel montaPainel(int opcao) {
		painel2 = new JPanel();
		painel2.setLayout(null);
		painel2.setVisible(true);
		painel2.setBounds(0, 157, 994, 604);

		if (opcao == 1) {
			Cilindro fig = new Cilindro();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 2) {
			Circulo fig = new Circulo();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 3) {
			Cone fig = new Cone();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 4) {
			CoroaCircular fig = new CoroaCircular();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 5) {
			Cubo fig = new Cubo();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 6) {
			CunhaEsferica fig = new CunhaEsferica();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 7) {
			Esfera fig = new Esfera();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 8) {
			Losango fig = new Losango();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 9) {
			OctaedroRegular fig = new OctaedroRegular();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 10) {
			Paralelepipedo fig = new Paralelepipedo();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 11) {
			Paralelogramo fig = new Paralelogramo();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 12) {
			Piramide fig = new Piramide();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 13) {
			PoligonoRegular fig = new PoligonoRegular();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 14) {
			PrismaReto fig = new PrismaReto();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 15) {
			Quadrado fig = new Quadrado();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 16) {
			Retangulo fig = new Retangulo();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 17) {
			SetorCircular fig = new SetorCircular();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 18) {
			TampaEsferica fig = new TampaEsferica();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 19) {
			TetraedroRegular fig = new TetraedroRegular();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 20) {
			Trapezio fig = new Trapezio();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 21) {
			Triangulo fig = new Triangulo();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 22) {
			TroncodeCone fig = new TroncodeCone();
			painel2 = fig.montaRequisitos();
		}

		else if (opcao == 23) {
			ZonaEsferica fig = new ZonaEsferica();
			painel2 = fig.montaRequisitos();
		}

		return painel2;
	}
}

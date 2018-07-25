package programa;

import interfaceG.InterfaceGrafica;

/**
 * Classe responsavel pela execução do programa.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class ProgramaCalc {
	public static void main(String[] args) {

		// Instanciando a classe responável por adaptar o Programa ao S.O
		new AdaptorSO();

		// Instanciando a classe Reponsável pela inicialização do Programa
		new InterfaceGrafica();

	}
}

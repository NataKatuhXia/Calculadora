package programa;

import interfaceG.InterfaceGrafica;

/**
 * Classe responsavel pela execu��o do programa.
 * 
 * @author R-CALC
 * @since 1.0
 * @version 1.0
 */
public class ProgramaCalc {
	public static void main(String[] args) {

		// Instanciando a classe respon�vel por adaptar o Programa ao S.O
		new AdaptorSO();

		// Instanciando a classe Repons�vel pela inicializa��o do Programa
		new InterfaceGrafica();

	}
}

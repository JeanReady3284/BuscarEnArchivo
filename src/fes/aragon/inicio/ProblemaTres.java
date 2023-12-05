package fes.aragon.inicio;

import fes.aragon.exep.IndiceFueraDeRango;
import fes.aragon.utilerias.dinamicas.listadoble.ListaDoble;
import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class ProblemaTres {
	
	public static void main(String[] args) {
		ListaSimple<ListaDoble<String>> listas = new ListaSimple<>();

		for (int i = 0; i < 11; i++) {
			listas.agregarEnCola(new ListaDoble<>());
		}
		
		MetodosAdicionales.guardaPalabras(listas, "/dat/Archivo");
		for (int i = 0; i < listas.getLongitud(); i++) {
			listas.obtenerNodo(i).imprimirElementos();
			System.out.println();
		}
		
		System.out.print("-----\nImpresión de la fila 0: ");
		listas.obtenerNodo(0).imprimirElementos();
		System.out.print("\nImpresión de la fila 7: ");
		listas.obtenerNodo(7).imprimirElementos();
		System.out.println("\n------");
		try {
			System.out.print("Impresion de la fila 0 hasta la columna 2: ");
			MetodosAdicionales.muestraHasta(2, listas, 0);
			System.out.print("\nImpresion de la fila 4 hasta la columna 6: ");
			MetodosAdicionales.muestraHasta(6, listas, 4);
		} catch (IndiceFueraDeRango e) {

			e.printStackTrace();
		}
	}
}

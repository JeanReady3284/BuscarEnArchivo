package fes.aragon.inicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import fes.aragon.exep.IndiceFueraDeRango;
import fes.aragon.utilerias.dinamicas.listadoble.ListaDoble;
import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class MetodosAdicionales {
	
	/**
	 *	Metodo que muestra hasta el indice del elemento indicado  
	 * @param <E> parametro que indica la genericidad
	 * @param limite parametro que indica el limite del indice hasta donde se mostrará 
	 * @param lista parametro que indica la lista que guarda las listas con la información
	 * @param fila parametro que indica la fila que se va a mostrar  
	 * @throws IndiceFueraDeRango Excepción que ocurre cuando se inserta un limite fuera del rango
	 */

	public static  <E> void muestraHasta(int limite, ListaSimple<ListaDoble<E>> lista, int fila)
			throws IndiceFueraDeRango {
		if (limite > lista.obtenerNodo(fila).getLongitud()) {
			throw new IndiceFueraDeRango("Indice Fuera De Rango");
		} else {
			for (int i = 0; i < limite; i++) {
				System.out.print(lista.obtenerNodo(fila).obtenerNodo(i) + " ");
			}

		}
	}
	
	/**
	 * Metodo que guarda las palabras de un archivo en una lista simple
	 * @param lista parametro que indica la lista en donde se insertarán las palabras 
	 * @param ubicacion parametro que indica la ruta usando el directorio del usuario
	 */
	public static void guardaPalabras(ListaSimple<ListaDoble<String>> lista, String ubicacion) {
		try {
			File f = new File(System.getProperty("user.dir") + ubicacion);
			FileReader fr = new FileReader(f);
			BufferedReader buff = new BufferedReader(fr);
			String cad;
			int indice = 0;

			while ((cad = buff.readLine()) != null) {
				String[] palabraString = cad.split(" ");

				for (int i = 0; i < palabraString.length; i++) {
					lista.obtenerNodo(indice).agregarEnCola(palabraString[i]);
				}
				indice++;
			}
			buff.close();
			fr.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();

		} catch (IOException ex) {

			ex.printStackTrace();
		}

	}
}

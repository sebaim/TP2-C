package com.parte3.tp2;

public class TDAMonticulo {

	/*
	 * vector que contiene los elementos, se desperdicia la posicion 0.
	 */
	private Integer[] vector;

	/*
	 * tamUsado = cantidad de elementos en el vector,
	 */
	private int tamUsado;

	/*
	 * Constructor publico del TDAMonticulo
	 */
	public TDAMonticulo() {

		vector = new Integer[1];
		tamUsado = 0;
	}

	/*
	 * Aumenta al doble el tama�o del vector
	 */
	private void resize() {

		Integer[] aux = new Integer[vector.length * 2];
		for (int i = 1; i <= tamUsado; i++) {

			aux[i] = this.vector[i];
		}

		System.out.println("RESIZE: " + vector.length + "->" + aux.length);
		this.vector = aux;
	}

	/*
	 * Muestra el hijo izquierdo de un nodo en la posicion i
	 */
	private Integer hijoIzquierda(int i) {

		if (tamUsado < 2 * i) {
			return null;
		} else {
			return vector[2 * i];
		}
	}

	/*
	 * Muestra el hijo derecho de un nodo de la posicion i
	 */
	private Integer hijoDerecha(int i) {

		if (tamUsado < (2 * i + 1)) {
			return null;
		} else {
			return vector[2 * i + 1];
		}
	}

	/*
	 * Pregunta si es un monticulo vacio
	 */
	public boolean isMonticuloVacio() {

		return (tamUsado == 0);
	}

	/*
	 * Pregunta si el monticulo esta lleno de valores
	 */
	private boolean isMonticuloLleno() {

		return (tamUsado == vector.length - 1);
	}

	/*
	 * Vacia el monticulo
	 */
	public void vaciarMonticulo() {

		for (int i = 1; i < tamUsado; i++) {

			vector[i] = null;
		}
		tamUsado = 0;
	}

	/*
	 * Muestra el maximo valor del monticulo
	 */
	public Integer verPadre() {

		if (tamUsado < 1) {

			return null;
		} else {

			return vector[1];
		}
	}

	/*
	 * Muestra el padre de un nodo de la posicion i
	 */
	private Integer padre(int i) {

		if (tamUsado < i) {

			return null;
		}

		int parteEntera = (int) (i / 2);
		return vector[parteEntera];
	}

	/*
	 * Pregunta si es un nodo hoja
	 */
	private boolean isNodoHoja(int pos) {

		if (hijoIzquierda(pos) != null && hijoDerecha(pos) != null) {

			return false;
		}

		return true;
	}

	/*
	 * Inserta un elemento en el monticulo
	 */
	public void insertar(Integer value) {

		// Vector estatico lleno
		if (isMonticuloLleno()) {
			resize();
		}

		// Se agrega el vector al final
		this.tamUsado++;
		vector[tamUsado] = value;

		// Se ordena
		int i = tamUsado;
		while (i > 1 && vector[i / 2].intValue() < vector[i].intValue()) {

			Integer aux = vector[i / 2];
			vector[i / 2] = vector[i];
			vector[i] = aux;

			i = i / 2;
		}
	}

	/*
	 * Extrae un elemento del monticulo
	 */
	public Integer eliminar() {

		// Monticulo vacio
		if (isMonticuloVacio()) {

			return null;
		}

		// Monticulo con un solo elemento
		if (tamUsado == 1) {

			Integer aux = vector[1];
			vector[1] = null;
			tamUsado--;
			return aux;
		}

		// Monticulo con mas de un elemento
		Integer retorno = vector[1];
		vector[1] = vector[tamUsado];
		vector[tamUsado] = null;
		tamUsado--;

		// Se ordena
		int i = 1;
		while (i * 2 < tamUsado) {

			// Se calculan las posiciones de los hijos
			int izq = i * 2;
			int der = i * 2 + 1;
			int ladoACambiar; // lado candidato a cambiar

			// Si no tiene un hijo derecho solo cambia al izquierdo
			if (der > tamUsado) {
				
				ladoACambiar = izq;
			} else {

				// En cambio si tiene dos hijos, se fija quien es el mayor para cambiar
				if (vector[izq] >= vector[der]) {

					ladoACambiar = izq;
				} else {

					ladoACambiar = der;
				}
			}

			// Si el valor de la posicion actual es mayor al candidato se cambia
			if (vector[i] < vector[ladoACambiar]) {

				Integer aux = vector[i];
				vector[i] = vector[ladoACambiar];
				vector[ladoACambiar] = aux;
				i = ladoACambiar;

			}
		}

		return retorno;
	}

	// =======================================
	// TODO BORRAR, solo para pruebas nada mas
	// =======================================
	public void mostrar() {

		if (!isMonticuloVacio()) {

			int i = 1;

			while (i <= tamUsado) {

				System.out.println(i + ": " + vector[i]);
				i++;
			}
		}
	}

	public static void main(String[] args) {

		TDAMonticulo m = new TDAMonticulo();

		m.insertar(7);
		m.insertar(20);
		m.insertar(2);
		m.insertar(8);
		m.insertar(90);
		m.insertar(5);
		m.insertar(1);
		// m.insertar(0);
		// m.mostrar();
		// System.out.println(m.eliminar());
		System.out.println(m.eliminar());

		m.mostrar();

	}
}

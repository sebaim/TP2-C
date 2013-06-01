package com.parte3.tp2;

public class ColaDeP implements Cola {

	private TDAMonticulo cola;

	ColaDeP() {

		cola = new TDAMonticulo();
	}

	/*
	 * Pregunta si la cola esta vacia
	 */
	@Override
	public boolean empty() {

		return cola.isMonticuloVacio();
	}

	/*
	 * Encola un elemento
	 */
	@Override
	public void offer(Integer dato) {

		cola.insertar(dato);
	}

	/*
	 * Desencola un elemento
	 */
	@Override
	public Integer poll() {

		return cola.eliminar();
	}

	/*
	 * Referencia al primer elemento de la cola
	 */
	@Override
	public Integer peek() {

		return cola.verPadre();
	}

	/*
	 * Vacia la cola
	 */
	@Override
	public void vaciar() {

		cola.vaciarMonticulo();
	}

	public static void main(String[] args) {
		
		Cola c = new ColaDeP();
		
		c.offer(new Integer(5));
		c.offer(new Integer(3));
		c.offer(new Integer(30));
		c.offer(new Integer(2));
//		c.vaciar();
		System.out.println(c.poll());
		System.out.println(c.peek());
		
	}
}

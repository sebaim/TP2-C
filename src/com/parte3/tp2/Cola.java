package com.parte3.tp2;

public interface Cola {

	/*
	 * Pregunta si la cola esta vacia
	 */
    public boolean empty();

    /*
     * Encola un elemento
     */
    public void offer(Integer dato);

    /*
     * Desencola un elemento
     */
    public Integer poll();

    /*
     * Referencia al primer elemento de la cola
     */
    public Integer peek();
    
    /*
     * Vacia la cola
     */
    public void vaciar();
}

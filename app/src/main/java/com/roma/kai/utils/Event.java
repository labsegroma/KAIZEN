package com.roma.kai.utils;

/**
 * Clase para manejar eventos de una sola ejecucion en LiveData.
 * Basada en el patron Event Wrapper.
 */
public class Event<T> {
    private T contenido;
    private boolean manejado = false;

    public Event(T contenido) {
        this.contenido = contenido;
    }

    /**
     * Devuelve el contenido y evita su uso futuro.
     */
    public T obtenerContenidoSiNoManejado() {
        if (manejado) {
            return null;
        } else {
            manejado = true;
            return contenido;
        }
    }

    /**
     * Devuelve el contenido, incluso si ya fue manejado.
     */
    public T verContenido() {
        return contenido;
    }
}

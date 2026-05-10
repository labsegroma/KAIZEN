package com.roma.kai.utils;

/**
 * Clases para representar el estado de la UI siguiendo el patron MVVM.
 */
public abstract class EstadoUI {
    
    public static final class EstadoCargando extends EstadoUI {}
    
    public static final class EstadoExito<T> extends EstadoUI {
        private final T datos;
        public EstadoExito(T datos) { this.datos = datos; }
        public T getDatos() { return datos; }
    }
    
    public static final class EstadoError extends EstadoUI {
        private final String mensaje;
        public EstadoError(String mensaje) { this.mensaje = mensaje; }
        public String getMensaje() { return mensaje; }
    }
}

// Excepción personalizada para cuando el producto no se encuentra
class ProductoNoEncontradoException extends Exception {
    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}

// Excepción personalizada para cuando no hay suficiente cantidad en el inventario
class CantidadInsuficienteException extends Exception {
    public CantidadInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

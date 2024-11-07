import java.util.HashMap;
import java.util.Map;

class Inventario {
    private Map<String, Integer> productos;

    public Inventario() {
        productos = new HashMap<>();
    }

    // Agregar un producto al inventario
    public void agregarProducto(String nombre, int cantidad) {
        productos.put(nombre, productos.getOrDefault(nombre, 0) + cantidad);
        System.out.println("Producto agregado: " + nombre + ", cantidad: " + cantidad);
    }

    // Retirar una cantidad de un producto, lanza excepciones si hay problemas
    public void retirarProducto(String nombre, int cantidad) throws ProductoNoEncontradoException, CantidadInsuficienteException {
        if (!productos.containsKey(nombre)) {
            throw new ProductoNoEncontradoException("El producto " + nombre + " no se encuentra en el inventario.");
        }

        int cantidadActual = productos.get(nombre);
        if (cantidadActual < cantidad) {
            throw new CantidadInsuficienteException("Cantidad insuficiente de " + nombre + ". Cantidad actual: " + cantidadActual);
        }

        productos.put(nombre, cantidadActual - cantidad);
        System.out.println("Producto retirado: " + nombre + ", cantidad: " + cantidad);
    }
}

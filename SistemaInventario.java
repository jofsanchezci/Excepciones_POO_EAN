public class SistemaInventario {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // Agregar productos al inventario
        inventario.agregarProducto("Laptop", 10);
        inventario.agregarProducto("Teclado", 20);

        try {
            // Intentar retirar productos
            inventario.retirarProducto("Laptop", 5);
            inventario.retirarProducto("Teclado", 25); // Esto lanzará CantidadInsuficienteException
            inventario.retirarProducto("Mouse", 1); // Esto lanzará ProductoNoEncontradoException
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CantidadInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Operación de inventario finalizada.");
        }
    }
}

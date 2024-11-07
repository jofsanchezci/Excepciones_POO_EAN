
# Sistema de Gestión de Inventarios en Java

Este proyecto es un sistema básico de gestión de inventarios en Java que utiliza excepciones personalizadas para manejar errores específicos, como cuando un producto no se encuentra en el inventario o cuando no hay suficiente cantidad de un producto para realizar una operación.

## Estructura del Proyecto

- **Inventario**: Clase principal que gestiona el inventario y mantiene los productos y sus cantidades.
- **Excepciones Personalizadas**:
  - `ProductoNoEncontradoException`: Excepción lanzada cuando se intenta acceder a un producto que no existe en el inventario.
  - `CantidadInsuficienteException`: Excepción lanzada cuando la cantidad solicitada de un producto es mayor que la cantidad disponible en el inventario.
- **SistemaInventario**: Clase principal para ejecutar el programa, que utiliza bloques `try-catch` para manejar las excepciones.

## Clases
    
### 1. Clase `ProductoNoEncontradoException`

Excepción personalizada para manejar el error de producto no encontrado.

```java
class ProductoNoEncontradoException extends Exception {
    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
```

### 2. Clase `CantidadInsuficienteException`

Excepción personalizada para manejar el error de cantidad insuficiente.

```java
class CantidadInsuficienteException extends Exception {
    public CantidadInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
```

### 3. Clase `Inventario`

Clase que mantiene un registro de productos y sus cantidades en un `HashMap`. Incluye métodos para agregar y retirar productos del inventario.

```java
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
```

### 4. Clase `SistemaInventario`

Clase principal del programa que utiliza bloques `try-catch` para manejar las excepciones lanzadas durante las operaciones de inventario.

```java
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
```

## Ejecución del Proyecto

1. Compila las clases:
   ```bash
   javac SistemaInventario.java
   ```

2. Ejecuta la clase principal:
   ```bash
   java SistemaInventario
   ```

## Ejemplo de Salida

```
Producto agregado: Laptop, cantidad: 10
Producto agregado: Teclado, cantidad: 20
Producto retirado: Laptop, cantidad: 5
Error: Cantidad insuficiente de Teclado. Cantidad actual: 20
Error: El producto Mouse no se encuentra en el inventario.
Operación de inventario finalizada.
```

## Descripción de las Excepciones

- **ProductoNoEncontradoException**: Se lanza cuando se intenta retirar un producto que no existe en el inventario.
- **CantidadInsuficienteException**: Se lanza cuando la cantidad solicitada es mayor que la cantidad disponible.

### Ventajas del Manejo de Excepciones en POO

1. **Claridad**: Las excepciones personalizadas facilitan la identificación de errores específicos.
2. **Modularidad**: Cada tipo de error se maneja en su propio bloque `catch`.
3. **Mantenimiento**: Se mejora la legibilidad y mantenibilidad del código, ya que cada error se gestiona en un solo lugar.

Este sistema es escalable y permite manejar errores en el inventario de manera eficiente, utilizando el manejo de excepciones en Java.

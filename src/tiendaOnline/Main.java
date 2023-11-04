package tiendaOnline;

public class Main {
    public static void main(String[] args) {
        // Crear productos
        Producto producto1 = new Producto("Camiseta", 20.0, 50);
        Producto producto2 = new Producto("Pantalón", 30.0, 30);

        // Crear un carrito de compras
        carritoCompra carrito = new carritoCompra();

        // Agregar productos al carrito
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);

        // Mostrar el estado del pedido (productos en el carrito)
        System.out.println("Estado del pedido:");
        carrito.verEstadoPedido();
        
        // Procesar el pago con tarjeta
        pagoTarjeta metodoPago = new pagoTarjeta("1234567890123456", "12/25", 123);
        Compra compra = new Compra();
        compra.completarCompra(carrito, metodoPago);
    }
}


/*
 * No funciona, lo intente crear para simular una parte de registrar o iniciar sesion y el codigo
 *  registra todo el rato los nombre, pero a la que termina el programa no se guarda el usario
 */
/*
 
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        almacenamientoUsuario repositorio = new almacenamientoUsuario();

        // Cargar usuarios del archivo al iniciar el programa
        cargarUsuarios(repositorio);

        System.out.println("Bienvenido a la tienda en línea");

        // Registro de un nuevo usuario
        System.out.println("Por favor, registra un nuevo usuario:");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        Usuario usuarioExistente = repositorio.buscarUsuario(nombreUsuario);
        if (usuarioExistente != null) {
            System.out.println("El nombre de usuario ya está en uso. Por favor, elige otro.");
        } else {
            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();
            Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena);
            repositorio.agregarUsuario(nuevoUsuario);
            System.out.println("¡Registro exitoso!");

            // Guardar usuarios en el archivo después de agregar uno nuevo
            guardarUsuarios(repositorio);
        }

        // Inicio de sesión (parte comentada)
        
        System.out.println("\nIniciar Sesión");
        System.out.print("Nombre de usuario: ");
        String nombreUsuarioInicio = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasenaInicio = scanner.nextLine();

        Usuario usuarioSesion = repositorio.buscarUsuario(nombreUsuarioInicio);

        if (usuarioSesion != null && usuarioSesion.getContrasena().equals(contrasenaInicio)) {
            System.out.println("¡Inicio de sesión exitoso para el usuario " + nombreUsuarioInicio + "!");
            // Aquí se puede implementar la lógica para la interacción con los productos
            // Por ejemplo, mostrar catálogo, añadir productos al carrito, realizar compras, etc.
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos. Inicio de sesión fallido.");
        }
        

        // Cierre del Scanner al finalizar el proceso
        scanner.close();
    }

    private static void cargarUsuarios(almacenamientoUsuario repositorio) {
        try {
            File file = new File("usuarios.txt");
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream("usuarios.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                repositorio.setListaUsuarios((ArrayList<Usuario>) objectInputStream.readObject());

                objectInputStream.close();
                fileInputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void guardarUsuarios(almacenamientoUsuario repositorio) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("usuarios.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(repositorio.getListaUsuarios());

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
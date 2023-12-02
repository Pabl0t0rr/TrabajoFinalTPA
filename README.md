# TrabajoFinalTPA

Tienda online llamada Components Tech

## Desarrolladores
- Pedro Zuñeda Diego
- Pablo Torres Villar

## Descripción Funcionalidad

1. Tienda para comprar ordenadores premontados y piezas sueltas.
2. Opción de iniciar sesion y registrarte.
3. Poder ver lo que tengas en el carrito por si lo quieres comprar.
4. Buscador de productos.

Queda por añadir:

1. Los productos.
2. Opcion de atencion al cliente.
3. Teléfono de contacto.

## Patrón de diseño usado
-Diseño observer

## Diagrama UML
```mermaid

classDiagram
    class almacenamientoUsuario {
        - listaUsuarios: List<Usuario>
        + almacenamientoUsuario()
        + agregarUsuario(usuario: Usuario): void
        + buscarUsuario(nombreUsuario: String): Usuario
    }

    class carritoCompra {
        - productosEnCarrito: ArrayList<Producto>
        + getProductosCarrito(): ArrayList<Producto>
        + agregarProducto(producto: Producto): void
        + eliminarProducto(producto: Producto): void
        + calcularCostoTotal(): double
        + verEstadoPedido(): void
        + actualizarEstadoPedido(numeroPedido: int, nuevoEstado: String): void
        + verificarDisponibilidadProducto(producto: Producto): boolean
    }

    class Compra {
        + completarCompra(carrito: carritoCompra, metodoPago: Pago): void
    }

    class Pago {
        + procesarPago(): void
    }

    class pagoTarjeta {
        - numeroTarjeta: String
        - fechaVencimiento: String
        - codigoSeguridad: int
        + pagoTarjeta(numeroTarjeta: String, fechaVencimiento: String, codigoSeguridad: int)
        + validarTarjeta(): boolean
        + fechaVencimientoValida(fechaVencimiento: String): boolean
        + procesarPago(): void
    }

    class Producto {
        - nombre: String
        - precio: double
        - cantidadEnStock: int
        - descripcion: String
        -categoria: String
        + Producto(nombre: String, precio: double, cantidadEnStock: int, descripcion: String,categoria: String)
        + agregarStock(cantidad: int): void
        + restarStock(cantidad: int): void
        + actualizarPrecio(nuevoPrecio: double): void
        + mostrarInformacion(): void
        + buscarPorPalabra(palabraBuscada: String): boolean
    }

    class seguimientoPedido {
        + verEstadoPedido(): void
        + actualizarEstadoPedido(numeroPedido: int, nuevoEstado: String): void
        + verificarDisponibilidadProducto(producto: Producto): boolean
    }

    class Usuario {
        - nombreUsuario: String
        - contrasena: String
        + Usuario(nombreUsuario: String, contrasena: String)
    }

    class PCPremontado{
        +PCPremontado(String nombre, double precio, int stock, String descripcion)
    }

    class Pieza{
        +Pieza(String nombre, double precio, int stock, String descripcion)
    }
Usuario --|> almacenamientoUsuario
Producto --|> carritoCompra
Producto --|> PCPremontado
Producto --|> Pieza
carritoCompra --> Compra: utiliza
Compra --> Pago: utiliza
carritoCompra --> seguimientoPedido: utiliza
Pago --> pagoTarjeta: utiliza
```

## Vistas


<img width="352" alt="image" src="https://github.com/Pabl0t0rr/TrabajoFinalTPA/assets/144015677/3991a1ed-5cb5-4d63-9fd1-49d588eb331e">


<img width="142" alt="image" src="https://github.com/Pabl0t0rr/TrabajoFinalTPA/assets/144015677/435ed2a2-305e-4900-be1c-cb9c48259f11">

<img width="179" alt="image" src="https://github.com/Pabl0t0rr/TrabajoFinalTPA/assets/144015677/a9155150-9dfc-4e42-900d-32797336dada">

<img width="154" alt="image" src="https://github.com/Pabl0t0rr/TrabajoFinalTPA/assets/144015677/7b6ef126-8384-45c3-ae12-fa11bda215c3">

<img width="313" alt="image" src="https://github.com/Pabl0t0rr/TrabajoFinalTPA/assets/144015677/546a3c35-09ce-40e4-9a83-69453c274237">








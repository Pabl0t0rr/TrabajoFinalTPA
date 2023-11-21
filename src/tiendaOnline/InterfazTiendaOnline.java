package tiendaOnline;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * La clase InterfazTiendaOnline representa la interfaz de la tienda online.
 */
public class InterfazTiendaOnline extends JFrame {

	// Declaraciones de variables y componentes de la interfaz
	private Usuario usuarioSesion;
	private JPanel panelCarrito;
	private List<Producto> listaProductos;
	private List<Producto> productosEnCarrito = new ArrayList<>();

	/**
	 * Constructor de la interfaz de la tienda online.
	 */
	public InterfazTiendaOnline() {
		listaProductos = new ArrayList<>();
		productosEnCarrito = new ArrayList<>();


		//Premontados
		Producto pcPremontado = new PCPremontado("PC Gaming", 1200.0, 9, "Potente PC para juegos");
		Producto pcPremontado1 = new PCPremontado("PC Gaming", 800.0, 7, "PC con buen rendimiento, para trabajar en casa");		
		listaProductos.add(pcPremontado);
		listaProductos.add(pcPremontado1);

		//Procesadores
		Producto cpu = new Pieza("Procesador Intel Core i7", 300.0, 10, "Procesador potente para rendimiento");
		Producto cpu1 = new Pieza("Procesador Intel Core i5", 150.0, 10, "Procesador de potencia media");
		listaProductos.add(cpu);
		listaProductos.add(cpu1);

		/*
		//Placa Base
		Producto Pb = new Pieza("Placa Base",  300.0,7,"MSI MPG B550 GAMING PLUS");
		Producto Pb1 = new Pieza("Placa Base",  300.0,7,"ASUS ROG STRIX Z790-F GAMING WIFI");
		listaProductos.add(Pb);
		listaProductos.add(Pb1);

		//RAM
		Producto RAM = new Pieza("RAM con RGB", 300.0, 10, "Corsair Vengeance RGB DDR5 6000MHz PC5-48000 32GB 2x16GB CL36 Negra");
		Producto RAM1 = new Pieza("RAM", 150.0, 10, "Kingston FURY Beast DDR4 3200 MHz 16GB 2x8GB CL16");
		listaProductos.add(RAM);
		listaProductos.add(RAM1);

		//Graficas
		Producto grafica = new Pieza("Procesador Intel Core i7", 300.0, 10, "MSI GeForce RTX 4080 VENTUS 3X E OC 16GB GDDR6X DLSS3");
		Producto grafica1 = new Pieza("Procesador Intel Core i5", 150.0, 10, "MSI AMD Radeon RX 6650 XT GAMING X 8GB GDDR6");
		listaProductos.add(grafica);
		listaProductos.add(grafica1);

		//
		 */

		setTitle("www.Computer-tech.com");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel superior para los elementos de la izquierda-medio
		JPanel panelBuscar = new JPanel();
		add(panelBuscar);

		// Campo de texto para la búsqueda
		JTextField campoBusqueda = new JTextField(20);
		panelBuscar.add(campoBusqueda);

		// Botón de búsqueda
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String palabraClave = campoBusqueda.getText();
				buscarProducto(palabraClave);
			}
		});
		panelBuscar.add(btnBuscar);

		JButton btnMenu = new JButton("☰");
		btnMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarMenu(btnMenu.getLocationOnScreen());
			}
		});

		JPanel panelMenu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelMenu.add(btnMenu);
		add(panelMenu, BorderLayout.NORTH);

		// Crear dos paneles para las columnas de PC premontados y piezas
		JPanel panelPCPremontados = new JPanel();
		panelPCPremontados.setLayout(new BoxLayout(panelPCPremontados, BoxLayout.Y_AXIS));
		JPanel panelPiezas = new JPanel();
		panelPiezas.setLayout(new BoxLayout(panelPiezas, BoxLayout.Y_AXIS));

		// Agregar etiquetas a los paneles
		JLabel lblPCPremontados = new JLabel("PC Premontados: ");
		JLabel lblPiezas = new JLabel("Piezas: ");

		panelPCPremontados.add(lblPCPremontados);
		panelPiezas.add(lblPiezas);

		// Agregar productos a las respectivas columnas
		for (Producto producto : listaProductos) {
			if (producto.getCategoria().equals("PC Premontado")) {
				JButton btnProducto = new JButton(producto.getNombre());
				btnProducto.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						mostrarDetallesProducto(producto);
					}
				});
				panelPCPremontados.add(btnProducto);
			}
		}
		// Dentro del bucle para Piezas
		for (Producto producto : listaProductos) {
			if (producto.getCategoria().equals("Pieza")) {
				JButton btnProducto = new JButton(producto.getNombre());
				btnProducto.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						mostrarDetallesProducto(producto);
					}
				});
				panelPiezas.add(btnProducto);
			}
		}

		// Crear un panel principal para organizar los elementos
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		panelPrincipal.add(panelBuscar, BorderLayout.NORTH);
		panelPrincipal.add(panelPCPremontados, BorderLayout.WEST);
		panelPrincipal.add(panelPiezas, BorderLayout.EAST);

		add(panelPrincipal);

		// Panel para el carrito
		panelCarrito = new JPanel();
		add(panelCarrito, BorderLayout.SOUTH);

		setVisible(true);
	}

	/**
	 * Muestra un menú emergente en una posición específica.
	 *
	 * @param pos La posición en la pantalla donde se mostrará el menú.
	 */
	private void mostrarMenu(Point pos) {
		JPopupMenu menu = new JPopupMenu();

		JMenuItem itemInicioSesion = new JMenuItem("Usuario");
		itemInicioSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaInicioSesion();
			}
		});
		menu.add(itemInicioSesion);

		JMenuItem itemVerCarrito = new JMenuItem("Ver Carrito");
		itemVerCarrito.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Muestra el carrito en una ventana separada
				mostrarVentanaCarrito();
			}
		});
		menu.add(itemVerCarrito);

		menu.show(this, pos.x, pos.y);
	}

	/**
	 * Muestra una ventana para el inicio de sesión.
	 */
	private void mostrarVentanaInicioSesion() {
		JFrame frameInicioSesion = new JFrame("Inicio de Sesión");
		frameInicioSesion.setSize(300, 200);

		JLabel lblUsuario = new JLabel("Usuario:");
		JTextField txtUsuario = new JTextField(15);

		JLabel lblContrasena = new JLabel("Contraseña:");
		JPasswordField txtContrasena = new JPasswordField(15);

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario = txtUsuario.getText();
				String contrasena = new String(txtContrasena.getPassword());

				try {
					if (almacenamientoUsuario.iniciarSesion(nombreUsuario, contrasena)) {
						JOptionPane.showMessageDialog(null, "¡Inicio de sesión exitoso para el usuario " + nombreUsuario + "!");
						frameInicioSesion.dispose();
						// Puedes realizar otras acciones después de un inicio de sesión exitoso
					} else {
						JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos. Inicio de sesión fallido.");
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al intentar iniciar sesión. Por favor, inténtelo nuevamente.");
				}
			}
		});

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameInicioSesion.dispose();
				mostrarVentanaRegistro();
			}
		});

		JPanel panelInicioSesion = new JPanel(new GridLayout(0, 1));
		panelInicioSesion.add(lblUsuario);
		panelInicioSesion.add(txtUsuario);
		panelInicioSesion.add(lblContrasena);
		panelInicioSesion.add(txtContrasena);
		panelInicioSesion.add(btnIniciar);

		panelInicioSesion.add(new JLabel("¿No tienes una cuenta?"));
		panelInicioSesion.add(btnRegistrarse);

		frameInicioSesion.add(panelInicioSesion);
		frameInicioSesion.setVisible(true);
	}
	/**
	 * Muestra una ventana para el registro de un nuevo usuario.
	 */
	private void mostrarVentanaRegistro() {
		JFrame frameRegistro = new JFrame("Registro de Usuario");
		frameRegistro.setSize(300, 200);

		JLabel lblUsuario = new JLabel("Nuevo Usuario:");
		JTextField txtUsuario = new JTextField(15);

		JLabel lblContrasena = new JLabel("Contraseña:");
		JPasswordField txtContrasena = new JPasswordField(15);

		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario = txtUsuario.getText();
				String contrasena = new String(txtContrasena.getPassword());

				if (!nombreUsuario.isEmpty() && !contrasena.isEmpty()) {
					registrarUsuario(nombreUsuario, contrasena);
					frameRegistro.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre de usuario y contraseña válidos.");
				}
			}
		});

		JPanel panelRegistro = new JPanel(new GridLayout(0, 1));
		panelRegistro.add(lblUsuario);
		panelRegistro.add(txtUsuario);
		panelRegistro.add(lblContrasena);
		panelRegistro.add(txtContrasena);
		panelRegistro.add(btnRegistrar);

		frameRegistro.add(panelRegistro);
		frameRegistro.setVisible(true);
	}

	/**
	 * Registra un nuevo usuario con el nombre de usuario y contraseña dados.
	 *
	 * @param nombreUsuario El nombre de usuario a registrar.
	 * @param contrasena    La contraseña del nuevo usuario.
	 */
	private void registrarUsuario(String usuario, String contrasena) {
		Usuario nuevoUsuario = new Usuario(usuario, contrasena);
		try {
			almacenamientoUsuario.registroUsuario(nuevoUsuario);
			JOptionPane.showMessageDialog(null, "Registro exitoso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al registrar el usuario. Por favor, inténtelo nuevamente.");
			e.printStackTrace();
		}
	}

	/**
	 * Muestra una ventana con el contenido del carrito de compras.
	 */
	private void mostrarVentanaCarrito() {
		JFrame ventanaCarrito = new JFrame("Carrito de Compra");
		ventanaCarrito.setSize(400, 300);
		ventanaCarrito.setLayout(new BorderLayout());

		JPanel panelProductos = new JPanel();
		panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));

		// Mostrar los productos del carrito directamente en la ventana emergente
		for (Producto producto : productosEnCarrito) {
			// Etiqueta para mostrar el nombre y la cantidad del producto
			JLabel lblProducto = new JLabel(producto.getNombre() + " - Cantidad: " + producto.getCantidadEnStock());

			// Panel para organizar la etiqueta del producto y los botones de añadir y eliminar
			JPanel panelProducto = new JPanel(new BorderLayout());
			panelProducto.add(lblProducto, BorderLayout.CENTER);

			// Botón para decrementar la cantidad del producto en el carrito
			JButton btnEliminar = new JButton("-");
			btnEliminar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					quitarDelCarrito(producto);
					ventanaCarrito.dispose();
					mostrarVentanaCarrito();
				}
			});
			panelProducto.add(btnEliminar, BorderLayout.EAST);

			panelProductos.add(panelProducto);
		}

		// Botón de compra en la parte inferior
		JButton btnRealizarCompra = new JButton("Realizar Compra");
		btnRealizarCompra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lógica para realizar la compra con los productos en el carrito
				realizarCompra();
				ventanaCarrito.dispose();
			}
		});
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBotones.add(btnRealizarCompra);

		ventanaCarrito.add(panelBotones, BorderLayout.SOUTH);
		ventanaCarrito.add(panelProductos, BorderLayout.CENTER);
		ventanaCarrito.setVisible(true);
	}

	/**
	 * Busca un producto utilizando una palabra clave y muestra los resultados en una ventana.
	 *
	 * @param palabraClave La palabra clave para buscar un producto.
	 */
	public void buscarProducto(String palabraClave) {
		List<Producto> productosEncontrados = new ArrayList<>();

		for (Producto producto : listaProductos) {
			if (producto.buscarPorPalabra(palabraClave)) {
				productosEncontrados.add(producto);
			}
		}

		if (!productosEncontrados.isEmpty()) {
			mostrarResultadosBusqueda(productosEncontrados);
		} else {
			JOptionPane.showMessageDialog(null, "No hay productos que coincidan con la palabra clave: " + palabraClave);
		}
	}

	/**
	 * Muestra una ventana con los resultados de la búsqueda.
	 *
	 * @param productosEncontrados La lista de productos encontrados.
	 */
	private void mostrarResultadosBusqueda(List<Producto> productosEncontrados) {
		JFrame ventanaResultados = new JFrame("Resultados de Búsqueda");
		ventanaResultados.setSize(400, 300);
		ventanaResultados.setLayout(new BoxLayout(ventanaResultados.getContentPane(), BoxLayout.Y_AXIS));

		JLabel lblTitulo = new JLabel("Resultados de Búsqueda:");
		ventanaResultados.add(lblTitulo);

		for (Producto producto : productosEncontrados) {
			JButton btnProducto = new JButton(producto.getNombre());
			btnProducto.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mostrarDetallesProducto(producto);
				}
			});
			ventanaResultados.add(btnProducto);
		}

		ventanaResultados.setVisible(true);
	}

	/**
	 * Muestra una ventana con los detalles del producto.
	 *
	 * @param producto El producto del cual se mostrarán los detalles.
	 */
	private void mostrarDetallesProducto(Producto producto) {
		JFrame ventanaDetalles = new JFrame("Detalles del Producto");
		ventanaDetalles.setSize(400, 300);
		ventanaDetalles.setLayout(new BorderLayout());

		// Panel para mostrar la información del producto
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(new BoxLayout(panelInformacion, BoxLayout.Y_AXIS));

		JLabel lblNombre = new JLabel("Nombre: " + producto.getNombre());
		JLabel lblPrecio = new JLabel("Precio: $" + producto.getPrecio());
		JLabel lblStock = new JLabel("Stock: " + producto.getCantidadEnStock());
		JLabel lblDescripcion = new JLabel("Descripción: " + producto.getDescripcion());

		panelInformacion.add(lblNombre);
		panelInformacion.add(lblPrecio);
		panelInformacion.add(lblStock);
		panelInformacion.add(lblDescripcion);

		ventanaDetalles.add(panelInformacion, BorderLayout.CENTER);

		// Panel para los botones de compra y agregar al carrito
		JPanel panelBotones = new JPanel(new FlowLayout());

		JButton btnCompra = new JButton("Comprar");
		btnCompra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (usuarioSesion != null) {
					realizarCompra();
					ventanaDetalles.dispose();
					JOptionPane.showMessageDialog(null, "Compra realizada: " + producto.getNombre());
				} else {
					JOptionPane.showMessageDialog(null, "Debe iniciar sesión para realizar la compra.");
				}
			}
		});

		JButton btnAgregarCarrito = new JButton("Agregar al Carrito");
		btnAgregarCarrito.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarAlCarrito(producto);
			}
		});

		panelBotones.add(btnCompra);
		panelBotones.add(btnAgregarCarrito);

		ventanaDetalles.add(panelBotones, BorderLayout.SOUTH);

		ventanaDetalles.setVisible(true);
	}

	/**
	 * Agrega un producto al carrito.
	 *
	 * @param producto El producto a agregar al carrito.
	 */
	private void agregarAlCarrito(Producto producto) {
		// Agregar el producto a la lista de productos en el carrito
		productosEnCarrito.add(producto);
		JOptionPane.showMessageDialog(null, "Producto añadido al carrito: " + producto.getNombre());
	}

	/**
	 * Quita un producto del carrito.
	 *
	 * @param producto El producto a quitar del carrito.
	 */
	private void quitarDelCarrito(Producto producto) {
		productosEnCarrito.remove(producto);
		JOptionPane.showMessageDialog(null, "Producto eliminado del carrito: " + producto.getNombre());
	}

	/**
	 * Método para realizar la compra utilizando el carrito de compras y un método de pago.
	 */
	private void realizarCompra() {
		// Verifica si hay un usuario en sesión
		if (usuarioSesion == null) {
			JOptionPane.showMessageDialog(null, "Debe iniciar sesión para realizar la compra.");
			return;
		}

		// Verifica si hay productos en el carrito
		if (productosEnCarrito.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El carrito de compras está vacío. Agregue productos antes de comprar.");
			return;
		}

		// Pide al usuario seleccionar un método de pago
		String[] opcionesPago = {"Tarjeta de Crédito"};
		String metodoPagoSeleccionado = (String) JOptionPane.showInputDialog(
				null,
				"Seleccione un método de pago:",
				"Método de Pago",
				JOptionPane.QUESTION_MESSAGE,
				null,
				opcionesPago,
				opcionesPago[0]);

		// Procesa el pago según el método seleccionado
		Pago metodoPago;
		switch (metodoPagoSeleccionado) {
		case "Tarjeta de Crédito":
			metodoPago = obtenerDatosPagoTarjeta(); 
			break;

		default:
			JOptionPane.showMessageDialog(null, "Método de pago no válido.");
			return;
		}

		// Completa la compra utilizando el carrito y el método de pago seleccionado
		Compra compra = new Compra();
		compra.completarCompra(new carritoCompra(), metodoPago);

		// Limpia el carrito después de la compra
		productosEnCarrito.clear();

		// Muestra un mensaje indicando que la compra fue exitosa
		JOptionPane.showMessageDialog(null, "Compra realizada exitosamente.");
	}

	/**
	 * Método para obtener los datos de la tarjeta de crédito.
	 *
	 * @return Una instancia de pagoTarjeta con los datos de la tarjeta.
	 */
	private Pago obtenerDatosPagoTarjeta() {
		// Pide al usuario ingresar los datos de la tarjeta
		String numeroTarjeta = JOptionPane.showInputDialog("Ingrese el número de la tarjeta de crédito:");
		String fechaVencimiento = JOptionPane.showInputDialog("Ingrese la fecha de vencimiento (MM/YY):");
		String codigoSeguridadStr = JOptionPane.showInputDialog("Ingrese el código de seguridad:");

		int codigoSeguridad = 0;
		try {
			codigoSeguridad = Integer.parseInt(codigoSeguridadStr);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error: El código de seguridad debe ser un número entero.");
		}

		return new pagoTarjeta(numeroTarjeta, fechaVencimiento, codigoSeguridad);
	}


}
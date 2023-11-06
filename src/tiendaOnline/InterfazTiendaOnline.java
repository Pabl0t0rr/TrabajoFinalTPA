package tiendaOnline;

//Importaciones de las librerías de Swing y AWT
import javax.swing.BorderFactory;
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
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase InterfazTiendaOnline representa la interfaz de la tienda online.
 */
public class InterfazTiendaOnline extends JFrame {

	// Declaraciones de variables y componentes de la interfaz
	private Usuario usuarioSesion;
	//private JPanel panelCatalogo;
	private JPanel panelCarrito;
	private JLabel lblCarrito;
	private List<Producto> listaProductos;

	 /**
     * Constructor de la interfaz de la tienda online.
     */
	public InterfazTiendaOnline() {
		
		listaProductos = new ArrayList<>();
		
		//Productos Tienda
		Producto pcPremontado = new Producto("PC Gaming", 1200.0 ,9 , "Potente PC para juegos");
        Producto cpu = new Producto("Procesador Intel Core i7", 300.0 ,10 , "Procesador potente para rendimiento");
        listaProductos.add(pcPremontado);
        listaProductos.add(cpu);
        
		setTitle("www.Computer-tech.com");
		setSize(600, 400);
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

		panelCarrito = new JPanel();
		add(panelCarrito, BorderLayout.EAST);

		setVisible(true);
	}

	 /**
     * Muestra un menú emergente en la posición dada.
     *
     * @param comp El componente asociado al menú.
     * @param pos  La posición en la pantalla donde se mostrará el menú.
     */
	private void mostrarMenu(Component comp, Point pos) {
		JPopupMenu menu = new JPopupMenu();

		JMenuItem itemInicioSesion = new JMenuItem("Iniciar Sesión");
		itemInicioSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaInicioSesion();
			}
		});
		menu.add(itemInicioSesion);

		JMenuItem itemRegistrarse = new JMenuItem("Registrarse");
		itemRegistrarse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaRegistro();
			}
		});
		menu.add(itemRegistrarse);

		JMenuItem itemCarrito = new JMenuItem("Ver Carrito");
		itemCarrito.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarCarrito();
			}
		});
		menu.add(itemCarrito);

		menu.show(comp, pos.x, pos.y - menu.getHeight());
	}

	/**
     * Muestra un menú emergente en una posición específica.
     *
     * @param pos La posición en la pantalla donde se mostrará el menú.
     */
	private void mostrarMenu(Point pos) {
		JPopupMenu menu = new JPopupMenu();

		JMenuItem itemInicioSesion = new JMenuItem("Iniciar Sesión");
		itemInicioSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaInicioSesion();
			}
		});
		menu.add(itemInicioSesion);

		JMenuItem itemRegistrarse = new JMenuItem("Registrarse");
		itemRegistrarse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaRegistro();
			}
		});
		menu.add(itemRegistrarse);

		JMenuItem itemVerCarrito = new JMenuItem("Ver Carrito");
		itemVerCarrito.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
				usuarioSesion = almacenamientoUsuario.buscarUsuario(nombreUsuario);

				if (usuarioSesion != null && usuarioSesion.getContrasena().equals(contrasena)) {
					JOptionPane.showMessageDialog(null, "¡Inicio de sesión exitoso para el usuario " + nombreUsuario + "!");
					// Lógica para mostrar catálogo, etc.
					frameInicioSesion.dispose();
					mostrarCatalogo(); // Método a implementar
				} else {
					JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos. Inicio de sesión fallido.");
				}
			}
		});

		JPanel panelInicioSesion = new JPanel(new GridLayout(0, 1));
		panelInicioSesion.add(lblUsuario);
		panelInicioSesion.add(txtUsuario);
		panelInicioSesion.add(lblContrasena);
		panelInicioSesion.add(txtContrasena);
		panelInicioSesion.add(btnIniciar);

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
	private void registrarUsuario(String nombreUsuario, String contrasena) {
		Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena);
		almacenamientoUsuario.agregarUsuario(nuevoUsuario);
		JOptionPane.showMessageDialog(null, "¡Usuario registrado exitosamente!");
	}

	/**
     * Muestra el catálogo de productos en la interfaz.
     */
	private void mostrarCatalogo() {
		// Lógica para mostrar los productos en el catálogo
		// Puedes usar botones u otros componentes para que el usuario pueda interactuar con los productos
	}

	/**
     * Muestra los elementos en el carrito de compras.
     */
	private void mostrarCarrito() {
		panelCarrito.removeAll(); // Limpia el panel antes de mostrar los elementos del carrito
		panelCarrito.setLayout(new BoxLayout(panelCarrito, BoxLayout.Y_AXIS));

		lblCarrito = new JLabel("Elementos en el carrito:");
		panelCarrito.add(lblCarrito);

		// Agrega aquí la lógica para mostrar los elementos del carrito
		// por ejemplo, iterar sobre los elementos del carrito y mostrarlos en el panelCarrito

		// Por ahora, añadimos un ejemplo estático de producto en el carrito
		JLabel producto1 = new JLabel("Producto 1");
		JLabel producto2 = new JLabel("Producto 2");
		panelCarrito.add(producto1);
		panelCarrito.add(producto2);

		// ...

		panelCarrito.revalidate(); // Actualiza el panel para mostrar los cambios
		panelCarrito.repaint();
	}

	/**
     * Muestra una ventana con el contenido del carrito de compras.
     */
	private void mostrarVentanaCarrito() {
		JFrame ventanaCarrito = new JFrame("Carrito de Compras");
		ventanaCarrito.setSize(300, 300);
		ventanaCarrito.setLocationRelativeTo(null);
		ventanaCarrito.setLayout(new BorderLayout());

		JPanel panelProductos = new JPanel();
		// Aquí deberías añadir lógica para mostrar los productos del carrito en panelProductos

		ventanaCarrito.add(panelProductos, BorderLayout.CENTER);
		ventanaCarrito.setVisible(true);
	}

	/**
     * Busca un producto utilizando una palabra clave.
     *
     * @param palabraClave La palabra clave para buscar un producto.
     */
	public void buscarProducto(String palabraClave) {
		boolean encontrado = false;

		for (Producto producto : listaProductos) {
			if (producto.buscarPorPalabra(palabraClave)) {
				producto.mostrarInformacion();
				encontrado = true;
			}
		}

		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "No hay productos que coincidan con la palabra clave: " + palabraClave);
		}
	}
}

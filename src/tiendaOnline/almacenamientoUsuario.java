package tiendaOnline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * La clase almacenamientoUsuario gestiona el almacenamiento y recuperación de usuarios en la tienda online.
 */
public class almacenamientoUsuario implements Serializable {
	
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    /**
     * Constructor por defecto de almacenamientoUsuario.
     */
    public almacenamientoUsuario() {
        listaUsuarios = new ArrayList<>();
    }

    /**
     * Obtiene la lista de usuarios almacenados.
     *
     * @return La lista de usuarios almacenados.
     */
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * Establece la lista de usuarios.
     *
     * @param usuarios La lista de usuarios a establecer.
     */
    public void setListaUsuarios(List<Usuario> usuarios) {
        listaUsuarios = usuarios;
    }

    /**
     * Agrega un usuario a la lista de usuarios.
     *
     * @param usuario El usuario a agregar.
     */
    public synchronized static void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param nombreUsuario El nombre del usuario a buscar.
     * @return El usuario si se encuentra, de lo contrario, retorna null.
     */
    public static synchronized Usuario buscarUsuario(String nombreUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null; // Si no se encuentra el usuario
    }
    
    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param usuario El usuario a registrar.
     * @throws SQLException Si hay un error en la ejecución de la consulta SQL.
     */
    public static void registroUsuario(Usuario usuario) throws SQLException {
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {
            Conexion gestorConexion = new Conexion();
            conexion = gestorConexion.conectar();

            // Preparar la consulta SQL para insertar un nuevo usuario
            String sql = "INSERT INTO usuario (usuario, clave) VALUES (?, ?)";
            pstmt = conexion.prepareStatement(sql);

            // Establecer los valores de los parámetros en la consulta
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getContrasena());

            // Ejecutar la consulta
            pstmt.executeUpdate();

            System.out.println("Usuario registrado exitosamente.");
        } finally {
            // Cerrar recursos
            if (pstmt != null) {
                pstmt.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

}
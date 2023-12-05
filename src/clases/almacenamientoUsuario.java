/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author pablo
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase almacenamientoUsuario gestiona el almacenamiento y recuperación de usuarios en la tienda online.
 */
public class almacenamientoUsuario {
	
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
     * Verifica las credenciales para iniciar sesión.
     *
     * @param nombreUsuario El nombre de usuario.
     * @param contrasena    La contraseña.
     * @return True si las credenciales son válidas, False en caso contrario.
     * @throws SQLException Si hay un error en la consulta SQL.
     */
    public static boolean iniciarSesion(String nombreUsuario, String contrasena) throws SQLException {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Conexion gestorConexion = new Conexion();
            conexion = gestorConexion.conectar();

            String sql = "SELECT * FROM usuario WHERE usuario = ? AND clave = ?";
            pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, contrasena);

            rs = pstmt.executeQuery();

            return rs.next();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public static boolean registrarUsuario(String nombreUsuario, String contrasena) {
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {
            Conexion gestorConexion = new Conexion();
            conexion = gestorConexion.conectar();

            String sql = "INSERT INTO usuario (usuario, clave) VALUES (?, ?)";
            pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, contrasena);

            int filasAfectadas = pstmt.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
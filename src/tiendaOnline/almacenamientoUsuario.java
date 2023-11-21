package tiendaOnline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
}
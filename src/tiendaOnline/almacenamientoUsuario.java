package tiendaOnline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class almacenamientoUsuario implements Serializable {
	private static List<Usuario> listaUsuarios = new ArrayList<>();


    public almacenamientoUsuario() {
        listaUsuarios = new ArrayList<>();
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> usuarios) {
        listaUsuarios = usuarios;
    }
    
    public synchronized static void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public static synchronized Usuario buscarUsuario(String nombreUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null; // Si no se encuentra el usuario
    }
}

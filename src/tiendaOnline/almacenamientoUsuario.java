package tiendaOnline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class almacenamientoUsuario implements Serializable {
    private List<Usuario> listaUsuarios;

    public almacenamientoUsuario() {
        listaUsuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public Usuario buscarUsuario(String nombreUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null; // Si no se encuentra el usuario
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> usuarios) {
        listaUsuarios = usuarios;
    }
}

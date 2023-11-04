package tiendaOnline;

public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    // Puedes agregar más atributos como nombre, dirección, etc.

    // Constructor
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
    	return contrasena;
    }
    
    public void setContrasena(String contrasena) {
    	this.contrasena = contrasena;
    }
    // Otros métodos relevantes para la gestión del usuario
}

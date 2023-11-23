import java.io.Serializable;

public class Usuario implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String contraseña;

    // Builder
    public Usuario(int id, String nombre, String apellido, String correoElectronico, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    @Override
public String toString() {
    return "Usuario: \n" +
            "id = " + id  +
            ", nombre = '" + nombre + '\'' +
            ", apellido = '" + apellido + '\'' +
            ", correoElectronico = '" + correoElectronico + '\'' +
            ", contrasena = '" + contraseña + '\'' +
            '}';
}

}

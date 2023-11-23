import java.util.List;

// Define the UsuarioDAO interface
public interface UsuarioDAO {
    void crearUsuario(Usuario usuario);

    Usuario obtenerUsuarioPorId(int id);

    List<Usuario> obtenerTodosLosUsuarios();

    void actualizarUsuario(Usuario usuario);

    void eliminarUsuario(int id);
}

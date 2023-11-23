import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOArchivo implements UsuarioDAO {

    // Nombre del archivo donde se almacenarán los datos de los usuarios
    private static final String ARCHIVO_USUARIOS = "usuarios.dat";

    // Método para crear un nuevo usuario
    @Override
public void crearUsuario(Usuario usuario) {
    // Obtener la lista actual de usuarios desde el archivo
    List<Usuario> usuarios = leerUsuariosDesdeArchivo();
    
    // Verificar si el usuario ya existe en la lista
    if (!usuarios.contains(usuario)) {
        // Agregar el nuevo usuario a la lista
        usuarios.add(usuario);
        
        // Escribir la lista actualizada de usuarios en el archivo
        escribirUsuariosEnArchivo(usuarios);
    } else {
        System.out.println("El usuario ya existe.");
    }
}

    // Método para obtener un usuario por su ID
    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        // Obtener la lista actual de usuarios desde el archivo
        List<Usuario> usuarios = leerUsuariosDesdeArchivo();
        // Iterar sobre la lista para encontrar el usuario con el ID dado
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        // Devolver null si no se encuentra el usuario con el ID dado
        return null;
    }

    // Método para obtener todos los usuarios
    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        // Obtener la lista actual de usuarios desde el archivo
        return leerUsuariosDesdeArchivo();
    }

    // Método para actualizar la información de un usuario
    @Override
    public void actualizarUsuario(Usuario usuarioActualizado) {
        // Obtener la lista actual de usuarios desde el archivo
        List<Usuario> usuarios = leerUsuariosDesdeArchivo();
        // Iterar sobre la lista para encontrar y actualizar el usuario con el mismo ID
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuarioActualizado.getId()) {
                usuarios.set(i, usuarioActualizado);
                // Escribir la lista actualizada de usuarios en el archivo
                escribirUsuariosEnArchivo(usuarios);
                return;
            }
        }
    }

    // Método para eliminar un usuario por su ID
    @Override
    public void eliminarUsuario(int id) {
        // Obtener la lista actual de usuarios desde el archivo
        List<Usuario> usuarios = leerUsuariosDesdeArchivo();
        // Eliminar el usuario con el ID dado de la lista
        usuarios.removeIf(usuario -> usuario.getId() == id);
        // Escribir la lista actualizada de usuarios en el archivo
        escribirUsuariosEnArchivo(usuarios);
    }

    // Método privado para leer la lista de usuarios desde el archivo
    private List<Usuario> leerUsuariosDesdeArchivo() {
        List<Usuario> usuarios = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_USUARIOS))) {
            // Intentar leer la lista de usuarios desde el archivo
            usuarios = (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Manejar excepciones según tus necesidades (puede que el archivo no exista inicialmente)
        }
        // Devolver la lista de usuarios, que puede estar vacía si hay un error al leer el archivo
        return usuarios;
    }

    // Método privado para escribir la lista de usuarios en el archivo
    private void escribirUsuariosEnArchivo(List<Usuario> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            // Intentar escribir la lista de usuarios en el archivo
            oos.writeObject(usuarios);
        } catch (IOException e) {
            // Manejar excepciones según tus necesidades
        }
    }
}

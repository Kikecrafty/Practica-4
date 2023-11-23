import java.io.*;

public class Leer {

    public static void main(String[] args) {
        // Asegúrate de haber ejecutado pruebaDAOArchivo() primero para escribir datos
        // en el archivo
        pruebaDAOArchivo();

        // Nombre del archivo .dat
        String nombreArchivo = "usuarios.dat";

        // Intentar leer objetos desde el archivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            // Leemos objetos hasta que se alcance el final del archivo
            while (true) {
                try {
                    // Intentamos leer un objeto desde el archivo
                    Object objetoLeido = ois.readObject();

                    // Hacer algo con el objeto leído (en este ejemplo, simplemente imprimirlo)
                    System.out.println(objetoLeido);
                } catch (EOFException e) {
                    // Se lanza cuando se alcanza el final del archivo
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo: " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void pruebaDAOArchivo() {
        String nombreArchivo = "usuarios.dat";

        // Eliminar el archivo antes de cada ejecución
        File archivo = new File(nombreArchivo);
        if (archivo.exists() && archivo.isFile()) {
            archivo.delete();
        }
        Usuario usuario1 = new Usuario(1, "Manuel", "Rodriguez", "Manuel@gmail.com", "123");

        // Crea una instancia del DAO de archivo
        UsuarioDAO usuarioDAOArchivo = new UsuarioDAOArchivo();

        // Inserta el usuario
        usuarioDAOArchivo.crearUsuario(usuario1);
        System.out.println("Usuario creado con DAO de archivo.");

    }

}
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Instancia la interfaz de usuario
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InterfazUsuario interfaz = new InterfazUsuario();
                interfaz.setVisible(true);
            }
        });

        // Realiza algunas operaciones de prueba con ambas implementaciones de DAO
        pruebaDAOArchivo();
        pruebaDAOMySQL();
    }

    private static void pruebaDAOArchivo() {
        // Crea un usuario para la prueba
        Usuario usuario1 = new Usuario(1,"Manuel","Rodriguez","Manuel@gmail.com","123");

        // Crea una instancia del DAO de archivo
        UsuarioDAO usuarioDAOArchivo = new UsuarioDAOArchivo();

        // Inserta el usuario
        usuarioDAOArchivo.crearUsuario(usuario1);
        System.out.println("Usuario creado con DAO de archivo.");

        // Obtiene el usuario por ID
        Usuario usuarioObtenido = usuarioDAOArchivo.obtenerUsuarioPorId(1);
        if (usuarioObtenido != null) {
            System.out.println("Usuario obtenido con DAO de archivo: " + usuarioObtenido.getNombre());
        } else {
            System.out.println("No se pudo obtener el usuario con DAO de archivo.");
        }
    }

    private static void pruebaDAOMySQL() {
        // Crea una instancia del DAO de MySQL
        UsuarioDAOMySQL usuarioDAOMySQL = new UsuarioDAOMySQL();

        // Configura los datos de prueba
        usuarioDAOMySQL.id = "1";
        usuarioDAOMySQL.nom = "Luis";
        usuarioDAOMySQL.ap = "Enrique";
        usuarioDAOMySQL.correo = "luiscv2enrique@gmail.com";
        usuarioDAOMySQL.con = "Cv2enr";

        // Inserta el usuario
        usuarioDAOMySQL.insertar();
        System.out.println("Usuario creado con DAO de MySQL.");

        // Obtiene y muestra el usuario seleccionado
        usuarioDAOMySQL.id = "2";
        usuarioDAOMySQL.selecreg();
        System.out.println("Usuario obtenido con DAO de MySQL: " +
                usuarioDAOMySQL.nom + " " +
                usuarioDAOMySQL.ap + " " +
                usuarioDAOMySQL.correo + " " +
                usuarioDAOMySQL.con);

        // Actualiza el usuario
        usuarioDAOMySQL.nom = "Luis Updated";
        usuarioDAOMySQL.actreg();
        System.out.println("Usuario actualizado con DAO de MySQL.");

        // Elimina el usuario
        usuarioDAOMySQL.elimreg();
        System.out.println("Usuario eliminado con DAO de MySQL.");
        
    }
    
}

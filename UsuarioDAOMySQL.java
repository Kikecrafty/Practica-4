import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

public class UsuarioDAOMySQL {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/usuarios";
    private static final String usr = "root";
    private static final String pass = "";

    public String id;
    public String nom;
    public String ap;
    public String correo;
    public String con;

    static {
        try {
            // Load the MySQL JDBC driver
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();
        }
    }

    // Establish a database connection
    public Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, usr, pass);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        return con;
    }

    // Insert a new user record into the database
    public void insertar() {
        try {
            Connection cn = conectar();
            String insertar = "INSERT INTO usuarios (id, nombre, apellido, CorreoElectronico, contraseña) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstm = cn.prepareStatement(insertar);
            pstm.setString(1, id);
            pstm.setString(2, nom);
            pstm.setString(3, ap);
            pstm.setString(4, correo);
            pstm.setString(5, con);

            pstm.executeUpdate();

            System.out.println("Registro insertado");
            JOptionPane.showMessageDialog(null, "Registro agregado");

            pstm.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al insertar el registro");
            e.printStackTrace();
        }
    }

    // Select a user record based on ID and update local fields
    // Select a user record based on ID and update local fields
    public void selecreg() {
        try {
            Connection cn = conectar();
            String seleccionar = "SELECT nombre, apellido, CorreoElectronico, contraseña FROM usuarios WHERE id=?";
            PreparedStatement pstm = cn.prepareStatement(seleccionar);
            pstm.setString(1, id);
    
            System.out.println("ID utilizado en la búsqueda: " + id);
    
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                nom = rs.getString("nombre");
                ap = rs.getString("apellido");
                correo = rs.getString("CorreoElectronico");
                con = rs.getString("contraseña");
                System.out.println("Registro obtenido con DAO de MySQL: " + nom + " " + ap + " " + correo + " " + con);
            } else {
                System.out.println("No se encontró el registro con DAO de MySQL.");
            }
    
            rs.close();
            pstm.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al seleccionar el registro con DAO de MySQL");
            e.printStackTrace();
        }
    }

    // Update an existing user record in the database
    public void actreg() {
        try {
            Connection cn = conectar();
            String actualizar = "UPDATE usuarios SET nombre=?, apellido=?, CorreoElectronico=?, contraseña=? WHERE id=?";
            PreparedStatement pstm = cn.prepareStatement(actualizar);
            pstm.setString(1, nom);
            pstm.setString(2, ap);
            pstm.setString(3, correo);
            pstm.setString(4, con);
            pstm.setString(5, id);

            pstm.executeUpdate();

            System.out.println("Registro actualizado");

            pstm.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar el registro");
            e.printStackTrace();
        }
    }

    // Delete a user record from the database based on ID
    public void elimreg() {
        try {
            Connection cn = conectar();
            String eliminar = "DELETE FROM usuarios WHERE id=?";
            PreparedStatement pstm = cn.prepareStatement(eliminar);
            pstm.setString(1, id);

            pstm.executeUpdate();

            System.out.println("Registro eliminado");

            pstm.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar el registro");
            e.printStackTrace();
        }
    }

    // Methods for UserDAO interface (placeholders, not implemented)
    public void crearUsuario(Usuario usuario1) {
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return null;
    }

    public void actualizarUsuario(Usuario usuario1) {
    }

    public void eliminarUsuario(int i) {
    }

}
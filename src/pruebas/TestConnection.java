package pruebas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10722424"; 
        String user = "sql10722424";
        String password = "WrcA5TYj69";

        try {
            // Carga el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establece la conexión
            Connection connection = DriverManager.getConnection(url, user, password);
            
            if (connection != null) {
                System.out.println("Conexión establecida exitosamente.");
            } else {
                System.out.println("Error al establecer la conexión.");
            }
            
            // Cierra la conexión
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
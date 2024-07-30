import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import controlador.ClienteController;
import modelo.ClienteDAO;
import vista.ClienteView;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10722424", "sql10722424", "WrcA5TYj69");
            ClienteDAO modelo = new ClienteDAO(connection);
            ClienteView vista = new ClienteView();
            ClienteController controlador = new ClienteController(vista, modelo);
            vista.setVisible(true);

            // Finaliza la conexión al cerrar la ventana
            vista.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    modelo.cerrarConexion();
                }
            });
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

//Comandos Power Shell para compilar y ejecutar
//javac -cp "lib/mysql-connector-j-9.0.0.jar" -d bin src\controlador\*.java src\modelo\*.java src\vista\*.java src\Main.java src\pruebas\TestConnection.java
//java -cp "lib/mysql-connector-j-9.0.0.jar;bin" Main
//java -cp "bin;lib/mysql-connector-j-9.0.0.jar" pruebas.TestConnection

//Pendientes
//Documentar código
//Contextualizar código
//Generar documento de word
//Mejorar aplicativo
//Subir a github
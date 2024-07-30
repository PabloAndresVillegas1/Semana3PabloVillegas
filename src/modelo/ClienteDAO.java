package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Cliente> obtenerClientesPorCargo(String cargo) {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Cliente WHERE cargo = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cargo);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("cargo"),
                    resultSet.getString("email")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return clientes;
    }
    
    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
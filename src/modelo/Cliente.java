package modelo;

public class Cliente {
    private int id;
    private String nombre;
    private String cargo;
    private String email;

    // Constructor
    public Cliente(int id, String nombre, String cargo, String email) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.email = email;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
package controlador;

import modelo.ClienteDAO;
import vista.ClienteView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClienteController {
    private ClienteView vista;
    private ClienteDAO modelo;

    public ClienteController(ClienteView vista, ClienteDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.addConsultarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarClientes();
            }
        });

        this.vista.addWordButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirArchivoWord();
            }
        });
    }

    private void consultarClientes() {
        String cargo = vista.getCargo();
        List<modelo.Cliente> clientes = modelo.obtenerClientesPorCargo(cargo);
        vista.mostrarResultados(clientes);
    }

    private void abrirArchivoWord() {
        String url = "https://uniminuto0-my.sharepoint.com/:w:/g/personal/pablo_villegas-m_uniminuto_edu_co/ETEyAujkb29ArrlZKIz5AusBtwhuoAt7POwCrW6ro5COBA?e=wksOvq";
        vista.abrirArchivoWord(url);
    }
}
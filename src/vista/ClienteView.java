package vista;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelo.Cliente;

public class ClienteView extends JFrame {
    private JTextField cargoField;
    private JTextArea resultArea;
    private JButton consultarButton;
    private JButton wordButton;

    public ClienteView() {
        setTitle("Consulta de clientes supermercado UNIMINUTO");
        setSize(500, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cargoField = new JTextField(20);
        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        consultarButton = new JButton("Consultar");
        wordButton = new JButton("Abrir archivo de Word");

        // Mensaje de bienvenida
        String welcomeMessage = "<html><div style='text-align: center;'>************** Bienvenido al aplicativo de consulta de usuarios por cargo **************</div><br/>"
                + "Digita cualquiera de los siguientes cargos:<br/><br/>"
                + "Administrador<br/>"
                + "Cajero<br/>"
                + "Auxiliar</html>";
        JLabel welcomeLabel = new JLabel(welcomeMessage);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Cargo:"));
        inputPanel.add(cargoField);
        inputPanel.add(consultarButton);
        inputPanel.add(wordButton);

        panel.add(welcomeLabel, BorderLayout.NORTH);
        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        add(panel);
    }

    public String getCargo() {
        return cargoField.getText();
    }

    public void mostrarResultados(List<Cliente> clientes) {
        resultArea.setText("");
        for (Cliente cliente : clientes) {
            resultArea.append(cliente.getNombre() + " - " + cliente.getCargo() + " - " + cliente.getEmail() + "\n");
        }
    }

    public void addConsultarListener(ActionListener listener) {
        consultarButton.addActionListener(listener);
    }

    public void addWordButtonListener(ActionListener listener) {
        wordButton.addActionListener(listener);
    }

    public void abrirArchivoWord(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.client.*;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

public class CajeroForm extends JFrame {
    private JPanel panel;
    private JLabel bienvenida;
    private JLabel usercajero;
    private JLabel contraseniacajero;
    private JTextField textFieldusser;
    private JTextField textField2contrasenia;
    private JButton ingresarButton;

    public CajeroForm() {
        setTitle("Cajero Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(new Color(137, 172, 118));
        bienvenida = new JLabel("Bienvenido Cajero");
        usercajero = new JLabel("Usuario Cajero:");
        textFieldusser = new JTextField(20);
        contraseniacajero = new JLabel("Contraseña Cajero:");
        textField2contrasenia = new JPasswordField(20);
        ingresarButton = new JButton("Ingresar");

        panel.add(bienvenida);
        panel.add(usercajero);
        panel.add(textFieldusser);
        panel.add(contraseniacajero);
        panel.add(textField2contrasenia);
        panel.add(ingresarButton);

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldusser.getText();
                String contrasena = new String(((JPasswordField) textField2contrasenia).getPassword());

                if (verificarCredenciales(usuario, contrasena)) {
                    FormCajero formCajero = new FormCajero();
                    formCajero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    formCajero.setSize(600, 440);
                    formCajero.setLocationRelativeTo(null);
                    formCajero.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(CajeroForm.this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel);
    }

    private boolean verificarCredenciales(String usuario, String contrasena) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("ZapatoMart");
            MongoCollection<Document> collection = database.getCollection("Cajeros");

            Document cajero = collection.find(eq("usuario", usuario)).first();
            if (cajero != null) {
                String hashedPassword = cajero.getString("contrasenia");
                return HashClave.verifyHash(contrasena, hashedPassword);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CajeroForm().setVisible(true);
            }
        });
    }
}
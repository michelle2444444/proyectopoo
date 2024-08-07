import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAdminForm extends JFrame {
    private JPanel mainPanel2;
    private JTextField userAdmin;
    private JPasswordField passAdmin;
    private JButton ingresarButton;
    private JButton salirButton;

    public LoginAdminForm() {
        setTitle("Inicio de sesión para Administradores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200); // Tamaño inicial del formulario
        setLocationRelativeTo(null);

        mainPanel2 = new JPanel();
        mainPanel2.setLayout(new GridLayout(4, 1, 10, 8)); // Usando GridLayout para organizar los componentes
        mainPanel2.setBackground(new Color(229, 222, 137));
        userAdmin = new JTextField();
        passAdmin = new JPasswordField();
        ingresarButton = new JButton("Ingresar");
        salirButton = new JButton("Salir");

        mainPanel2.add(new JLabel("Usuario Admin:"));
        mainPanel2.add(userAdmin);
        mainPanel2.add(new JLabel("Contraseña Admin:"));
        mainPanel2.add(passAdmin);
        mainPanel2.add(ingresarButton);
        mainPanel2.add(salirButton);

        add(mainPanel2);

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userAdmin.getText();
                String pass = new String(passAdmin.getPassword());

                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("ZapatoMart");
                    MongoCollection<Document> usuarios = database.getCollection("Administrador");

                    Document query = new Document("Usuario", user)
                            .append("Contrasenia", pass);
                    Document result = usuarios.find(query).first();

                    if (result != null) {
                        JOptionPane.showMessageDialog(mainPanel2, "Éxito, credenciales correctas", "Información", JOptionPane.INFORMATION_MESSAGE);
                        FormAdmin adminForm = new FormAdmin();
                        adminForm.setSize(700, 440);
                        adminForm.setLocationRelativeTo(null);
                        adminForm.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(mainPanel2, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(mainPanel2, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm loginForm = new LoginForm();
                loginForm.setSize(300, 150);
                loginForm.setLocationRelativeTo(null);
                loginForm.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginAdminForm().setVisible(true);
        });
    }
}

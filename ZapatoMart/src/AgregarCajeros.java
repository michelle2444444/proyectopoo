import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AgregarCajeros extends JFrame {
    private JTextField CIingreso;
    private JTextField nomingreso;
    private JTextField apelingreso;
    private JTextField edadingreso;
    private JTextField correoingreso;
    private JTextField rolingreso;
    private JButton ButtonIngreso;
    private JButton ButtonRegreso;
    private JPanel AgregarPanel;

    private List<Cajero> cajeroList = new ArrayList<>();

    public AgregarCajeros() {
        setTitle("Agregar Cajeros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(AgregarPanel);
        setSize(new Dimension(600, 350));
        setLocationRelativeTo(null);
        setVisible(true);

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("Usuarios");
        MongoCollection<Document> cajerosCollection = database.getCollection("Cajeros");

        ButtonIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = nomingreso.getText() + apelingreso.getText() + "Xpress";
                String contrasenia = CIingreso.getText() + "AutoParts";
                String contraseniaH = HashClave.hashPassword(contrasenia);
                String cedula = CIingreso.getText();
                String nombre = nomingreso.getText();
                String apellido = apelingreso.getText();
                String edad = edadingreso.getText();
                String correo = correoingreso.getText();
                String rol = rolingreso.getText();

                System.out.println("Usuario: " + usuario);
                System.out.println("Contraseña (hash): " + contraseniaH);
                System.out.println("Cédula: " + cedula);
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Edad: " + edad);
                System.out.println("Correo: " + correo);
                System.out.println("Rol: " + rol);

                Cajero cajero = new Cajero(usuario, contraseniaH, cedula, nombre, apellido, edad, correo, rol, ""); // Asignar un valor vacío a ingresoCajero
                if (!isCajeroEmpty(cajero)) {
                    cajeroList.add(cajero);
                    Document cajeroDoc = cajero.toDocument();
                    cajerosCollection.insertOne(cajeroDoc);
                    JOptionPane.showMessageDialog(null, "Cajero Ingresado", null, JOptionPane.INFORMATION_MESSAGE);

                    // Clear input fields
                    CIingreso.setText("");
                    nomingreso.setText("");
                    apelingreso.setText("");
                    edadingreso.setText("");
                    correoingreso.setText("");
                    rolingreso.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "El formulario está vacío", null, JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        ButtonRegreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormAdmin adminform = new FormAdmin();
                adminform.setSize(new Dimension(700, 440));
                adminform.setLocationRelativeTo(null);
                adminform.setVisible(true);
                dispose();
            }
        });
    }

    private boolean isCajeroEmpty(Cajero cajero) {
        return (cajero.getUsuarioCajero() == null || cajero.getUsuarioCajero().isEmpty()) ||
                (cajero.getContraseniaCajero() == null || cajero.getContraseniaCajero().isEmpty()) ||
                (cajero.getCedulaCajero() == null || cajero.getCedulaCajero().isEmpty()) ||
                (cajero.getNombreCajero() == null || cajero.getNombreCajero().isEmpty()) ||
                (cajero.getApellidoCajero() == null || cajero.getApellidoCajero().isEmpty()) ||
                (cajero.getEdadCajero() == null || cajero.getEdadCajero().isEmpty()) ||
                (cajero.getCorreoCajero() == null || cajero.getCorreoCajero().isEmpty()) ||
                (cajero.getRolCajero() == null || cajero.getRolCajero().isEmpty());
    }

    public static void main(String[] args) {
        new AgregarCajeros();
    }
}

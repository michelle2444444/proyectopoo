import javax.swing.*;

public class CajeroForm extends JFrame {
    private JPanel panel;
    private JLabel bienvenida;
    private JLabel usercajero;
    private JLabel contraseniacajero;
    private JTextField textFieldusser;
    private JTextField textField2contrasenia;

    public CajeroForm() {
        setTitle("Cajero Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        bienvenida = new JLabel("Bienvenido Cajero");
        usercajero = new JLabel("Usuario Cajero:");
        textFieldusser = new JTextField(20);
        contraseniacajero = new JLabel("Contraseña Cajero:");
        textField2contrasenia = new JTextField(20);

        panel.add(bienvenida);
        panel.add(usercajero);
        panel.add(textFieldusser);
        panel.add(contraseniacajero);
        panel.add(textField2contrasenia);

        add(panel);
    }
}

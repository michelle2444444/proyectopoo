import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JPanel mainPanel;
    private JButton buttonIngresarAdmin;
    private JButton buttonIngresarCajero;
    private JLabel text1;

    public LoginForm() {
        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 10, 10));
        mainPanel.setBackground(new Color(229, 222, 137));

        text1 = new JLabel("ZapatoMart - Sistema de Gestión", SwingConstants.CENTER);
        text1.setPreferredSize(new Dimension(200, 30));

        buttonIngresarAdmin = new JButton("Ingresar Admin");
        buttonIngresarAdmin.setPreferredSize(new Dimension(200, 30));

        buttonIngresarCajero = new JButton("Ingresar Cajero");
        buttonIngresarCajero.setPreferredSize(new Dimension(200, 30));

        mainPanel.add(text1);
        mainPanel.add(buttonIngresarAdmin);
        mainPanel.add(buttonIngresarCajero);

        setContentPane(mainPanel);

        buttonIngresarAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginAdminForm loginAdminForm = new LoginAdminForm();
                loginAdminForm.setSize(450, 400);
                loginAdminForm.setLocationRelativeTo(null);
                loginAdminForm.setVisible(true);
                dispose();
            }
        });

        buttonIngresarCajero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CajeroForm cajeroForm = new CajeroForm();
                cajeroForm.setSize(450, 300);
                cajeroForm.setLocationRelativeTo(null);
                cajeroForm.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
}

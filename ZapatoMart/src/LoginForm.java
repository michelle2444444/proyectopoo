import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JPanel mainPanel;
    private JButton button1Ingreso;
    private JButton button2Ingreso;

    public LoginForm() {
        setTitle("Login");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainPanel = new JPanel();
        button1Ingreso = new JButton("Ingresar Admin");
        button2Ingreso = new JButton("Ingresar Cajero");


        mainPanel.setLayout(new GridLayout(2, 1, 10, 10));


        button1Ingreso.setPreferredSize(new Dimension(200, 30));
        button2Ingreso.setPreferredSize(new Dimension(200, 30));


        mainPanel.add(button1Ingreso);
        mainPanel.add(button2Ingreso);

        setContentPane(mainPanel);


        button1Ingreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginAdminForm logForm2 = new LoginAdminForm();
                logForm2.setSize(450, 400);
                logForm2.setLocationRelativeTo(null);
                logForm2.setVisible(true);
                dispose();
            }
        });

        button2Ingreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginCajeroForm logForm3 = new LoginCajeroForm();
                logForm3.setSize(550, 400);
                logForm3.setLocationRelativeTo(null);
                logForm3.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginForm frame = new LoginForm();
            frame.setVisible(true);
        });
    }
}
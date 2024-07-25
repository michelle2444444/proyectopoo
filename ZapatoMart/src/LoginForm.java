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
        setContentPane(mainPanel);
        pack();

        button1Ingreso.setPreferredSize(new Dimension(200, 30));
        button2Ingreso.setPreferredSize(new Dimension(200, 30));

        button1Ingreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogForm2 logForm2 = new LogForm2();
                logForm2.setVisible(true);
                logForm2.setSize(600, 600);
                logForm2.setPreferredSize(new Dimension(450, 400));
                logForm2.pack();
                logForm2.setLocationRelativeTo(null);
                dispose();
            }
        });

        button2Ingreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginCajero logForm3 = new LogForm3();
                logForm3.setVisible(true);
                logForm3.setSize(600, 600);
                logForm3.setPreferredSize(new Dimension(550, 400));
                logForm3.pack();
                logForm3.setLocationRelativeTo(null);
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
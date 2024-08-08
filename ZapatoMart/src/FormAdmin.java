import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormAdmin extends JFrame {

    private JPanel AdminPanel;
    private JButton Button1adminstock;
    private JButton Button3anadir;
    private JButton cerrarSesionButton;

    public FormAdmin() {
        setTitle("Administración");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(650, 400));
        setLocationRelativeTo(null);

        AdminPanel = new JPanel();
        AdminPanel.setLayout(new GridLayout(4, 1, 10, 10));

        Button1adminstock = new JButton("Administrar Stock");
        Button3anadir = new JButton("Añadir Usuarios");
        cerrarSesionButton = new JButton("Cerrar Sesión");

        Border borde = BorderFactory.createLineBorder(Color.BLACK, 1, true);

        Button1adminstock.setBorder(borde);
        Button1adminstock.setPreferredSize(new Dimension(150, 30));

        Button3anadir.setBorder(borde);
        Button3anadir.setPreferredSize(new Dimension(150, 30));

        cerrarSesionButton.setBorder(borde);
        cerrarSesionButton.setPreferredSize(new Dimension(150, 30));

        AdminPanel.add(Button1adminstock);
        AdminPanel.add(Button3anadir);
        AdminPanel.add(cerrarSesionButton);

        setContentPane(AdminPanel);

        Button3anadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarCajeros frame = new AgregarCajeros();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(new Dimension(550, 350));
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
            }
        });

        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm formLogin = new LoginForm();
                formLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
                formLogin.setSize(new Dimension(300, 250));
                formLogin.setLocationRelativeTo(null);
                formLogin.setVisible(true);
                dispose();
            }
        });

        Button1adminstock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarProductos Aproducts = new AgregarProductos();
                Aproducts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Aproducts.setSize(new Dimension(650, 700));
                Aproducts.setLocationRelativeTo(null);
                Aproducts.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormAdmin().setVisible(true);
            }
        });
    }
}
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCajero extends JFrame {
    private JPanel Cajerform;
    private JButton regresarButton;
    private JButton transaccionButton;

    public FormCajero() {
        setTitle("Cajeros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar componentes
        Cajerform = new JPanel();
        regresarButton = new JButton("Regresar");
        transaccionButton = new JButton("Transacción");

        // Configurar el panel
        Cajerform.setLayout(new FlowLayout());
        Cajerform.add(regresarButton);
        Cajerform.add(transaccionButton);

        // Configuración de los bordes y tamaño de los botones
        Border borde1 = BorderFactory.createLineBorder(Color.BLACK, 1, true);
        regresarButton.setBorder(borde1);
        regresarButton.setPreferredSize(new Dimension(150, 20));

        Border borde3 = BorderFactory.createLineBorder(Color.BLACK, 1, true);
        transaccionButton.setBorder(borde3);
        transaccionButton.setPreferredSize(new Dimension(150, 20));

        // Añadir el panel al contenido del JFrame
        setContentPane(Cajerform);
        setSize(600, 440);
        setLocationRelativeTo(null);
        setVisible(true);

        transaccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Trasaccion transaccion = new Trasaccion();
                transaccion.setVisible(true);
                transaccion.setSize(new Dimension(820, 700));
                transaccion.setLocationRelativeTo(null);
                transaccion.setResizable(false);
                dispose();
            }
        });

        regresarButton.addActionListener(new ActionListener() {
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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormCajero().setVisible(true));
    }
}

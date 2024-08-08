import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCajero extends JFrame {
    private JPanel Cajerform;
    private JButton regresarButton;
    private JButton productosButton;
    private JButton transaccionButton;

    public FormCajero() {
        setTitle("Cajeros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(Cajerform);
        setSize(600, 440);
        setLocationRelativeTo(null);
        setVisible(true);

        // Inicializar componentes
        regresarButton = new JButton("Regresar");
        productosButton = new JButton("Productos");
        transaccionButton = new JButton("Transacción");

        // Añadir componentes al panel
        Cajerform.add(regresarButton);
        Cajerform.add(productosButton);
        Cajerform.add(transaccionButton);

        // Configuración de los bordes y tamaño de los botones
        Border borde1 = BorderFactory.createLineBorder(Color.BLACK, 1, true);
        regresarButton.setBorder(borde1);
        regresarButton.setPreferredSize(new Dimension(150, 20));

        Border borde2 = BorderFactory.createLineBorder(Color.BLACK, 1, true);
        productosButton.setBorder(borde2);
        productosButton.setPreferredSize(new Dimension(150, 20));

        Border borde3 = BorderFactory.createLineBorder(Color.BLACK, 1, true);
        transaccionButton.setBorder(borde3);
        transaccionButton.setPreferredSize(new Dimension(150, 20));

        transaccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Trasaccion transaccion = new Trasaccion();
                transaccion.setVisible(true);
                transaccion.setPreferredSize(new Dimension(500, 300));
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

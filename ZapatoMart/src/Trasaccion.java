import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Trasaccion extends JFrame {
    private JPanel Mpanel;
    private JTextField nombrecajero;
    private JTextField cicajero;
    private JTextField correocajero;
    private JTextField direcajero;
    private JTextField tlfcajero;
    private JTextField nombrecliente;
    private JTextField direcliente;
    private JTextField tlfcli;
    private JTextField ciclie;
    private JTextField correocli;
    private JButton regresarButton;
    private JButton generarButton;
    private JTextField cantidaddetalle;
    private JTextField totaldetalle;
    private JTextField proddetalle;
    private JTextField preciodeta;
    private JLabel icon1;

    public Trasaccion() {
        setTitle("Transaccion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(Mpanel);
        setSize(820, 700);
        setLocationRelativeTo(null);
        setVisible(true);

        Mpanel.setLayout(null);

        // Inicializar componentes
        nombrecajero = new JTextField();
        cicajero = new JTextField();
        correocajero = new JTextField();
        direcajero = new JTextField();
        tlfcajero = new JTextField();
        nombrecliente = new JTextField();
        direcliente = new JTextField();
        tlfcli = new JTextField();
        ciclie = new JTextField();
        correocli = new JTextField();
        regresarButton = new JButton("Regresar");
        generarButton = new JButton("Generar");
        cantidaddetalle = new JTextField();
        totaldetalle = new JTextField();
        proddetalle = new JTextField();
        preciodeta = new JTextField();
        icon1 = new JLabel();

        // Añadir componentes al panel
        Mpanel.add(nombrecajero);
        Mpanel.add(cicajero);
        Mpanel.add(correocajero);
        Mpanel.add(direcajero);
        Mpanel.add(tlfcajero);
        Mpanel.add(nombrecliente);
        Mpanel.add(direcliente);
        Mpanel.add(tlfcli);
        Mpanel.add(ciclie);
        Mpanel.add(correocli);
        Mpanel.add(regresarButton);
        Mpanel.add(generarButton);
        Mpanel.add(cantidaddetalle);
        Mpanel.add(totaldetalle);
        Mpanel.add(proddetalle);
        Mpanel.add(preciodeta);
        Mpanel.add(icon1);

        // Configuración de los componentes
        nombrecajero.setBounds(93, 50, 150, 20);
        correocajero.setBounds(318, 50, 150, 20);
        direcajero.setBounds(93, 100, 150, 20);
        tlfcajero.setBounds(93, 150, 150, 20);
        cicajero.setBounds(318, 100, 150, 20);

        nombrecliente.setBounds(93, 290, 150, 20);
        direcliente.setBounds(93, 335, 150, 20);
        tlfcli.setBounds(93, 380, 150, 20);
        correocli.setBounds(318, 290, 150, 20);
        ciclie.setBounds(318, 335, 150, 20);

        proddetalle.setBounds(93, 505, 150, 20);
        cantidaddetalle.setBounds(325, 505, 150, 20);
        preciodeta.setBounds(570, 505, 150, 20);
        totaldetalle.setBounds(93, 595, 150, 20);

        generarButton.setBounds(350, 630, 100, 25);
        regresarButton.setBounds(93, 630, 100, 25);

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCajero cajerform = new FormCajero();
                cajerform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                cajerform.setSize(600, 440);
                cajerform.setLocationRelativeTo(null);
                cajerform.setVisible(true);
                dispose();
            }
        });

        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para generar transacción
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Trasaccion().setVisible(true));
    }
}

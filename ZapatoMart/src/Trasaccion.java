import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

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
        setSize(820, 700);
        setLocationRelativeTo(null);
        setVisible(true);

        Mpanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Inicializar componentes
        JLabel labelNombreCajero = new JLabel("Nombre:");
        nombrecajero = new JTextField(20);
        JLabel labelCicajero = new JLabel("C.I:");
        cicajero = new JTextField(20);
        JLabel labelCorreocajero = new JLabel("Correo:");
        correocajero = new JTextField(20);
        JLabel labelDirecajero = new JLabel("Dirección:");
        direcajero = new JTextField(20);
        JLabel labelTlfcajero = new JLabel("Tlf:");
        tlfcajero = new JTextField(20);

        JLabel labelNombreCliente = new JLabel("Nombre:");
        nombrecliente = new JTextField(20);
        JLabel labelCiclie = new JLabel("C.I:");
        ciclie = new JTextField(20);
        JLabel labelCorreocli = new JLabel("Correo:");
        correocli = new JTextField(20);
        JLabel labelDirecliente = new JLabel("Dirección:");
        direcliente = new JTextField(20);
        JLabel labelTlfcli = new JLabel("Tlf:");
        tlfcli = new JTextField(20);

        JLabel labelProddetalle = new JLabel("Producto:");
        proddetalle = new JTextField(20);
        JLabel labelCantidaddetalle = new JLabel("Cantidad comprada:");
        cantidaddetalle = new JTextField(20);
        JLabel labelPreciodeta = new JLabel("Precio:");
        preciodeta = new JTextField(20);
        JLabel labelTotaldetalle = new JLabel("Total a pagar + IVA:");
        totaldetalle = new JTextField(20);

        regresarButton = new JButton("Regresar");
        generarButton = new JButton("Generar");

        // Datos del vendedor
        gbc.gridx = 0;
        gbc.gridy = 0;
        Mpanel.add(new JLabel("Datos del vendedor"), gbc);

        gbc.gridy = 1;
        Mpanel.add(labelNombreCajero, gbc);
        gbc.gridx = 1;
        Mpanel.add(nombrecajero, gbc);
        gbc.gridx = 2;
        Mpanel.add(labelDirecajero, gbc);
        gbc.gridx = 3;
        Mpanel.add(direcajero, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        Mpanel.add(labelCicajero, gbc);
        gbc.gridx = 1;
        Mpanel.add(cicajero, gbc);
        gbc.gridx = 2;
        Mpanel.add(labelTlfcajero, gbc);
        gbc.gridx = 3;
        Mpanel.add(tlfcajero, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        Mpanel.add(labelCorreocajero, gbc);
        gbc.gridx = 1;
        Mpanel.add(correocajero, gbc);

        // Datos del cliente
        gbc.gridx = 0;
        gbc.gridy = 4;
        Mpanel.add(new JLabel("Datos del cliente"), gbc);

        gbc.gridy = 5;
        Mpanel.add(labelNombreCliente, gbc);
        gbc.gridx = 1;
        Mpanel.add(nombrecliente, gbc);
        gbc.gridx = 2;
        Mpanel.add(labelDirecliente, gbc);
        gbc.gridx = 3;
        Mpanel.add(direcliente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        Mpanel.add(labelCiclie, gbc);
        gbc.gridx = 1;
        Mpanel.add(ciclie, gbc);
        gbc.gridx = 2;
        Mpanel.add(labelTlfcli, gbc);
        gbc.gridx = 3;
        Mpanel.add(tlfcli, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        Mpanel.add(labelCorreocli, gbc);
        gbc.gridx = 1;
        Mpanel.add(correocli, gbc);

        // Detalle de Factura
        gbc.gridx = 0;
        gbc.gridy = 8;
        Mpanel.add(new JLabel("Detalle de Factura"), gbc);

        gbc.gridy = 9;
        Mpanel.add(labelProddetalle, gbc);
        gbc.gridx = 1;
        Mpanel.add(proddetalle, gbc);
        gbc.gridx = 2;
        Mpanel.add(labelCantidaddetalle, gbc);
        gbc.gridx = 3;
        Mpanel.add(cantidaddetalle, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        Mpanel.add(labelPreciodeta, gbc);
        gbc.gridx = 1;
        Mpanel.add(preciodeta, gbc);
        gbc.gridx = 2;
        Mpanel.add(labelTotaldetalle, gbc);
        gbc.gridx = 3;
        Mpanel.add(totaldetalle, gbc);

        // Botones
        gbc.gridx = 0;
        gbc.gridy = 11;
        Mpanel.add(regresarButton, gbc);
        gbc.gridx = 3;
        Mpanel.add(generarButton, gbc);

        setContentPane(Mpanel);

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
                generarPDF();
            }
        });
    }

    private void generarPDF() {
        String dest = "NotaVenta.pdf";
        try {
            PdfWriter writer = new PdfWriter(dest);
            com.itextpdf.kernel.pdf.PdfDocument pdf = new com.itextpdf.kernel.pdf.PdfDocument(writer);
            Document document = new Document(pdf);

            // Datos del vendedor
            document.add(new Paragraph("Datos del vendedor"));
            Table table = new Table(2);
            table.addCell("Nombre:");
            table.addCell(nombrecajero.getText());
            table.addCell("C.I:");
            table.addCell(cicajero.getText());
            table.addCell("Correo:");
            table.addCell(correocajero.getText());
            table.addCell("Dirección:");
            table.addCell(direcajero.getText());
            table.addCell("Tlf:");
            table.addCell(tlfcajero.getText());
            document.add(table);

            // Datos del cliente
            document.add(new Paragraph("Datos del cliente"));
            table = new Table(2);
            table.addCell("Nombre:");
            table.addCell(nombrecliente.getText());
            table.addCell("C.I:");
            table.addCell(ciclie.getText());
            table.addCell("Correo:");
            table.addCell(correocli.getText());
            table.addCell("Dirección:");
            table.addCell(direcliente.getText());
            table.addCell("Tlf:");
            table.addCell(tlfcli.getText());
            document.add(table);

            // Detalle de Factura
            document.add(new Paragraph("Detalle de Factura"));
            table = new Table(2);
            table.addCell("Producto:");
            table.addCell(proddetalle.getText());
            table.addCell("Cantidad comprada:");
            table.addCell(cantidaddetalle.getText());
            table.addCell("Precio:");
            table.addCell(preciodeta.getText());
            table.addCell("Total a pagar + IVA:");
            table.addCell(totaldetalle.getText());
            document.add(table);

            document.close();
            JOptionPane.showMessageDialog(this, "Nota de venta generada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar la nota de venta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Trasaccion().setVisible(true));
    }
}

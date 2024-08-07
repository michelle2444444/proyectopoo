import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AgregarProductos extends JFrame {
    private JPanel AgregarProdPanel;
    private JButton addStockButton;
    private JTable table1;
    private JButton regresarButton;
    private JTextField CodProd;
    private JTextField CantidadProd;
    private JTextField stockprod;
    private JTextField precioprod;
    private JTextField NomProd;
    private JButton agregarButton;
    private DefaultTableModel modelo;

    private List<Productos> productosList = new ArrayList<>();

    public AgregarProductos() {
        setTitle("Agregar Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(AgregarProdPanel);
        setSize(650, 700);
        setLocationRelativeTo(null);
        setVisible(true);

        AgregarProdPanel.setLayout(null);

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("Usuarios");
        MongoCollection<Document> productosCollection = database.getCollection("Productos");

        // Establecer los límites para los campos de texto
        NomProd.setBounds(120, 350, 150, 20);
        CodProd.setBounds(120, 385, 150, 20);
        CantidadProd.setBounds(120, 420, 150, 20);
        stockprod.setBounds(390, 350, 150, 20);
        precioprod.setBounds(390, 385, 150, 20);

        agregarButton.setBounds(200, 470, 120, 25);
        addStockButton.setBounds(330, 470, 120, 25);
        regresarButton.setBounds(40, 637, 100, 20);

        modelo = new DefaultTableModel(new Object[]{"Producto", "Código", "Cantidad", "Stock", "Precio"}, 0);
        table1.setModel(modelo);

        JScrollPane scrollPane = new JScrollPane(table1);
        scrollPane.setBounds(70, 530, 500, 100);
        AgregarProdPanel.add(scrollPane);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String producto = NomProd.getText();
                String codigo = CodProd.getText();
                String stock = stockprod.getText();
                double precio;
                int cantidad;

                try {
                    precio = Double.parseDouble(precioprod.getText());
                    cantidad = Integer.parseInt(CantidadProd.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Debe ingresarse un número válido", null, JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Productos productoObj = new Productos(producto, codigo, cantidad, stock, precio);
                if (!isProductosEmpty(productoObj)) {
                    productosList.add(productoObj);
                    Document prodDoc = productoObj.toDocument();
                    productosCollection.insertOne(prodDoc);
                    JOptionPane.showMessageDialog(null, "Producto Ingresado", null, JOptionPane.INFORMATION_MESSAGE);
                    modelo.addRow(new Object[]{productoObj.getNomProducto(), productoObj.getIdProducto(), productoObj.getCantidadProd(), productoObj.getStockProd(), productoObj.getPrecioProd()});

                    // Limpiar los campos de entrada
                    NomProd.setText("");
                    CodProd.setText("");
                    CantidadProd.setText("");
                    stockprod.setText("");
                    precioprod.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "El formulario está vacío", null, JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormAdmin adminForm = new FormAdmin();
                adminForm.setVisible(true);
                adminForm.setSize(300, 600);
                adminForm.setPreferredSize(new Dimension(700, 440));
                adminForm.pack();
                adminForm.setLocationRelativeTo(null);
                dispose();
            }
        });

    }

    private boolean isProductosEmpty(Productos productos) {
        return productos.getNomProducto() == null || productos.getNomProducto().isEmpty() ||
                productos.getIdProducto() == null || productos.getIdProducto().isEmpty() ||
                productos.getStockProd() == null || productos.getStockProd().isEmpty() ||
                productos.getPrecioProd() == 0.0 ||
                productos.getCantidadProd() == 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgregarProductos().setVisible(true));
    }
}

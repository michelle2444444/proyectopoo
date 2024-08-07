import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import javax.swing.border.Border;
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
        setSize(650, 700);
        setLocationRelativeTo(null);

        AgregarProdPanel = new JPanel();
        AgregarProdPanel.setLayout(new BorderLayout());

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("ZapatoMart");
        MongoCollection<Document> productosCollection = database.getCollection("productos");

        // Crear los componentes
        JLabel labelNomProd = new JLabel("Producto:");
        JLabel labelCodProd = new JLabel("Código:");
        JLabel labelCantidadProd = new JLabel("Descripción:");
        JLabel labelStockProd = new JLabel("Stock:");
        JLabel labelPrecioProd = new JLabel("Precio:");

        NomProd = new JTextField();
        CodProd = new JTextField();
        CantidadProd = new JTextField();
        stockprod = new JTextField();
        precioprod = new JTextField();

        agregarButton = new JButton("Agregar");
        addStockButton = new JButton("Add Stock");
        regresarButton = new JButton("Regresar");

        // Crear y aplicar borde al botón
        Border borde = BorderFactory.createLineBorder(Color.BLACK);
        regresarButton.setBorder(borde);
        regresarButton.setPreferredSize(new Dimension(50, 30));

        // Configurar la tabla
        modelo = new DefaultTableModel(new Object[]{"Producto", "Código", "Descripción", "Stock", "Precio"}, 0);
        table1 = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(table1);

        // Establecer el diseño del panel
        JPanel formPanel = new JPanel();
        GroupLayout layout = new GroupLayout(formPanel);
        formPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelNomProd)
                                .addComponent(labelCodProd)
                                .addComponent(labelCantidadProd))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(NomProd, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(CodProd, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(CantidadProd, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelStockProd)
                                .addComponent(labelPrecioProd))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(stockprod, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(precioprod, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(agregarButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addComponent(addStockButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelNomProd)
                                .addComponent(NomProd, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelStockProd)
                                .addComponent(stockprod, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelCodProd)
                                .addComponent(CodProd, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelPrecioProd)
                                .addComponent(precioprod, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelCantidadProd)
                                .addComponent(CantidadProd, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addComponent(agregarButton)
                                .addComponent(addStockButton))
        );

        AgregarProdPanel.add(formPanel, BorderLayout.NORTH);
        AgregarProdPanel.add(scrollPane, BorderLayout.CENTER);
        AgregarProdPanel.add(regresarButton, BorderLayout.SOUTH);

        setContentPane(AgregarProdPanel);
        setVisible(true);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String producto = NomProd.getText();
                String codigo = CodProd.getText();
                String descripcion = CantidadProd.getText();
                String stock = stockprod.getText();
                double precio;
                int cantidad;

                try {
                    precio = Double.parseDouble(precioprod.getText());
                    descripcion = Integer.parseInt(CantidadProd.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Debe ingresarse un número válido", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Productos productoObj = new Productos(producto, codigo, cantidad, stock, precio);
                if (!isProductosEmpty(productoObj)) {
                    productosList.add(productoObj);
                    Document prodDoc = productoObj.toDocument();
                    productosCollection.insertOne(prodDoc);
                    JOptionPane.showMessageDialog(null, "Producto Ingresado", "Información", JOptionPane.INFORMATION_MESSAGE);
                    modelo.addRow(new Object[]{productoObj.getNomProducto(), productoObj.getIdProducto(), productoObj.getCantidadProd(), productoObj.getStockProd(), productoObj.getPrecioProd()});

                    // Limpiar los campos de entrada
                    NomProd.setText("");
                    CodProd.setText("");
                    CantidadProd.setText("");
                    stockprod.setText("");
                    precioprod.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "El formulario está vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
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

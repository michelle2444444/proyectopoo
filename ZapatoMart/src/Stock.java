import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stock extends JFrame {
    private JPanel stockPanel;
    private JTextField cod;
    private JTextField nombre;
    private JTextField textField3;
    private JButton buscarButton;
    private JButton modificarButton;
    private JButton regresarButton;
    private JTable table1;
    private JLabel stock;
    private DefaultTableModel modelo1;

    public Stock() {
        setTitle("Agregar stock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(stockPanel);
        setSize(400, 380);
        setLocationRelativeTo(null);
        setVisible(true);

        initComponents();
    }

    private void initComponents() {
        stockPanel = new JPanel();
        cod = new JTextField();
        nombre = new JTextField();
        textField3 = new JTextField();
        buscarButton = new JButton("Buscar");
        modificarButton = new JButton("Modificar");
        regresarButton = new JButton("Regresar");
        table1 = new JTable();
        stock = new JLabel("Stock:");
        modelo1 = new DefaultTableModel(new Object[]{"Producto", "Codigo", "Cantidad", "Stock", "Precio"}, 0);

        table1.setModel(modelo1);
        JScrollPane scrollPane = new JScrollPane(table1);

        GroupLayout layout = new GroupLayout(stockPanel);
        stockPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(stock)
                                        .addComponent(cod, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nombre, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(buscarButton)
                                                .addComponent(modificarButton))
                                        .addComponent(regresarButton))
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(stock)
                                .addComponent(cod, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nombre, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buscarButton)
                                .addComponent(modificarButton))
                        .addComponent(regresarButton)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        );

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarStock();
            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarProductos agregarProductos = new AgregarProductos();
                agregarProductos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                agregarProductos.setSize(650, 700);
                agregarProductos.setLocationRelativeTo(null);
                agregarProductos.setVisible(true);
                dispose();
            }
        });
    }

    private void buscarProducto() {
        String codprod = cod.getText().trim();
        String nomprod = nombre.getText().trim();

        modelo1.setRowCount(0);

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase stock = mongoClient.getDatabase("ZapatoMart");
            MongoCollection<Document> collection = stock.getCollection("productos");

            Document query = new Document();
            if (!codprod.isEmpty()) {
                query.append("IDproducto", codprod);
            }
            if (!nomprod.isEmpty()) {
                query.append("Producto", nomprod);
            }

            System.out.println("Query: " + query.toJson());

            FindIterable<Document> documentos = collection.find(query);

            for (Document document : documentos) {
                Productos producto = new Productos(
                        document.getString("Producto"),
                        document.getString("IDproducto"),
                        document.getString("Descripcion:"),
                        document.getInteger("Stock"),
                        document.getDouble("Precio")
                );
                modelo1.addRow(new Object[]{
                        producto.getNomProducto(),
                        producto.getIdProducto(),
                        producto.getDescripcionProd(),
                        producto.getStockProd(),
                        producto.getPrecioProd()
                });
            }
        } catch (Exception ef) {
            ef.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar el producto", null, JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizarStock() {
        String codprod = cod.getText().trim();
        String nomprod = nombre.getText().trim();
        String Nstock = textField3.getText().trim();

        if (Nstock.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nuevo stock", null, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase stock = mongoClient.getDatabase("Usuarios");
            MongoCollection<Document> collection = stock.getCollection("Productos");

            Document query1 = new Document();
            if (!codprod.isEmpty()) {
                query1.append("IDproducto", codprod);
            }
            if (!nomprod.isEmpty()) {
                query1.append("Producto", nomprod);
            }
            Document update = new Document("$set", new Document("Stock", Nstock).append("Cantidad", Integer.parseInt(Nstock)));
            UpdateResult result = collection.updateMany(query1, update);

            if (result.getMatchedCount() > 0) {
                JOptionPane.showMessageDialog(null, "Stock actualizado", null, JOptionPane.INFORMATION_MESSAGE);
                buscarProducto();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el producto", null, JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ef) {
            ef.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar", null, JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Stock();
    }
}

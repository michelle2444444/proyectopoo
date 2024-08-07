import org.bson.Document;

public class Productos {
    private String nomProducto;
    private String idProducto;
    private String descripcionProd;
    private int stockProd;
    private double precioProd;

    public Productos(String nomProducto, String idProducto, String descripcionProd, int stockProd, double precioProd) {
        this.nomProducto = nomProducto;
        this.idProducto = idProducto;
        this.descripcionProd = descripcionProd;
        this.stockProd = stockProd;
        this.precioProd = precioProd;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public int getStockProd() {
        return stockProd;
    }

    public double getPrecioProd() {
        return precioProd;
    }

    public Document toDocument() {
        return new Document("Producto", nomProducto)
                .append("IDproducto", idProducto)
                .append("Descripcion", descripcionProd)
                .append("Stock", stockProd)
                .append("Precio", precioProd);
    }
}

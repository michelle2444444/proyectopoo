import org.bson.Document;

public class Productos {
    private String nomProducto;
    private String idProducto;
    private int cantidadProd;
    private String stockProd;
    private double precioProd;

    public Productos(String nomProducto, String idProducto, int cantidadProd, String stockProd, double precioProd) {
        this.nomProducto = nomProducto;
        this.idProducto = idProducto;
        this.cantidadProd = cantidadProd;
        this.stockProd = stockProd;
        this.precioProd = precioProd;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public String getStockProd() {
        return stockProd;
    }

    public double getPrecioProd() {
        return precioProd;
    }

    public Document toDocument() {
        return new Document("Producto", nomProducto)
                .append("IDproducto", idProducto)
                .append("Cantidad", cantidadProd)
                .append("Stock", stockProd)
                .append("Precio", precioProd);
    }
}


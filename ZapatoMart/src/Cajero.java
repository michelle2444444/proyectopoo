import org.bson.Document;
import java.time.Instant;

public class Cajero {
    private String usuarioCajero;
    private String contraseniaCajero;
    private String cedulaCajero;
    private String nombreCajero;
    private String apellidoCajero;
    private String edadCajero;
    private String correoCajero;
    private String rolCajero;
    private String ingresoCajero;
    private String timestamp;

    public Cajero() {}

    public Cajero(String usuarioCajero, String contraseniaCajero, String cedulaCajero, String nombreCajero,
                  String apellidoCajero, String edadCajero, String correoCajero, String rolCajero, String ingresoCajero) {
        this.usuarioCajero = usuarioCajero;
        this.contraseniaCajero = contraseniaCajero;
        this.cedulaCajero = cedulaCajero;
        this.nombreCajero = nombreCajero;
        this.apellidoCajero = apellidoCajero;
        this.edadCajero = edadCajero;
        this.correoCajero = correoCajero;
        this.rolCajero = rolCajero;
        this.ingresoCajero = ingresoCajero;
        this.timestamp = Instant.now().toString();
    }

    public String getUsuarioCajero() {
        return usuarioCajero;
    }

    public void setUsuarioCajero(String usuarioCajero) {
        this.usuarioCajero = usuarioCajero;
    }

    public String getContraseniaCajero() {
        return contraseniaCajero;
    }

    public void setContraseniaCajero(String contraseniaCajero) {
        this.contraseniaCajero = contraseniaCajero;
    }

    public String getCedulaCajero() {
        return cedulaCajero;
    }

    public void setCedulaCajero(String cedulaCajero) {
        this.cedulaCajero = cedulaCajero;
    }

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }

    public String getApellidoCajero() {
        return apellidoCajero;
    }

    public void setApellidoCajero(String apellidoCajero) {
        this.apellidoCajero = apellidoCajero;
    }

    public String getEdadCajero() {
        return edadCajero;
    }

    public void setEdadCajero(String edadCajero) {
        this.edadCajero = edadCajero;
    }

    public String getCorreoCajero() {
        return correoCajero;
    }

    public void setCorreoCajero(String correoCajero) {
        this.correoCajero = correoCajero;
    }

    public String getRolCajero() {
        return rolCajero;
    }

    public void setRolCajero(String rolCajero) {
        this.rolCajero = rolCajero;
    }

    public String getIngresoCajero() {
        return ingresoCajero;
    }

    public void setIngresoCajero(String ingresoCajero) {
        this.ingresoCajero = ingresoCajero;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Document toDocument() {
        return new Document("Usuario", usuarioCajero)
                .append("Contrasenia", contraseniaCajero)
                .append("Cedula", cedulaCajero)
                .append("Nombre", nombreCajero)
                .append("Apellido", apellidoCajero)
                .append("Edad", edadCajero)
                .append("Correo", correoCajero)
                .append("Rol", rolCajero)
                .append("Ingreso", ingresoCajero)
                .append("Timestamp", timestamp);
    }

    public static Cajero fromDocument(Document doc) {
        return new Cajero(
                doc.getString("Usuario"),
                doc.getString("Contrasenia"),
                doc.getString("Cedula"),
                doc.getString("Nombre"),
                doc.getString("Apellido"),
                doc.getString("Edad"),
                doc.getString("Correo"),
                doc.getString("Rol"),
                doc.getString("Ingreso")
        );
    }
}


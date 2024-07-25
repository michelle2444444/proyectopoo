import org.bson.Document;

public class Cliente {
    private String nombreCliente;
    private String direccionCliente;
    private String telefonoCliente;
    private String emailCliente;
    private String ciCliente;

    public Cliente() {}

    public Cliente(String nombreCliente, String direccionCliente, String telefonoCliente, String emailCliente, String ciCliente) {
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.ciCliente = ciCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getCiCliente() {
        return ciCliente;
    }

    public void setCiCliente(String ciCliente) {
        this.ciCliente = ciCliente;
    }

    public Document toDocument() {
        return new Document("Nombre", nombreCliente)
                .append("Direccion", direccionCliente)
                .append("Telefono", telefonoCliente)
                .append("Email", emailCliente)
                .append("Cedula", ciCliente);
    }
}


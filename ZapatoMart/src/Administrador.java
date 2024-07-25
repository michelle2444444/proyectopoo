import org.bson.Document;

public class Administrador extends Main {
    private String usuarioAdmin;
    private String contraseniaAdmin;

    public Administrador() {}

    public Administrador(String usuarioAdmin, String contraseniaAdmin) {
        this.usuarioAdmin = usuarioAdmin;
        this.contraseniaAdmin = contraseniaAdmin;
    }

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(String usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    public String getContraseniaAdmin() {
        return contraseniaAdmin;
    }

    public void setContraseniaAdmin(String contraseniaAdmin) {
        this.contraseniaAdmin = contraseniaAdmin;
    }

    @Override
    public Document toDocument() {
        return new Document("Usuario", usuarioAdmin).append("Contrasenia", contraseniaAdmin);
    }
}


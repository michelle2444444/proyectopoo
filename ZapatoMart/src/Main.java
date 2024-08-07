import com.mongodb.client.*;
import com.mongodb.client.result.*;
import org.bson.Document;

public abstract class Main extends LoginForm {
    public static void main(String[] args) {
        Administrador administrador1 = new Administrador("UsuarioPrueba001","Contrasena001");

        //Conexion a Mongodb

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("ZapatoMart");
        MongoCollection<Document> usuarios = database.getCollection("Administrador");
        Document documentAdmin = administrador1.toDocument();

        usuarios.insertOne(documentAdmin);
    }

    public abstract Document toDocument();
}
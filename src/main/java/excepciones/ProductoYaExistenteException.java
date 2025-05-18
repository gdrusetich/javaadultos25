package excepciones;

public class ProductoYaExistenteException extends Exception{
    public ProductoYaExistenteException(String message){
        super(message);
    }
}

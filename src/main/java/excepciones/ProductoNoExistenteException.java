package excepciones;

public class ProductoNoExistenteException extends Exception{
    public ProductoNoExistenteException(String message){
        super(message);
    }
}

package excepciones;

public class NoHayStockException extends Exception{
    public NoHayStockException(String message){
        super(message);
    }
}

package gerenciadorDeGaragem.exceptions;

public class GaragemNotFoundException  extends RuntimeException {

    public GaragemNotFoundException (String message){
        super(message);
        }
}

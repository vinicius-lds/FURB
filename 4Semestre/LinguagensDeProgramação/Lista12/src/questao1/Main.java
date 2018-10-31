package questao1;

/**
 * @author Vinícius Luis da Silva
 */
public class Main {

    static final long INTERVALO = 500;
    
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        new Adiciona(buffer);
        new Subtrai(buffer);
    }
    
}

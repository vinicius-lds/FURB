package questao1;

/**
 * @author Vinícius Luis da Silva
 */
public class Buffer {
    
    private int count = 0;
    
    public void adiciona() {
        count++;
        print();
    }
    
    public void subtrai() {
        count--;
        print();
    }
    
    private void print() {
        System.out.println("Count: " + count);
    }
    
}

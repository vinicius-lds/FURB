/**
 * @author Vinícius Luis da Silva
 */
public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {
        if(super.getInfo().length == super.getTamanho()) {
            super.redimensionar();
        }
        super.getInfo()[super.getTamanho()] = valor;
        super.setTamanho(super.getTamanho() + 1);
    }
    
    @Override
    public int buscar(T valor) {
        
        T[] info = super.getInfo();
        
        int inicio = 0;
        int fim = super.getTamanho() - 1;
        int meio;
        
        while (inicio <= fim) {            
            meio = (inicio + fim) / 2;
            
            int comparacao = valor.compareTo((T)info[meio]);
            
            
        }
        
        return 0;
    }

}

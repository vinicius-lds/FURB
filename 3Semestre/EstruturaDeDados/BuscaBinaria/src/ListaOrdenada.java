/**
 * @author Vinícius Luis da Silva
 */
public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {
        if(super.getTamanho() == 0) {
            super.getInfo()[0] = valor;
            return;
        }
        Object[] aux = super.getInfo();
        if(aux.length == super.getTamanho()) {
            super.redimensionar();
        }
        for (int i = 0; i < super.getTamanho(); i++) {
            if(valor.compareTo((T)aux[i]) < 0) {
                for (int j = i + 1; j < super.getTamanho(); j++) {
                    super.getInfo()[j] = (T)((aux[j + 1] != null) ? aux[j + 1] : null);
                }
                super.getInfo()[i] = valor;
                break;
            }
        }
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
            
            if(comparacao < 0) {
                fim = meio - 1;
            } else {
                if(comparacao > 0) {
                    inicio = meio + 1;
                } else {
                    return meio;
                }
            }
            
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        ListaOrdenada<Integer> ints = new ListaOrdenada<>();
        ints.inserir(5);
        ints.inserir(2);
        ints.inserir(3);
        ints.inserir(6);
        ints.inserir(7);
        ints.inserir(9);
    }

}

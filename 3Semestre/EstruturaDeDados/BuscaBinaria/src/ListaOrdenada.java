/**
 * @author Vinícius Luis da Silva
 */
public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {
        Object[] info = super.getInfo();
        if (info.length == getTamanho()) {
            redimensionar();
        }
        int posicao = 0;
        for (posicao = 0; posicao < getTamanho(); posicao++) {
            if (((Comparable) info[posicao]).compareTo(valor) > 0) {
                break;
            }
        }
        for (int i = getTamanho() - 1; i >= posicao; i--) {
            info[i + 1] = info[i];
        }
        info[posicao] = valor;
        setTamanho(getTamanho() + 1);
    }

    @Override
    public int buscar(T valor) {
        Object[] info = super.getInfo();

        int inicio = 0;
        int fim = super.getTamanho() - 1;
        int meio;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            int comparacao = ((Comparable) info[meio]).compareTo(valor);

            if (comparacao > 0) {
                    fim = meio - 1;
            } else {
                if (comparacao < 0) {
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
        System.out.println(ints.toString());
        System.out.println(ints.buscar(1));
    }

}

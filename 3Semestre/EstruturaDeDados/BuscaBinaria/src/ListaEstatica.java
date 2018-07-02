/**
 * @author vinic
 */
public class ListaEstatica<T> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {
        if(super.getInfo().length == super.getTamanho()) {
            this.redimensionar();
        }
        super.getInfo()[super.getTamanho()] = valor;
        super.setTamanho(super.getTamanho() + 1);
    }

    @Override
    public int buscar(T valor) {
        for (int i = 0; i < super.getTamanho(); i++) {
            if(super.getInfo()[i].equals(valor)) { return i; }
        }
        return -1;
    }

}

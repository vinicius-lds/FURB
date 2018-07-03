/**
 * @author Vinícius Luis da Silva
 */
public class ArvoreBinaria<T extends Comparable<T>> extends ArvoreBinariaAbstract<T>{

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(getRaiz(), info);
    }
    
    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        } else if (no.getInfo().equals(info)) {
            return no;
        } else {
            NoArvoreBinaria<T> aux = buscar(no.getEsquerda(), info);
            if (aux == null) {
                aux = buscar(no.getDireita(), info);
            }
            return aux;
        }
    }

    @Override
    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }
    
}

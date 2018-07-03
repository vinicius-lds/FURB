/**
 * @author Vinicius Luis da Silva
 */
public abstract class OrdenacaoAbstract<T extends Comparable<T>> {

    private T[] info;

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }
    
    public void trimm() {
        int tamanho = 0;
        for (int i = 0; i < this.info.length; i++) {
            if(this.info[i] != null) {
                tamanho++;
            }
        }
        T[] aux = (T[])new Comparable[tamanho];
        for (int i = 0, j = 0; i < this.info.length; i++) {
            if(this.info[i] != null) {
                aux[j] = this.info[i];
                j++;
            }
        }
        this.info = aux;
    }
    
    public void trocar(int a, int b) {
        T aux = this.info[a];
        this.info[a] = this.info[b];
        this.info[b] = aux;
    }
    
    public abstract void ordenar();

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.info.length; i++) {
            str += this.info[i] + " ";
        }
        return str;
    }
    
}
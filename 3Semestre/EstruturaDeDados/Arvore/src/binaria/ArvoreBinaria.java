package binaria;

public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return (this.raiz == null);
    }

    public boolean pertence(T info) {
        return this.pertence(this.raiz, info);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        } else {
            return (no.getInfo() == info)
                    || this.pertence(no.getEsquerda(), info)
                    || this.pertence(no.getDireita(), info);
        }
    }

    @Override
    public String toString() {
        return this.arvorePre(getRaiz());
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        } else {
            return "<" + no.getInfo().toString()
                    + this.arvorePre(no.getEsquerda())
                    + this.arvorePre(no.getDireita())
                    + ">";
        }
    }

    public int contarNos() {
        return this.contarNos(this.getRaiz());
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + this.contarNos(no.getEsquerda()) + this.contarNos(no.getDireita());
        }
    }

    /*
	public static void main(String[] args) {
		
		NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
		NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
		NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, no4, no5);
		NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<>(7);
		NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6, no7, null);
		NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, null, no6);
		NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);
		
		ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
		arvore.setRaiz(no1);
		
		System.out.println(arvore.pertence(3));
		System.out.println(arvore.contarNos());
		
		System.out.println(arvore.toString());

	}
     */
}

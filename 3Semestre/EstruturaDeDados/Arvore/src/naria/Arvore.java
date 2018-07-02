package naria;

public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString() {

        if (this.raiz == null) {
            return "";
        } else {
            return obterRepresentacaoTextual(getRaiz());
        }

    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String str = "<";
        str += no.getInfo().toString();
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            str += this.obterRepresentacaoTextual(p);
            p = p.getProximo();
        }
        return str + ">";
    }

    public boolean pertence(T info) {
        if (this.getRaiz() == null) {
            return false;
        } else {
            return this.pertence(this.getRaiz(), info);
        }
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no.getInfo() == info) {
            return true;
        } else {
            NoArvore<T> p = no.getPrimeiro();
            while (p != null) {
                if (this.pertence(p, info)) {
                    return true;
                }
                p = p.getProximo();
            }
        }
        return false;
    }

    public NoArvore<T> buscar(T info) {
        if (this.getRaiz() == null) {
            return null;
        } else {
            return this.buscar(this.getRaiz(), info);
        }
    }

    private NoArvore<T> buscar(NoArvore<T> no, T info) {
        if (no.getInfo() == info) {
            return no;
        } else {
            NoArvore<T> p = no.getPrimeiro();
            NoArvore<T> n;
            while (p != null) {
                n = this.buscar(p, info);
                if (n != null) {
                    return n;
                } else {
                    p = p.getProximo();
                }
            }
        }
        return null;
    }

    public int contarNos() {
        return contarNos(this.getRaiz());
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null) {
            return 0;
        } else {
            int contador = 1;
            NoArvore<T> p = no.getPrimeiro();
            while (p != null) {
                contador += this.contarNos(p);
                p = p.getProximo();
            }
            return contador;
        }
    }

    public static void main(String[] args) {

        NoArvore<Integer> no01 = new NoArvore<Integer>(1);
        NoArvore<Integer> no02 = new NoArvore<Integer>(2);
        NoArvore<Integer> no03 = new NoArvore<Integer>(3);
        NoArvore<Integer> no04 = new NoArvore<Integer>(4);
        NoArvore<Integer> no05 = new NoArvore<Integer>(5);
        NoArvore<Integer> no06 = new NoArvore<Integer>(6);
        NoArvore<Integer> no07 = new NoArvore<Integer>(7);
        NoArvore<Integer> no08 = new NoArvore<Integer>(8);
        NoArvore<Integer> no09 = new NoArvore<Integer>(9);
        NoArvore<Integer> no10 = new NoArvore<Integer>(10);

        no01.inserirFilho(no04);
        no01.inserirFilho(no03);
        no01.inserirFilho(no02);

        no02.inserirFilho(no07);
        no02.inserirFilho(no06);
        no02.inserirFilho(no05);

        no03.inserirFilho(no08);

        no04.inserirFilho(no10);
        no04.inserirFilho(no09);

        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(no01);

        System.out.println(arvore);
        System.out.println(arvore.pertence(7));
        System.out.println(arvore.pertence(55));
        System.out.println(arvore.contarNos());
        System.out.println(arvore.buscar(7).getInfo());

    }

}

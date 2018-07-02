package br.naria;

/**
 * @author vinic
 */
public class Arvore<T> {

    private NoArvore<T> raiz;
    
    public Arvore() {}

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }   

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String obterRepresentacaoTextual(NoArvore<T> no) {
        return null;
    }
    
    private boolean buscar(T info) {
        return false;
    }
    
    private boolean buscar(NoArvore<T> no, T info) {
        return false;
    }
    
    public int contarNos() {
        return contarNos(raiz) + 1;
    }
    
    private int contarNos(NoArvore<T> no) {
        int aux = 0;
        NoArvore<T> p = no.getPrimeiro();
        System.out.println(no.getInfo());
        while(p != null) {
            aux += contarNos(p);
            aux++;
            p = p.getProximo();
        }
        return aux;
    }
    
    public boolean pertence(T info) {
        if(this.raiz == null) {
            return false;
        } else {
            return this.pertence(raiz, info);
        }
    }
    
    private boolean pertence(NoArvore<T> no, T info) {
        if(no.getInfo() == info) {
            return true;
        } else {
            NoArvore<T> p = no.getPrimeiro();
            while(p != null) {
                if(pertence(p, info)) {
                    return true;
                }
                p = no.getProximo();
            }
        }
        return false;
    }
    
}

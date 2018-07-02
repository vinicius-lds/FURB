package br.naria;

/**
 *
 * @author vinic
 */
public class Main {

    public static void main(String[] args) {
        Arvore<Integer> a = new Arvore<>();
        a.setRaiz(new NoArvore<>(1));
        a.getRaiz().inserirFilho(new NoArvore<>(2));
        a.getRaiz().inserirFilho(new NoArvore<>(3));
        a.getRaiz().inserirFilho(new NoArvore<>(4));
        System.out.println(a.contarNos());
        
    }
    
}

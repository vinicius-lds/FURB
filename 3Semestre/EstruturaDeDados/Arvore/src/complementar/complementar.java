
import binaria.NoArvoreBinaria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class complementar<T> {

    NoArvoreBinaria<T> raiz;

    public int contaFolha() {
        return contaFolha(raiz);
    }

    private int contaFolha(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        } else if (no.getDireita() == null && no.getEsquerda() == null) {
            return 1;
        }
        return contaFolha(no.getDireita())
                + contaFolha(no.getEsquerda());
    }

    public int calculaAltura() {
        return calculaAltura(raiz);
    }

    private int calculaAltura(NoArvoreBinaria<T> no) {
        if (no == null) {
            return -1;
        }

        int alturaDireita = calculaAltura(no.getDireita());
        int alturaEsquerda = calculaAltura(no.getEsquerda());
        int maior = 0;

        if (alturaDireita > alturaEsquerda) {
            maior = alturaDireita;
        } else {
            maior = alturaEsquerda;
        }

        return 1 + maior;
    }

    public boolean degenerada() {
        return degenerada(raiz);
    }

    private boolean degenerada(NoArvoreBinaria<T> no) {
        if (no.getDireita() != null && no.getEsquerda() != null) {
            return false;
        }

        if (no.getEsquerda() != null && no.getDireita() == null) {
            return degenerada(no.getEsquerda());
        } else if (no.getDireita() != null && no.getEsquerda() == null) {
            return degenerada(no.getDireita());
        }

        return true;
    }
}

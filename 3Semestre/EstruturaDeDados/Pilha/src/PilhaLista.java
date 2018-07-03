
import listaencadeada.ListaEncadeada;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinic
 */
public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista;

    @Override
    public void push(T info) {
        this.lista.inserir(info);
    }

    @Override
    public T pop() {
        T info = this.peek();
        this.lista.retirar(info);
        return info;
    }

    @Override
    public T peek() {
        if(estaVazia()) {
            throw new PilhaVaziaException();
        }
        return this.lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return this.lista.estaVazia();
    }

    @Override
    public void liberar() {
        while(!this.estaVazia()) {
            this.pop();
        }
    }
    
}

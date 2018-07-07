/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex05;

import java.io.Serializable;

/**
 *
 * @author vinic
 */
public class Retangulo extends Forma implements Serializable {
    private int lado;
    private int altura;
    
    public Retangulo(int lado, int altura) {
        super("Retangulo");
        this.setAltura(altura);
        this.setLado(lado);
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    @Override
   public String toString() {
       return "Lado: " + this.getLado() +
              " / Altura: " + this.getAltura();
   }
    
}

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
public class Triangulo extends Forma implements Serializable {
    private int lado1;
    private int lado2;
    private int lado3;
    
    public Triangulo(int lado1, int lado2, int lado3) {
        super("Triangulo");
        this.setLado1(lado1);
        this.setLado2(lado2);
        this.setLado3(lado3);
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    public int getLado3() {
        return lado3;
    }

    public void setLado3(int lado3) {
        this.lado3 = lado3;
    }
    
    @Override
   public String toString() {
       return "Lado 1: " + this.getLado1()
            + " / Lado 2: " + this.getLado2() 
            + " / Lado 3: " + this.getLado3();
   }
}

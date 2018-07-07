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
public class Circulo extends Forma implements Serializable {
    private double raio;
    
    public Circulo(double raio) {
        super("Circulo");
        this.setRaio(raio);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    
   @Override
   public String toString() {
       return "Raio: " + this.getRaio();
   }
}

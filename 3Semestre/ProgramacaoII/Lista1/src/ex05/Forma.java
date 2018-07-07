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
public abstract class Forma implements Serializable {
    private String tipo;
    
    public Forma(String tipo) {
        this.setTipo(tipo);
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return this.tipo;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex04;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

/**
 *
 * @author vinic
 */
public class Ex04 {
    
    public static int[] resolucao(Path imagem) throws FileNotFoundException, IOException{
        
        FileInputStream fis = new FileInputStream(imagem.toFile());
        
        int[] contadores = new int[256];
        int resolucao = 400 * 400; 
        for (int i = 0; i < resolucao; i++) {
            int atual = fis.read();
            contadores[atual]++;
        }
        
        for(int i = 0; i < contadores.length; i++) {
            System.out.println(i + ": " + contadores[i]);
        }
        
        return contadores;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class PersistenciaFormas {
    
    public static void salvarFormas(ArrayList<Forma> formas, Path local) throws IOException {
        
        FileOutputStream fos = new FileOutputStream(local.toFile());
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        for (int i = 0; i < formas.size(); i++) {
            oos.writeObject(formas.get(i));
        }
        
        fos.flush();
        fos.close();
        oos.flush();
        oos.close();
        
    }
    
    public static ArrayList<Forma> carregarFormas(Path local) throws IOException, ClassNotFoundException {
        
        FileInputStream fis = new FileInputStream(local.toFile());
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        ArrayList<Forma> formas = new ArrayList();
        while(true) {
            try{
                Forma atual = (Forma) ois.readObject();
                formas.add(atual);
            } catch(IOException ioe) {
                break;
            }
        }
        
        fis.close();
        ois.close();
        
        return formas;
    }
    
}

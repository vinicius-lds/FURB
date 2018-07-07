/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author vinic
 */
public class Ex03 {
    
    public static String getFileString(String arquivo) throws FileNotFoundException, IOException{
        
        Path arqPath = Paths.get(arquivo);
        FileReader fr = new FileReader(arqPath.toFile());
        BufferedReader br = new BufferedReader(fr);
        
        String str = "";
        String linha;
        while(true) {
            linha = br.readLine();
            if(linha == null) { break; }
            str += linha + "\n";
        }
        str = str.substring(0, str.lastIndexOf('\n'));
        
        fr.close();
        br.close();
        
        return str;
    }
    
    public static void salvarArquivo(String local, String conteudo) throws IOException{
        
        Path p = Paths.get(local);
        
        Files.deleteIfExists(p);
        Files.createFile(p);
        
        FileWriter fw = new FileWriter(p.toFile());
        
        fw.write(conteudo);
        
        fw.close();
        
    }
    
    public static String processarArquivo(String local) throws FileNotFoundException, IOException {
        
        Path entrada = Paths.get(local);
        Path saida = Paths.get("src\\ex03\\saida\\" + "Saida_" + entrada.getFileName());
        
        FileReader fr = new FileReader(entrada.toFile());
        BufferedReader br = new BufferedReader(fr);
        
        String strEntrada = "";
        String linha;
        while(true) {
            linha = br.readLine();
            if(linha == null) { break; }
            strEntrada += linha + "\n";
        }
        
        fr.close();
        br.close();
        
        //letras, vogais, consoantes, espaços, palavras, linhas
        int[] contadores = new int[] {0, 0, 0, 0, 0, 0};
        boolean lastHifen = false;
        boolean lastSpace = false;
        for (int i = 0; i < strEntrada.length(); i++) {
            char ca = strEntrada.charAt(i);
            if(lastSpace && ca == ' ') { continue; }
            if(Character.isLetter(ca)) { 
                contadores[0]++;
                if(ca == 'a' || ca == 'e' || ca == 'i' || ca == 'o' || ca == 'u'
                || ca == 'A' || ca == 'E' || ca == 'I' || ca == 'O' || ca == 'U') {
                    contadores[1]++;
                } else {
                    contadores[2]++;
                }
            }
            if(ca == ' ') { contadores[3]++; contadores[4]++; }
            if(ca == '\n') { 
                contadores[5]++; 
                if(!lastHifen && !lastSpace) {
                    contadores[4]++;
                }
            }
            lastSpace = (ca == ' ' ) ? true : false;
            lastHifen = (ca == '-') ? true : false; 
        }
        
        String strSaida = "Total de Letras: " + contadores[0]
                        + "\nTotal de Vogais: " + contadores[1]
                        + "\nTotal de Consoantes: " + contadores[2]
                        + "\nTotal de Espaços: " + contadores[3]
                        + "\nTotal de Palavras: " + contadores[4]
                        + "\nTotal de Linhas: " + contadores[5];
        
        FileWriter fw = new FileWriter(saida.toFile());
        fw.write(strSaida);
        fw.close();
        
        return strSaida;
        
    }
    
}

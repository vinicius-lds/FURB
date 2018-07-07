/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JTextArea;

/**
 *
 * @author vinic
 */
public class Ex01 {
    
    public static void arqBinario(JTextArea ta) throws IOException {
        
        //Cria um path absoluto para o arquivo binario e cria o arquivo
        Path arqBinario = Paths.get("src\\ex01\\arqBinario.txt").toAbsolutePath();
        Files.deleteIfExists(arqBinario);
        Files.createFile(arqBinario);
        
        /*
            Cria um FileOutputStram atraves do arqBinario e um DataOutputStream atraves do fis
            Escreve o int 12345 no arquivo atraves do dos
            Fecha o fos e o dos
        */
        FileOutputStream fos = new FileOutputStream(arqBinario.toFile());
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeInt(12345);
        fos.close();
        dos.close();
        
        //Cria um FileInputStream atraves do arqBinario e o DataInputStream atraves do fis
        FileInputStream fis = new FileInputStream(arqBinario.toFile());
        DataInputStream dis = new DataInputStream(fis);
        
        //Le o arqBinario atraves do dis e coloca o int na var aux, depois seta o textArea com a var aux
        int aux = dis.readInt();
        ta.setText(String.valueOf(aux));
        
        //Fecha o dis e o fis
        fis.close();
        dis.close();
        
    }
    
    public static void arqTexto(JTextArea ta) throws IOException {
        
        //Cria um path absoluto para o arquivo de texto e cria o arquivo
        Path arqTexto = Paths.get("src\\ex01\\arqTexto.txt").toAbsolutePath();
        Files.deleteIfExists(arqTexto);
        Files.createFile(arqTexto);
        
        //Cria um FileOutputStram atraves do arqBinario
        FileWriter fw = new FileWriter(arqTexto.toFile());
        fw.write("12345");
        
        //Fecha o FileWriter
        fw.close();
        
        //Cria uma Filereader atraves do arqText e um BufferedReader atraves do fr
        FileReader fr = new FileReader(arqTexto.toFile());
        BufferedReader br = new BufferedReader(fr);
        
        //Le uma linha atraves do br e escreve essa linha na textArea
        ta.setText(br.readLine());
        
        //Fecha o fr e o br
        fr.close();
        br.close();
        
    }
}

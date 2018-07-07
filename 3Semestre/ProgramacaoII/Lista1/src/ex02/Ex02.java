/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author vinic
 */
public class Ex02 {
    
    public static Path resolucao(JTextField textFieldCaminho, JFormattedTextField textFieldNumero) throws IOException, IllegalArgumentException {
        if(textFieldCaminho.getText().equals("")) {
            throw new IllegalArgumentException("Você deve selecionar um arquivo de texto para criptografar.");
        }

        if(textFieldNumero.getText().equals("") || Integer.valueOf(textFieldNumero.getText()) < 1) {
            throw new IllegalArgumentException("Você deve digitar um numero maior que 0 para ser usado de parametro na criptografia.");
        }

        Path arqOriginal = Paths.get(textFieldCaminho.getText());
        Path arqCriptografado = Ex02.getCaminhoDestino(arqOriginal);
        
        Files.deleteIfExists(arqCriptografado);
        Files.createFile(arqCriptografado);

        FileReader fr = new FileReader(arqOriginal.toFile());
        BufferedReader bf = new BufferedReader(fr);

        String conteudo = "";
        String linha;
        while(true) {
            linha = bf.readLine();
            if(linha == null) { break; }
            conteudo += linha + "\n";
        }
        conteudo = conteudo.substring(0, conteudo.lastIndexOf('\n'));

        int k = Integer.valueOf(textFieldNumero.getText());
        char[] contChar = conteudo.toCharArray();
        for (int i = 0; i < conteudo.length(); i++) {

            if(contChar[i] > 31 && contChar[i] < 127) {
                contChar[i] =  charMaisK(contChar[i], k);
            }

        }
        
        conteudo = String.valueOf(contChar);
        
        FileWriter fw = new FileWriter(arqCriptografado.toFile());
        fw.write(conteudo);
        fw.close();
        
        return arqCriptografado;
    }
    
    private static char charMaisK(char c, int k) {
        
        if(k + c > 126) {
            return charMaisK((char)32, 126 - c);
        }
        
        if(k + c < 32) {
            return charMaisK((char)126, 126 + c);
        }
        
        return (char) (k + c);
    
    } 
    
    private static Path getCaminhoDestino(Path arqOriginal) {
        return Paths.get("src\\ex02\\" + arqOriginal.getName(arqOriginal.getNameCount() - 1).toString().substring(0, arqOriginal.getName(arqOriginal.getNameCount() - 1).toString().length() - 4) + "Saida.txt").toAbsolutePath();
    }
    
    public static void abreFileChooser(JTextField tf, JFrame frame) {
        JFileChooser jfc = new JFileChooser(Paths.get("").toAbsolutePath().toString());
        jfc.setDialogTitle("Procurar Arquivo");
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de Texto", "txt"));
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        if(jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            tf.setText(jfc.getSelectedFile().toString());
        }
    }
    
}

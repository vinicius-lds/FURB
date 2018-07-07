/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.nio.file.Paths;
import java.nio.file.Paths;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author vinic
 */
public class FileChooser {
    
    private static JFileChooser jfc;
    
    //Retorna o caminho escolhido, ou null se nenhuma caminho foi escolhido
    public static String open() {
        
        jfc = getFileChooser(null);
        return (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) ? jfc.getSelectedFile().toString() : null;
    
    }
    
    public static String open(JFrame relativeTo) {
        
        jfc = getFileChooser(null);
        return (jfc.showOpenDialog(relativeTo) == JFileChooser.APPROVE_OPTION) ? jfc.getSelectedFile().toString() : null;
    
    }
    
    public static String open(String pastaInicial) {
        
        jfc = getFileChooser(pastaInicial);
        return (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) ? jfc.getSelectedFile().toString() : null;
        
    }
    
    public static String open(String pastaInicial, JFrame relativeTo) {
        
        jfc = getFileChooser(pastaInicial);
        return (jfc.showOpenDialog(relativeTo) == JFileChooser.APPROVE_OPTION) ? jfc.getSelectedFile().toString() : null;
        
    }
    
    public static String open(JFrame relativeTo, String pastaInicial, String titulo, String descricaoArquivo, String[] extensoes, int arquivosAceitos) {
        jfc = getFileChooser(pastaInicial);
        jfc.setDialogTitle(titulo);
        jfc.setFileFilter(getFileNameExtensionFilter(descricaoArquivo, extensoes));
        jfc.setFileSelectionMode(arquivosAceitos);
        
        return (jfc.showOpenDialog(relativeTo) == JFileChooser.APPROVE_OPTION) ? jfc.getSelectedFile().toString() : null;
    }
    
    public static String open(JFrame relativeTo, String pastaInicial, String titulo, String descricaoArquivo, String[] extensoes, String descrisaoBotaoAprovacao, int arquivosAceitos) {
        jfc = getFileChooser(pastaInicial);
        jfc.setDialogTitle(titulo);
        jfc.setFileFilter(getFileNameExtensionFilter(descricaoArquivo, extensoes));
        jfc.setFileSelectionMode(arquivosAceitos);
        jfc.setApproveButtonText(descrisaoBotaoAprovacao);
        
        return (jfc.showOpenDialog(relativeTo) == JFileChooser.APPROVE_OPTION) ? jfc.getSelectedFile().toString() : null;
    }
    
    private static JFileChooser getFileChooser(String caminho) {
        return (caminho == null) ? new JFileChooser() : new JFileChooser(caminho);
    }
    
    private static FileNameExtensionFilter getFileNameExtensionFilter(String descricaoArquivo, String[] extensoes) {
        return new FileNameExtensionFilter(descricaoArquivo, extensoes);  
    }
    
}

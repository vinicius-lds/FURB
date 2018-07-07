/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slides;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author vinic
 */
public class Slide01 {
    public static void exemplo01() throws IOException {
        
        //Cria um path vazio e chama o método para tranformmar ele no path atual
        //C:\Users\vinic\Desktop\Projetos no NetBeans\Lista1
        Path atual = Paths.get("").toAbsolutePath();
        
        System.out.println(
                
                "Caminho: " + atual.toString()
                + "\nÉ diretório ? " + Files.isDirectory(atual)
                + "\nTamanho: " + Files.size(atual) + " bytes"
                + "\nProprietario: " + Files.getOwner(atual).getName()
                + "\nNome do arquivo: " + atual.getFileName()
                + "\nNome do segundo diretório explícito no caminho: " + atual.getName(1)
                + "\nNúmero de diretórios explícitos no caminho: " + atual.getNameCount()
                + "\nSubcaminho com os dois primeiros diretórios apenas: " + atual.subpath(0, 2)
                + "\nDiretório pai do caminho atual: " + atual.getParent()
                + "\nUnidade de disco em que está o caminho: " + atual.getRoot()
        
        );
        
        //Cria um objeto onde é possivel acessar alguns atributos basicos do caminho
        BasicFileAttributes attrs = Files.readAttributes(atual, BasicFileAttributes.class);
        
        System.out.println(
        
                "\nÉ diretório? " + attrs.isDirectory()
                + "\nÚltimo acesso: " + attrs.lastAccessTime()
                + "\nÚltima modificação em: " + attrs.lastModifiedTime()
                + "\nTamanho: " + attrs.size() + " bytes"
        
        );
        
        //Cria um objeto onde é possivel itinerar sobre o conteúdo de um diretório
        DirectoryStream<Path> stream = Files.newDirectoryStream(atual);
        
        System.out.println("");
        for(Path p: stream) {
            System.out.println(p.getFileName());
        }
        
        //Tranforma o caminho atual, no caminho onde está o código fonte o packge slides
        atual = Paths.get("src\\slides");
        
        //Cria um arquivo Teste.txt no diretório atual e deleta o mesmo se ele ja existir
        Path arquivoTeste = Paths.get("teste.txt");
        Files.deleteIfExists(arquivoTeste);
        Files.createFile(arquivoTeste);
        
        //Cria um caminho para o diretório Teste, e se esse diretorio ainda não existe, ele é criado
        Path diretorio = atual.resolve("Teste");
        if(!Files.exists(diretorio)) {
            Files.createDirectory(diretorio);
        }
        
        //Cria um path novo para o arquivoTeste dentro do diretorio
        Path novo = diretorio.resolve(arquivoTeste);
        Files.move(arquivoTeste, novo, REPLACE_EXISTING);
        
        
    }
}

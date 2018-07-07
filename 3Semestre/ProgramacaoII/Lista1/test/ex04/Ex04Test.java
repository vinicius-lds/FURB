/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex04;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author vinic
 */
public class Ex04Test {
    
    public Ex04Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of resolucao method, of class Ex04.
     */
    @Test
    public void testResolucao() throws IOException{
        
        Path p = Paths.get("src\\ex04\\imagem.raw");
        
        Files.deleteIfExists(p);
        Files.createFile(p);
        
        FileOutputStream fos = new FileOutputStream(p.toFile());
        DataOutputStream dos = new DataOutputStream(fos);
        
        int qtd[] = new int[256];
        int resolucao = 400 * 400;
        Random r = new Random();
        int nr;
        for (int i = 0; i < resolucao; i++) {
            nr = r.nextInt(256);
            dos.write(nr);
            qtd[nr]++;
        }
        
        fos.close();
        dos.close();
        
        Ex04.resolucao(p);
    }
    
}

package questao3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;
import java.util.Vector;

/**
 * @author Vinícius Luis da Silva
 */
public class Main {
    
    public static void main(String[] args) {
        
        int[] valores = Main.getValores(100000);
        Collection[] colecoes = new Collection[] {
            new LinkedList(),
            new ArrayList(),
            new Vector(),
            new HashSet(),
            new LinkedHashSet(),
            new TreeSet(),
            new PriorityQueue(),
            new ArrayDeque()
        };
        
        Main.exibirTempoIncluir(colecoes, valores);
        Main.exibirTempoToString(colecoes);
        Main.exibirTempoEncontrarUltimoValor(colecoes, valores);
        Main.exibirTempoEncontrarContains(colecoes, 99000000);
        Main.exibirTempoRemocaoIterator(colecoes);
        
    }
    
    public static int[] getValores(int tamanho) {
        Random r = new Random();
        int[] valores = new int[tamanho];
        int base = 100 * tamanho;
        for (int i = 0; i < valores.length - 1; i++) {
            valores[i] = r.nextInt(base) + 1;
        }
        valores[valores.length - 2] = base + 1;
        return valores;
    }
    
    public static void exibirTempoIncluir(Collection[] colecoes, int[] valores) {
        long tempoDeInclusao;
        System.out.println("----------TEMPO DE INCLUSÃO DOS VALORES----------");
        for(Collection colecao: colecoes) {
            tempoDeInclusao = System.nanoTime();
            Main.inserirEm(colecao, valores);
            tempoDeInclusao -= System.nanoTime();
            tempoDeInclusao *= -1;
            System.out.println(tempoDeInclusao + " - " + colecao.getClass().getName());
        }
        System.out.println("-------------------------------------------------");
    }
    
    public static void inserirEm(Collection colecao, int[] valores) {
        for(int i = 0; i < valores.length; i++) {
            colecao.add(valores[i]);
        }
    }
    
    public static void exibirTempoEncontrarUltimoValor(Collection[] colecoes, int[] valores) {
        int ultimoValor = valores[valores.length - 1];
        long tempoDePesquisa;
        System.out.println("----------TEMPO DE PROCURA COM O ITERATOR----------");
        for(Collection colecao: colecoes) {
            tempoDePesquisa = System.nanoTime();
            Main.encontarIterator(colecao, ultimoValor);
            tempoDePesquisa -= System.nanoTime();
            tempoDePesquisa *= -1;
            System.out.println(tempoDePesquisa + " - " + colecao.getClass().getName());
        }
        System.out.println("---------------------------------------------------");
    }
    
    public static void encontarIterator(Collection colecao, int valor) {
        Iterator iterator = colecao.iterator();
        Object aux;
        while(iterator.hasNext()) {
            aux = iterator.next();
            if(aux.equals(valor)) {
                break;
            }
        }
    }
    
    public static void exibirTempoEncontrarContains(Collection[] colecoes, int encontar) {
        long tempoDePesquisa;
        System.out.println("----------TEMPO DE PROCURA COM O CONTAINS----------");
        for(Collection colecao: colecoes) {
            tempoDePesquisa = System.nanoTime();
            colecao.contains(encontar);
            tempoDePesquisa -= System.nanoTime();
            tempoDePesquisa *= -1;
            System.out.println(tempoDePesquisa + " - " + colecao.getClass().getName());
        }
        System.out.println("---------------------------------------------------");
    }
    
    public static void exibirTempoRemocaoIterator(Collection[] colecoes) {
        long tempoDeRemocao;
        System.out.println("----------TEMPO DE EXCLUSAO----------");
        for(Collection colecao: colecoes) {
            tempoDeRemocao = System.nanoTime();
            Main.removerIterator(colecao);
            tempoDeRemocao -= System.nanoTime();
            tempoDeRemocao *= -1;
            System.out.println(tempoDeRemocao + " - " + colecao.getClass().getName());
        }
        System.out.println("-------------------------------------");
    }
    
    public static void removerIterator(Collection colecao) {
        Iterator iterator = colecao.iterator();
        Object valor;
        boolean remover = true;
        while(iterator.hasNext()) {
            valor = iterator.next();
            if(remover) {
                iterator.remove();
            }
            remover = !remover;
        }
    }
    
    public static void exibirTempoToString(Collection[] colecoes) {
        long tempoDeToString;
        System.out.println("----------TEMPO DO TOSTRING----------");
        for(Collection colecao: colecoes) {
            tempoDeToString = System.nanoTime();
            colecao.toString();
            tempoDeToString -= System.nanoTime();
            tempoDeToString *= -1;
            System.out.println(tempoDeToString + " - " + colecao.getClass().getName());
        }
        System.out.println("-------------------------------------");
    }
    
}

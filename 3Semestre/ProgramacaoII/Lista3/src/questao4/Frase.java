package questao4;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Vinícius Luis da Silva
 */
public class Frase {

    private SortedMap<String, Integer> palavras;
    private String frase;

    public Frase(String frase) {
        this.setFrase(frase);
    }

    private void contarPalavras(String[] palavras) {
        this.palavras = new TreeMap<>();
        for (String palavra: palavras) {
            if(this.palavras.containsKey(palavra)) {
                this.palavras.replace(palavra, this.palavras.get(palavra) + 1);
            } else {
                this.palavras.put(palavra, 1);
            }
        }
    }

    public void setFrase(String frase) {
        frase = (frase.isEmpty()) ? "Eu estou escrevendo um programa, mas eu não tenho um programa para escrever." : frase;
        frase = frase.toLowerCase();
        frase = frase.replaceAll("\\s+", " ");
        frase = frase.replace(".", "");
        frase = frase.replace("/", "");
        frase = frase.replace("-", "");
        frase = frase.replace(".", "");
        frase = frase.replace(",", "");
        frase = frase.replace(";", "");
        frase = frase.replace("!", "");
        frase = frase.replace("?", "");
        this.frase = frase;
        this.contarPalavras(this.frase.split(" "));
    }

    public String getPalavras() {
        return this.palavras.toString();
    }

    @Override
    public String toString() {
        return this.frase;
    }

}

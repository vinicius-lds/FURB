package prova3;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * @author Vinícius Luis da Silva
 */
public class Deposito {

    private TreeMap<Integer, Produto> produtos;

    public Deposito() {
        this.produtos = new TreeMap<>();
    }

    public void incluirProduto(Produto p) {
        this.produtos.put(p.getCodigo(), p);
    }

    public Produto buscarProduto(int i) {
        return produtos.get(i);
    }

    public boolean excluirProduto(int i) {
        return this.produtos.remove((Integer) i) == null;
    }

    public int getQtdProdutos() {
        return this.produtos.keySet().size();
    }

    public int getUnidadeEstoque() {
        int qtd = 0;
        for(Produto p: this.produtos.values()) {
            qtd += p.getQtdEstoque();
        }
        return qtd;
    }

    public Iterator iterator() {
        return this.produtos.values().iterator();
    }

    public int getUltimoCodigo() {
        try {
            return this.produtos.lastKey();
        } catch (Exception e) {
            return -1;
        }
    }

}

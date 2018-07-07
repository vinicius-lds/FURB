package prova3;

/**
 * @author Vinícius Luis da Silva
 */
public class Main {
    public static void main(String[] args) {
        Deposito d = new Deposito();
        d.incluirProduto(new Produto(1, "p1", 0, 2));
        d.incluirProduto(new Produto(5, "p5", 0, 3));
        d.incluirProduto(new Produto(3, "p3", 0, 3));
        d.incluirProduto(new Produto(2, "p2", 0, 3));
        d.incluirProduto(new Produto(4, "p4", 0, 3));
        System.out.println(d.buscarProduto(1));
    }
}

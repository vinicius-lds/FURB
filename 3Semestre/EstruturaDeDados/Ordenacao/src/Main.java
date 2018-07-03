/**
 * @author Vinícius Luis da Silva
 */
public class Main {
    public static void main(String[] args) {
        OrdenacaoAbstract<Integer> o = new OrdenacaoBolha<Integer>();
        o.setInfo(new Integer[]{2,6,2,3,2,2,5,4,4,5,4,5,5,54,4,25,4,7});
        System.out.println("antes: " + o);
        o.ordenar();
        System.out.println("depois: " + o);
        o = new OrdenacaoMergesort<Integer>();
        o.setInfo(new Integer[]{2,6,2,3,2,2,5,4,4,5,4,5,5,54,4,25,4,7});
        System.out.println("antes: " + o);
        o.ordenar();
        System.out.println("depois: " + o);
        o = new OrdenacaoQuicksort<Integer>();
        o.setInfo(new Integer[]{2,6,2,3,2,2,5,4,4,5,4,5,5,54,4,25,4,7});
        System.out.println("antes: " + o);
        o.ordenar();
        System.out.println("depois: " + o);
    }
}

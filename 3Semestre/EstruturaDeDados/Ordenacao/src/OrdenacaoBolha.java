/**
 * @author Vinícius Luis da Silva
 */
public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T>{

    @Override
    public void ordenar() {
        super.trimm();
        
        int i, j;
        int n = super.getInfo().length;
        boolean trocou;
        
        for(i = n - 1; i > 0; i--) {
            trocou = false;
            for (j = 0; j < i; j++) {
                if(super.getInfo()[j].compareTo(super.getInfo()[j + 1]) > 0) {
                    super.trocar(j, j + 1);
                    trocou = true;
                }
            }
            if(!trocou) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        OrdenacaoBolha<Integer> ints = new OrdenacaoBolha<>();
        ints.setInfo(new Integer[]{null,3,6,5,2,3,2,1,3,6,9,7,8,4,1,2,3,5,8,null});
        ints.ordenar();
        System.out.println(ints.toString());
    }
    
}

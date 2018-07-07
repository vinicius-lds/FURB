package questao1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author Vinícius Luis da Silva
 */
public class Main {

    public static void main(String[] args) {
        Veiculo a = new Veiculo("MJT-7432", "Fusca", 1912, "Pedro");
        Veiculo b = new Veiculo("MIT-8008", "Celta", 1999, "Douglas");
        Veiculo c = new Veiculo("MEI-4665", "Gol", 2002, "Carlos");
        Veiculo d = new Veiculo("MIO-6668", "Fusca", 1915, "Aline");
        Veiculo e = new Veiculo("DIO-3333", "Celta", 1999, "Fausto");
        Veiculo f = new Veiculo("PAO-6472", "C3", 2007, "Carolina");
        Veiculo g = new Veiculo("CAO-2890", "C4", 2012, "Kelvin");
        Veiculo h = new Veiculo("UVA-3939", "BMW", 2015, "Zé");
        Veiculo i = new Veiculo("OVO-0000", "Gol", 2000, "Joshua");
        Veiculo j = new Veiculo("ABC-1234", "Ferrari", 2015, "Marta");
        LinkedList<Veiculo> list = new LinkedList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.add(g);
        list.add(h);
        list.add(i);
        list.add(j);
        
        list.remove(a);
        list.remove(7);
        ListIterator<Veiculo> iterator = list.listIterator(list.size());
        for (int k = 0; iterator.hasPrevious(); k++) {
            iterator.previous();
            if(k == 2) {
                iterator.remove();
                break;
            }
        }
        
        Collections.sort(list);
        Collections.shuffle(list);
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(((Veiculo)o1).getModelo().compareTo(((Veiculo)o2).getModelo()) > 0) {
                    return 1;
                } else {
                    if(((Veiculo)o1).getAno() > ((Veiculo)o2).getAno()) {
                        return 1;
                    } else {
                        return ((Veiculo)o1).compareTo(((Veiculo)o2));
                    }
                }
            }
        };
        Collections.sort(list, comparator);
        System.out.println(list.toString());
    }

}

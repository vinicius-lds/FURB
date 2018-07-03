
/**
 * @author Vinícius Luis da Silva
 */
public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(super.getRaiz(), info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        }
        if (no.getInfo().equals(info)) {
            return no;
        } else {
            if (info.compareTo(no.getInfo()) < 0) {
                return buscar(no.getEsquerda(), info);
            } else {
                return buscar(no.getDireita(), info);
            }
        }
    }

    public void inserir(T info) {
        NoArvoreBinaria<T> no = new NoArvoreBinaria<>(info);
        NoArvoreBinaria<T> p;
        NoArvoreBinaria<T> pai;

        if (super.getRaiz() == null) {
            super.setRaiz(no);
        } else {
            p = super.getRaiz();
            while (true) {
                pai = p;
                if (info.compareTo(p.getInfo()) < 0) {
                    p = pai.getEsquerda();
                    if (p == null) {
                        pai.setEsquerda(no);
                        return;
                    }
                } else {
                    p = pai.getDireita();
                    if (p == null) {
                        pai.setDireita(no);
                        return;
                    }
                }
            }
        }
    }
    
    public void retirar(T info) {
        NoArvoreBinaria<T> p = super.getRaiz();
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;
        
        while((p != null) && (!p.getInfo().equals(info))) {
            pai = p;
            if(info.compareTo(p.getInfo()) < 0) {
                filhoEsquerda = true;
                p = p.getEsquerda();
            } else {
                filhoEsquerda = false;
                p = p.getDireita();
            }
        }
        
        if(p != null) {
            if((p.getEsquerda() == null) && (p.getDireita()== null)) {
                if(p == super.getRaiz()) {
                    super.setRaiz(null);
                } else {
                    if(filhoEsquerda) {
                        pai.setEsquerda(null);
                    } else {
                        pai.setDireita(null);
                    }
                }
            } else {
                if(p.getDireita() == null) {
                    if(p == super.getRaiz()) {
                       super.setRaiz(p.getEsquerda());
                    } else {
                        if(filhoEsquerda) {
                            pai.setEsquerda(p.getEsquerda());
                        } else {
                            pai.setDireita(p.getEsquerda());
                        }
                    }
                } else {
                    if(p.getEsquerda() == null) {
                        if(p == super.getRaiz()) {
                            super.setRaiz(p.getDireita());
                        } else {
                            if(filhoEsquerda) {
                                pai.setEsquerda(p.getDireita());
                            } else {
                                pai.setDireita(p.getDireita());
                            }
                        }
                    } else {
                        NoArvoreBinaria<T> sucessor = this.extrairSucessor(p);
                        if(p == super.getRaiz()) {
                            super.setRaiz(sucessor);
                        } else {
                            if(filhoEsquerda) {
                                pai.setEsquerda(sucessor);
                            } else {
                                pai.setDireita(sucessor);
                            }
                        }
                        sucessor.setEsquerda(p.getEsquerda());
                    }
                }
            }
        }
        
    }
    
    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> excluir) {
        NoArvoreBinaria<T> p = excluir.getDireita();
        NoArvoreBinaria<T> paiSecessor = excluir;
        NoArvoreBinaria<T> sucessor = excluir;
        while(p != null) {
            paiSecessor = sucessor;
            sucessor = p;
            p = p.getEsquerda();
        }
        if(sucessor != excluir.getDireita()) {
            paiSecessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(excluir.getDireita());
        }
        return sucessor;
    }

}

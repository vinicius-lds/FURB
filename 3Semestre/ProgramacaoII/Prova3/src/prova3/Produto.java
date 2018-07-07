package prova3;

/**
 * @author Vinícius Luis da Silva
 */
public class Produto {
    
    private int codigo;
    private String descricao;
    private double valor;
    private int qtdEstoque;

    public Produto(int codigo, String descricao, double valor, int qtdEstoque) {
        this.setCodigo(codigo);
        this.setQtdEstoque(qtdEstoque);
        this.setDescricao(descricao);
        this.setValor(valor);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Código: " + this.getCodigo() + " produto: " + this.getDescricao();
    }
    
}

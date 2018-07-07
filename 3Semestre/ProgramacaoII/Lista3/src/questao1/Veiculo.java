package questao1;

/**
 * @author Vinícius Luis da Silva
 */
public class Veiculo implements Comparable<Veiculo>{
    
    private String placa;
    private String modelo;
    private int ano;
    private String proprietario;

    public Veiculo(String placa, String modelo, int ano, String proprietario) {
        this.setAno(ano);
        this.setModelo(modelo);
        this.setPlaca(placa);
        this.setProprietario(proprietario);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Veículo: " + this.getModelo() + ", placa " + this.getPlaca() + ", ano " + this.getAno() + ", de " + this.getProprietario();
    }

    @Override
    public int compareTo(Veiculo o) {
        return o.getPlaca().compareTo(this.getPlaca());
    }
    
}

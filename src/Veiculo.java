public class Veiculo {
    public String marca;
    public String modelo;
    public String placa;
    public int ano;
    public boolean disponivel;
    public double preco;

    public Veiculo(String marca, String modelo, String placa, int ano, double preco){
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.preco = preco;
    }

    public void mudarDisponibilidade(boolean disponivel){
        this.disponivel = false;
    }
}

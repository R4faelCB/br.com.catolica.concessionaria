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
        this.disponivel = true;
    }

    public void mudarDisponibilidade(boolean disponivel){
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return String.format("Veiculo:\n Disponivel,\n Marca = %s,\n Modelo = %s,\n Placa = %s,\n Ano = %d,\n Preço R$ %.2f",this.disponivel, this.marca, this.modelo, this.placa, this.ano, this.preco);
    }
}

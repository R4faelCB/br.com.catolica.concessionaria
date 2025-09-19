public class Venda {
    public Cliente cliente;
    public Veiculo veiculo;
    public String dataVenda;
    public double valorVenda;
    public String formaPagamento;

    public Venda(Cliente cliente, Veiculo veiculo, String dataVenda, double valorVenda, String formaPagamento){
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return String.format("Venda feita:\n Cliente: %s,\n Veiculo: %s,\n Data da Venda %s,\n Valor da Venda R$ %.2f,\n Forma de Pagamento: %s", this.cliente, this.veiculo, this.dataVenda, this.valorVenda, this.formaPagamento);
    }
}

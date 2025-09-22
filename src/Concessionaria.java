import java.util.ArrayList;

public class Concessionaria {
        public String nome;
        public ArrayList<Veiculo> veiculos;
        public ArrayList<Cliente> clientes;
        public ArrayList<Venda> vendas;
        public int totalVeiculos;
        public int totalClientes;
        public int totalVendas;

    public Concessionaria(String nome){
        this.nome = nome;
        this.veiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public boolean adicionarVeiculo(Veiculo veiculo){
        for (int index = 0; index < this.totalVeiculos; index++){
            if(this.veiculos.get(index).placa.equals(veiculo.placa)){
                return false;
            }
        }

        boolean statusInserimento = this.veiculos.add(veiculo);
        if(statusInserimento){
            this.totalVeiculos++;
        }
        return statusInserimento;
    }

    public boolean removerVeiculo(String placa){
        for (int index = 0; index < this.totalVeiculos; index++){
            if(this.veiculos.get(index).placa.equals(placa)){
                Veiculo veiculoBuscado = this.veiculos.get(index);
                this.veiculos.remove(veiculoBuscado);
                this.totalVeiculos--;
                return true;
            }
        }
        return false;
    }

    public ArrayList<Veiculo> buscarVeiculoporMarca(String marca){
        ArrayList<Veiculo> veiculosbuscados = new ArrayList<>();
        for (int index = 0; index < this.totalVeiculos; index++){
            if(this.veiculos.get(index).marca.toLowerCase().contains(marca.toLowerCase())){
                Veiculo veiculo = this.veiculos.get(index);
                veiculosbuscados.add(veiculo);
            }
        }
        return veiculosbuscados;
    }

    public ArrayList<Veiculo> buscarVeiculoporModelo(String modelo){
        ArrayList<Veiculo> veiculosbuscados = new ArrayList<>();
        for (int index = 0; index < this.totalVeiculos; index++){
            if(this.veiculos.get(index).modelo.toLowerCase().contains(modelo.toLowerCase())){
                Veiculo veiculo = this.veiculos.get(index);
                veiculosbuscados.add(veiculo);
            }
        }
        return veiculosbuscados;
    }

    public boolean cadastrarCliente(Cliente cliente){
        for (int index = 0; index < this.totalClientes; index++){
            if(this.clientes.get(index).id == cliente.id){
                return false;
            }
        }

        boolean  statusInserimento = this.clientes.add(cliente);
        if(statusInserimento){
            this.totalClientes++;
        }
        return statusInserimento;

    }

    public boolean removerCliente(int id){
        for (int index = 0; index < this.totalClientes; index++){
            if(this.clientes.get(index).id == (id)){
                Cliente clienteBuscado = this.clientes.get(index);
                this.clientes.remove(index);
                this.totalClientes--;
                return true;
            }
        }
        return false;
    }

    public boolean realizarVenda(String placa, int idCliente, String dataVenda, String formaPagamento, double valor){
        Veiculo veiculo = null;

        for ( int index = 0; index < this.totalVeiculos; index++){
            if(this.veiculos.get(index).placa.equals(placa)){
                this.veiculos.get(index).disponivel = false;
                veiculo = this.veiculos.get(index);
                break;
            }
        }

        Cliente cliente = null;

        for (int index = 0; index < this.totalClientes; index++){
            if(this.clientes.get(index).id == (idCliente)){
                cliente = this.clientes.get(index);
                break;
            }
        }

        if(veiculo == null || cliente == null){
            return false;
        }

        Venda venda = new Venda(
                cliente,
                veiculo,
                dataVenda,
                valor,
                formaPagamento
        );

        boolean statusVenda = this.vendas.add(venda);
        if (statusVenda){
            this.totalVendas++;
        }

        return statusVenda;
    }

    public ArrayList<Veiculo> listarVeiculosDisponiveis(boolean disponivel) {
        ArrayList<Veiculo> buscarDisponiveis = new ArrayList<>();
        for (int index = 0; index < totalVeiculos; index++) {
            if (this.veiculos.get(index).disponivel == disponivel) {
                buscarDisponiveis.add(this.veiculos.get(index));
            }
        }
        return buscarDisponiveis;
    }

    public ArrayList<Venda> listarTodasVendas(Venda venda) {
        return new ArrayList<>(this.vendas);
    }

    @Override
    public String toString() {
        return String.format("Concessionaria:\n Total de Venda = %d,\n Total de Veiculos = %d,\n Total de Clientes = %d.", this.totalVendas, this.totalVeiculos, this.totalClientes);
    }
}



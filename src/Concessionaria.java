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
            if(this.clientes.get(index).id.equals(cliente.id)){
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
            if(this.clientes.get(index).id.equals(id)){
                Cliente clienteBuscado = this.clientes.get(index);
                this.clientes.remove(index);
                this.totalClientes--;
                return true;
            }
        }
        return false;
    }
}

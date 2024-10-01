import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendedorService {
    private List<Vendedor> vendedores = new ArrayList<>();

    // Método para inserir um novo vendedor
    public void inserirVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
        System.out.println("Vendedor inserido com sucesso.");
    }

    // Método para buscar um vendedor pelo código
    public Optional<Vendedor> buscarVendedor(Integer codigo) {
        return vendedores.stream()
                .filter(vendedor -> vendedor.getCodigo().equals(codigo))
                .findFirst();
    }

    // Método para alterar os dados de um vendedor
    public boolean alterarVendedor(Vendedor vendedorAtualizado) {
        Optional<Vendedor> vendedorOpt = buscarVendedor(vendedorAtualizado.getCodigo());
        if (vendedorOpt.isPresent()) {
            Vendedor vendedorExistente = vendedorOpt.get();
            vendedorExistente.setNome(vendedorAtualizado.getNome());
            vendedorExistente.setSexo(vendedorAtualizado.getSexo());
            vendedorExistente.setCpf(vendedorAtualizado.getCpf());
            vendedorExistente.setEmail(vendedorAtualizado.getEmail());
            vendedorExistente.setCelular(vendedorAtualizado.getCelular());
            System.out.println("Vendedor alterado com sucesso.");
            return true;
        } else {
            System.out.println("Vendedor não encontrado.");
            return false;
        }
    }

    // Método para excluir um vendedor pelo código
    public boolean excluirVendedor(Integer codigo) {
        Optional<Vendedor> vendedorOpt = buscarVendedor(codigo);
        if (vendedorOpt.isPresent()) {
            vendedores.remove(vendedorOpt.get());
            System.out.println("Vendedor excluído com sucesso.");
            return true;
        } else {
            System.out.println("Vendedor não encontrado.");
            return false;
        }
    }

    // Método para listar todos os vendedores
    public List<Vendedor> listarVendedores() {
        return vendedores;
    }
}
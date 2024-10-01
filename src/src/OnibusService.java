import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OnibusService {
    private List<Onibus> onibusList = new ArrayList<>();

    // Método para inserir um novo ônibus
    public void inserirOnibus(Onibus onibus) {
        onibusList.add(onibus);
        System.out.println("Ônibus inserido com sucesso.");
    }

    // Método para buscar um ônibus pelo código
    public Optional<Onibus> buscarOnibus(Integer codigoOnibus) {
        return onibusList.stream()
                .filter(onibus -> onibus.getCodigoOnibus().equals(codigoOnibus))
                .findFirst();
    }

    // Método para alterar os dados de um ônibus
    public boolean alterarOnibus(Onibus onibusAtualizado) {
        Optional<Onibus> onibusOpt = buscarOnibus(onibusAtualizado.getCodigoOnibus());
        if (onibusOpt.isPresent()) {
            Onibus onibusExistente = onibusOpt.get();
            onibusExistente.setPlaca(onibusAtualizado.getPlaca());
            onibusExistente.setQuantidadeAssentos(onibusAtualizado.getQuantidadeAssentos());
            System.out.println("Ônibus alterado com sucesso.");
            return true;
        } else {
            System.out.println("Ônibus não encontrado.");
            return false;
        }
    }

    // Método para excluir um ônibus pelo código
    public boolean excluirOnibus(Integer codigoOnibus) {
        Optional<Onibus> onibusOpt = buscarOnibus(codigoOnibus);
        if (onibusOpt.isPresent()) {
            onibusList.remove(onibusOpt.get());
            System.out.println("Ônibus excluído com sucesso.");
            return true;
        } else {
            System.out.println("Ônibus não encontrado.");
            return false;
        }
    }

    // Método para listar todos os ônibus
    public List<Onibus> listarOnibus() {
        return onibusList;
    }
}

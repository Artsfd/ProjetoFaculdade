import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ViagemService {
    private List<Viagem> viagens = new ArrayList<>();

    // Método para inserir uma nova viagem
    public void inserirViagem(Viagem viagem) {
        viagens.add(viagem);
        System.out.println("Viagem inserida com sucesso.");
    }

    // Método para buscar uma viagem pelo código
    public Optional<Viagem> buscarViagem(Integer codigoViagem) {
        return viagens.stream()
                .filter(viagem -> viagem.getCodigoViagem().equals(codigoViagem))
                .findFirst();
    }

    // Método para alterar os dados de uma viagem
    public boolean alterarViagem(Viagem viagemAtualizada) {
        Optional<Viagem> viagemOpt = buscarViagem(viagemAtualizada.getCodigoViagem());
        if (viagemOpt.isPresent()) {
            Viagem viagemExistente = viagemOpt.get();
            viagemExistente.setCodigoOnibus(viagemAtualizada.getCodigoOnibus());
            viagemExistente.setCidadeOrigem(viagemAtualizada.getCidadeOrigem());
            viagemExistente.setDataSaida(viagemAtualizada.getDataSaida());
            viagemExistente.setHorarioSaida(viagemAtualizada.getHorarioSaida());
            viagemExistente.setCidadeDestino(viagemAtualizada.getCidadeDestino());
            viagemExistente.setDataChegada(viagemAtualizada.getDataChegada());
            viagemExistente.setHorarioChegada(viagemAtualizada.getHorarioChegada());
            viagemExistente.setValorPassagem(viagemAtualizada.getValorPassagem());
            System.out.println("Viagem alterada com sucesso.");
            return true;
        } else {
            System.out.println("Viagem não encontrada.");
            return false;
        }
    }

    // Método para excluir uma viagem pelo código
    public boolean excluirViagem(Integer codigoViagem) {
        Optional<Viagem> viagemOpt = buscarViagem(codigoViagem);
        if (viagemOpt.isPresent()) {
            viagens.remove(viagemOpt.get());
            System.out.println("Viagem excluída com sucesso.");
            return true;
        } else {
            System.out.println("Viagem não encontrada.");
            return false;
        }
    }

    // Método para listar todas as viagens
    public List<Viagem> listarViagens() {
        return viagens;
    }
}
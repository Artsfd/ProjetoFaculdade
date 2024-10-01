import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PassagemService {
    private List<Passagem> passagens = new ArrayList<>();

    // Método para inserir uma nova passagem
    public void inserirPassagem(Passagem passagem) {
        passagens.add(passagem);
        System.out.println("Passagem inserida com sucesso.");
    }

    // Método para buscar uma passagem pelo código da viagem
    public Optional<Passagem> buscarPassagem(Integer codigoViagem) {
        return passagens.stream()
                .filter(passagem -> passagem.getCodigoViagem().equals(codigoViagem))
                .findFirst();
    }

    // Método para alterar os dados de uma passagem
    public boolean alterarPassagem(Passagem passagemAtualizada) {
        Optional<Passagem> passagemOpt = buscarPassagem(passagemAtualizada.getCodigoViagem());
        if (passagemOpt.isPresent()) {
            Passagem passagemExistente = passagemOpt.get();
            passagemExistente.setCodigoAssento(passagemAtualizada.getCodigoAssento());
            passagemExistente.setCodigoPassageiro(passagemAtualizada.getCodigoPassageiro());
            passagemExistente.setValor(passagemAtualizada.getValor());
            passagemExistente.setDataCompra(passagemAtualizada.getDataCompra());
            System.out.println("Passagem alterada com sucesso.");
            return true;
        } else {
            System.out.println("Passagem não encontrada.");
            return false;
        }
    }

    // Método para excluir uma passagem pelo código da viagem
    public boolean excluirPassagem(Integer codigoViagem) {
        Optional<Passagem> passagemOpt = buscarPassagem(codigoViagem);
        if (passagemOpt.isPresent()) {
            passagens.remove(passagemOpt.get());
            System.out.println("Passagem excluída com sucesso.");
            return true;
        } else {
            System.out.println("Passagem não encontrada.");
            return false;
        }
    }

    // Método para listar todas as passagens
    public List<Passagem> listarPassagens() {
        return passagens;
    }
}
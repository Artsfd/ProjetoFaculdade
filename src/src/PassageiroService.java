import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PassageiroService {

    private List<Passageiro> passageiros;

    public PassageiroService() {
        this.passageiros = new ArrayList<>();
    }

    // Método para buscar um passageiro por email
    public Optional<Passageiro> buscarPorEmail(String email) {
        return passageiros.stream()
                .filter(p -> p.getEmail().equals(email))
                .findFirst();
    }

    // Método para inserir um novo passageiro
    public void inserir(Passageiro passageiro) {
        // Verifica se já existe um passageiro com o mesmo email (email é único)
        if (buscarPorEmail(passageiro.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Já existe um passageiro com este email.");
        }
        passageiros.add(passageiro);
        System.out.println("Passageiro inserido com sucesso.");
    }

    // Método para alterar um passageiro existente
    public void alterar(String email, Passageiro passageiroAtualizado) {
        Optional<Passageiro> passageiroOpt = buscarPorEmail(email);
        if (passageiroOpt.isPresent()) {
            Passageiro passageiroExistente = passageiroOpt.get();
            passageiros.remove(passageiroExistente);  // Remove o passageiro antigo
            passageiros.add(passageiroAtualizado);    // Adiciona o passageiro atualizado
            System.out.println("Passageiro atualizado com sucesso.");
        } else {
            throw new IllegalArgumentException("Passageiro com o email informado não encontrado.");
        }
    }

    // Método para excluir um passageiro
    public void excluir(String email) {
        Optional<Passageiro> passageiroOpt = buscarPorEmail(email);
        if (passageiroOpt.isPresent()) {
            passageiros.remove(passageiroOpt.get());
            System.out.println("Passageiro excluído com sucesso.");
        } else {
            throw new IllegalArgumentException("Passageiro com o email informado não encontrado.");
        }
    }

    // Método para listar todos os passageiros
    public List<Passageiro> listarTodos() {
        return new ArrayList<>(passageiros);
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AssentoService {

    // Simulando o banco de dados com uma lista
    private List<Assento> assentos = new ArrayList<>();

    // Serviço de Inserção
    public void inserirAssento(Assento assento) {
        if (assento == null) {
            throw new IllegalArgumentException("Assento não pode ser nulo.");
        }
        // Checar se o assento já existe com o mesmo código
        for (Assento a : assentos) {
            if (a.getCodigoAssento().equals(assento.getCodigoAssento())) {
                throw new IllegalArgumentException("Assento com o mesmo código já existe.");
            }
        }
        assentos.add(assento);
        System.out.println("Assento inserido com sucesso: " + assento);
    }

    // Serviço de Busca (por código do assento)
    public Assento buscarAssentoPorCodigo(Integer codigoAssento) {
        Optional<Assento> assentoEncontrado = assentos.stream()
                .filter(a -> a.getCodigoAssento().equals(codigoAssento))
                .findFirst();

        if (assentoEncontrado.isPresent()) {
            return assentoEncontrado.get();
        } else {
            throw new IllegalArgumentException("Assento não encontrado para o código: " + codigoAssento);
        }
    }

    // Serviço de Alteração
    public void alterarAssento(Assento assentoAlterado) {
        if (assentoAlterado == null) {
            throw new IllegalArgumentException("Assento não pode ser nulo.");
        }

        for (int i = 0; i < assentos.size(); i++) {
            Assento assento = assentos.get(i);
            if (assento.getCodigoAssento().equals(assentoAlterado.getCodigoAssento())) {
                assentos.set(i, assentoAlterado); // Atualiza o assento
                System.out.println("Assento atualizado com sucesso: " + assentoAlterado);
                return;
            }
        }

        throw new IllegalArgumentException("Assento com código " + assentoAlterado.getCodigoAssento() + " não encontrado.");
    }

    // Serviço de Exclusão
    public void excluirAssento(Integer codigoAssento) {
        Assento assentoParaExcluir = buscarAssentoPorCodigo(codigoAssento);
        assentos.remove(assentoParaExcluir);
        System.out.println("Assento removido com sucesso: " + assentoParaExcluir);
    }

    // Método para listar todos os assentos (opcional)
    public List<Assento> listarTodosAssentos() {
        return new ArrayList<>(assentos); // Retorna uma cópia da lista
    }
}
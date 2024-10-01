import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdministradorService {
    private List<Administrador> administradores = new ArrayList<>();

    // Método para inserir um novo administrador
    public void inserirAdministrador(Administrador administrador) {
        administradores.add(administrador);
        System.out.println("Administrador inserido com sucesso.");
    }

    // Método para buscar um administrador pelo código
    public Optional<Administrador> buscarAdministrador(Integer codigo) {
        return administradores.stream()
                .filter(administrador -> administrador.getCodigo().equals(codigo))
                .findFirst();
    }

    // Método para alterar os dados de um administrador
    public boolean alterarAdministrador(Administrador administradorAtualizado) {
        Optional<Administrador> adminOpt = buscarAdministrador(administradorAtualizado.getCodigo());
        if (adminOpt.isPresent()) {
            Administrador administradorExistente = adminOpt.get();
            administradorExistente.setNome(administradorAtualizado.getNome());
            administradorExistente.setSexo(administradorAtualizado.getSexo());
            administradorExistente.setCpf(administradorAtualizado.getCpf());
            administradorExistente.setEmail(administradorAtualizado.getEmail());
            administradorExistente.setCelular(administradorAtualizado.getCelular());
            System.out.println("Administrador alterado com sucesso.");
            return true;
        } else {
            System.out.println("Administrador não encontrado.");
            return false;
        }
    }

    // Método para excluir um administrador pelo código
    public boolean excluirAdministrador(Integer codigo) {
        Optional<Administrador> adminOpt = buscarAdministrador(codigo);
        if (adminOpt.isPresent()) {
            administradores.remove(adminOpt.get());
            System.out.println("Administrador excluído com sucesso.");
            return true;
        } else {
            System.out.println("Administrador não encontrado.");
            return false;
        }
    }

    // Método para listar todos os administradores
    public List<Administrador> listarAdministradores() {
        return administradores;
    }
}
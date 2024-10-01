import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioService {

    private List<Usuario> usuarios;

    public UsuarioService() {
        this.usuarios = new ArrayList<>();
    }

    // Método para buscar um usuário por email
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();
    }

    // Método para inserir um novo usuário
    public void inserir(Usuario usuario) {
        // Verifica se já existe um usuário com o mesmo email (email é único)
        if (buscarPorEmail(usuario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Já existe um usuário com este email.");
        }
        usuarios.add(usuario);
        System.out.println("Usuário inserido com sucesso.");
    }

    // Método para alterar um usuário existente
    public void alterar(String email, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioOpt = buscarPorEmail(email);
        if (usuarioOpt.isPresent()) {
            Usuario usuarioExistente = usuarioOpt.get();
            usuarios.remove(usuarioExistente);  // Remove o usuário antigo
            usuarios.add(usuarioAtualizado);    // Adiciona o usuário atualizado
            System.out.println("Usuário atualizado com sucesso.");
        } else {
            throw new IllegalArgumentException("Usuário com o email informado não encontrado.");
        }
    }

    // Método para excluir um usuário
    public void excluir(String email) {
        Optional<Usuario> usuarioOpt = buscarPorEmail(email);
        if (usuarioOpt.isPresent()) {
            usuarios.remove(usuarioOpt.get());
            System.out.println("Usuário excluído com sucesso.");
        } else {
            throw new IllegalArgumentException("Usuário com o email informado não encontrado.");
        }
    }

    // Método para listar todos os usuários
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }
}
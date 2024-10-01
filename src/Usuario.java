public class Usuario {
    private String nome;
    private String sexo;
    private String email;
    private String senha;
    private String grupo;

    public Usuario(String nome, String sexo, String email, String senha, String grupo) {
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.senha = senha;
        this.grupo = grupo;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}

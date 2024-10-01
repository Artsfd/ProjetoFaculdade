public class Administrador {
        private Integer codigo;
        private String nome;
        private String sexo;
        private String cpf;
        private String email;
        private String celular;

        public Administrador(Integer codigo, String nome, String sexo, String cpf, String email, String celular) {
            this.codigo = codigo;
            this.nome = nome;
            this.sexo = sexo;
            this.cpf = cpf;
            this.email = email;
            this.celular = celular;
        }

        // Getters e Setters
        public Integer getCodigo() {
            return codigo;
        }

        public void setCodigo(Integer codigo) {
            this.codigo = codigo;
        }

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

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCelular() {
            return celular;
        }

        public void setCelular(String celular) {
            this.celular = celular;
        }
    }



import java.util.Scanner;
import java.util.Optional;

public class MainMenu {
    private static Scanner scanner = new Scanner(System.in);

    private static OnibusService onibusService = new OnibusService();
    private static AdministradorService administradorService = new AdministradorService();
    private static VendedorService vendedorService = new VendedorService();
    private static PassagemService passagemService = new PassagemService();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("===== TELA INICIAL =====");
            System.out.println("1. Acessar como Administrador");
            System.out.println("2. Acessar como Vendedor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcaoInicial = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcaoInicial) {
                case 1:
                    menuAdministrador();
                    break;
                case 2:
                    menuVendedor();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        System.out.println("Encerrando o sistema...");
    }

    // Menu de Gerenciamento de Ônibus
    private static void menuOnibus() {
        System.out.println("===== GERENCIAR ÔNIBUS =====");
        System.out.println("1. Inserir Ônibus");
        System.out.println("2. Buscar Ônibus");
        System.out.println("3. Alterar Ônibus");
        System.out.println("4. Excluir Ônibus");
        System.out.println("0. Voltar ao menu principal");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        switch (opcao) {
            case 1:
                inserirOnibus();
                break;
            case 2:
                buscarOnibus();
                break;
            case 3:
                alterarOnibus();
                break;
            case 4:
                excluirOnibus();
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void inserirOnibus() {
        System.out.println("Inserindo novo Ônibus...");
        System.out.print("Código do ônibus: ");
        Integer codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Placa do ônibus: ");
        String placa = scanner.nextLine();
        System.out.print("Quantidade de assentos: ");
        Integer quantidadeAssentos = scanner.nextInt();
        Onibus onibus = new Onibus(codigo, placa, quantidadeAssentos);
        onibusService.InserirOnibus(onibus);
    }

    private static void buscarOnibus() {
        System.out.print("Digite o código do ônibus: ");
        Integer codigo = scanner.nextInt();
        Optional<Onibus> onibus = onibusService.BuscarOnibus(codigo);
        if (onibus.isPresent()) {
            System.out.println("Ônibus encontrado: " + onibus.get().getPlaca());
        } else {
            System.out.println("Ônibus não encontrado.");
        }
    }

    private static void alterarOnibus() {
        System.out.print("Digite o código do ônibus a ser alterado: ");
        Integer codigo = scanner.nextInt();
        scanner.nextLine();
        Optional<Onibus> onibus = onibusService.BuscarOnibus(codigo);
        if (onibus.isPresent()) {
            System.out.print("Nova placa do ônibus: ");
            String novaPlaca = scanner.nextLine();
            System.out.print("Nova quantidade de assentos: ");
            Integer novaQtdAssentos = scanner.nextInt();
            Onibus novoOnibus = new Onibus(codigo, novaPlaca, novaQtdAssentos);
            onibusService.AlterarOnibus(novoOnibus);
        } else {
            System.out.println("Ônibus não encontrado.");
        }
    }

    private static void excluirOnibus() {
        System.out.print("Digite o código do ônibus a ser excluído: ");
        Integer codigo = scanner.nextInt();
        boolean sucesso = onibusService.ExcluirOnibus(codigo);
        if (sucesso) {
            System.out.println("Ônibus excluído com sucesso.");
        } else {
            System.out.println("Ônibus não encontrado.");
        }
    }

    // Menu de Administrador
    private static void menuAdministrador() {
        boolean exit = false;

        while (!exit) {
            System.out.println("===== MENU ADMINISTRADOR =====");
            System.out.println("1. Gerenciar Ônibus");
            System.out.println("2. Gerenciar Administrador");
            System.out.println("3. Gerenciar Passagem");
            System.out.println("4. Gerenciar Vendedor");
            System.out.println("0. Voltar à tela inicial");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    menuOnibus();
                    break;
                case 2:
                    gerenciarAdministrador();
                    break;
                case 3:
                    menuPassagem();
                    break;
                case 4:
                    GerenciarVendedor();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Menu de Vendedor
    private static void menuVendedor() {
        boolean exit = false;

        while (!exit) {
            System.out.println("===== MENU VENDEDOR =====");
            System.out.println("1. Gerenciar Passagem");
            System.out.println("0. Voltar à tela inicial");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    menuPassagem();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Métodos de gerenciar Administrador
    private static void gerenciarAdministrador() {
        System.out.println("===== GERENCIAR ADMINISTRADOR =====");
        System.out.println("1. Inserir Administrador");
        System.out.println("2. Buscar Administrador");
        System.out.println("3. Alterar Administrador");
        System.out.println("4. Excluir Administrador");
        System.out.println("0. Voltar ao menu anterior");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        switch (opcao) {
            case 1:
                inserirAdministrador();
                break;
            case 2:
                buscarAdministrador();
                break;
            case 3:
                alterarAdministrador();
                break;
            case 4:
                excluirAdministrador();
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void inserirAdministrador() {
        System.out.println("Inserindo novo Administrador...");
        System.out.print("Código do administrador: ");
        Integer codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Celular: ");
        String celular = scanner.nextLine();
        Administrador administrador = new Administrador(codigo, nome, sexo, cpf, email, celular);
        administradorService.inserirAdministrador(administrador);
    }

    private static void buscarAdministrador() {
        System.out.print("Digite o código do administrador: ");
        Integer codigo = scanner.nextInt();
        Optional<Administrador> administrador = administradorService.buscarAdministrador(codigo);
        if (administrador.isPresent()) {
            System.out.println("Administrador encontrado: " + administrador.get().getNome());
        } else {
            System.out.println("Administrador não encontrado.");
        }
    }

    private static void alterarAdministrador() {
        System.out.print("Digite o código do administrador a ser alterado: ");
        Integer codigo = scanner.nextInt();
        scanner.nextLine();
        Optional<Administrador> administrador = administradorService.buscarAdministrador(codigo);
        if (administrador.isPresent()) {
            System.out.print("Novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo sexo: ");
            String novoSexo = scanner.nextLine();
            System.out.print("Novo CPF: ");
            String novoCpf = scanner.nextLine();
            System.out.print("Novo e-mail: ");
            String novoEmail = scanner.nextLine();
            System.out.print("Novo celular: ");
            String novoCelular = scanner.nextLine();
            Administrador novoAdministrador = new Administrador(codigo, novoNome, novoSexo, novoCpf, novoEmail, novoCelular);
            administradorService.alterarAdministrador(novoAdministrador);
        } else {
            System.out.println("Administrador não encontrado.");
        }
    }

    private static void excluirAdministrador() {
        System.out.print("Digite o código do administrador a ser excluído: ");
        Integer codigo = scanner.nextInt();
        boolean sucesso = administradorService.excluirAdministrador(codigo);
        if (sucesso) {
            System.out.println("Administrador excluído com sucesso.");
        } else {
            System.out.println("Administrador não encontrado.");
        }
    }

    // Menu de operações para Vendedor
    private static void GerenciarVendedor() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----- Gerenciar Vendedor -----");
            System.out.println("1. Inserir Vendedor");
            System.out.println("2. Buscar Vendedor");
            System.out.println("3. Alterar Vendedor");
            System.out.println("4. Excluir Vendedor");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Inserir Vendedor
                    inserirVendedor();
                    break;
                case 2:
                    // Buscar Vendedor
                    buscarVendedor();
                    break;
                case 3:
                    // Alterar Vendedor
                    alterarVendedor();
                    break;
                case 4:
                    // Excluir Vendedor
                    excluirVendedor();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }

    // Métodos de gerenciamento do Vendedor
    private static void inserirVendedor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserir Vendedor");

        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Sexo (M/F): ");
        String sexo = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Celular: ");
        String celular = scanner.nextLine();

        Vendedor vendedor = new Vendedor(codigo, nome, sexo, cpf, email, celular);
        vendedorService.inserirVendedor(vendedor);
    }

    private static void buscarVendedor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Buscar Vendedor");

        System.out.print("Digite o código do vendedor: ");
        int codigo = scanner.nextInt();

        vendedorService.buscarVendedor(codigo).ifPresentOrElse(
                vendedor -> System.out.println("Vendedor encontrado: " +vendedor),
                () -> System.out.println("Vendedor não encontrado.")
        );
    }

    private static void alterarVendedor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Alterar Vendedor");

        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo Sexo (M/F): ");
        String sexo = scanner.nextLine();

        System.out.print("Novo CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Novo E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Novo Celular: ");
        String celular = scanner.nextLine();

        Vendedor vendedor = new Vendedor(codigo, nome, sexo, cpf, email, celular);
        vendedorService.alterarVendedor(vendedor);
    }

    private static void excluirVendedor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Excluir Vendedor");

        System.out.print("Digite o código do vendedor: ");
        int codigo = scanner.nextInt();

        vendedorService.excluirVendedor(codigo);
    }
    // Menu de operações para Passagem
    private static void menuPassagem() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----- Menu Passagem -----");
            System.out.println("1. Inserir Passagem");
            System.out.println("2. Buscar Passagem");
            System.out.println("3. Alterar Passagem");
            System.out.println("4. Excluir Passagem");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Inserir Passagem
                    inserirPassagem();
                    break;
                case 2:
                    // Buscar Passagem
                    buscarPassagem();
                    break;
                case 3:
                    // Alterar Passagem
                    alterarPassagem();
                    break;
                case 4:
                    // Excluir Passagem
                    excluirPassagem();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }

    // Métodos de gerenciamento de Passagem
    private static void inserirPassagem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserir Passagem");

        System.out.print("Código: ");
        int codigoViagem = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("Origem: ");
        String origem = scanner.nextLine();

        System.out.print("Destino: ");
        String destino = scanner.nextLine();

        System.out.print("Data de Saída (yyyy-MM-dd): ");
        String dataSaida = scanner.nextLine();

        System.out.print("Data de Chegada (yyyy-MM-dd): ");
        String dataChegada = scanner.nextLine();

        System.out.print("Valor: ");
        double valor = scanner.nextDouble();

        Passagem passagem = new Passagem(codigoViagem, origem, destino, dataSaida, dataChegada, valor);
        passagemService.inserirPassagem(passagem);
    }

    private static void buscarPassagem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Buscar Passagem");

        System.out.print("Digite o código da passagem: ");
        int codigo = scanner.nextInt();

        passagemService.buscarPassagem(codigo).ifPresentOrElse(
                passagem -> System.out.println("Passagem encontrada: " + passagem),
                () -> System.out.println("Passagem não encontrada.")
        );
    }

    private static void alterarPassagem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Alterar Passagem");

        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("Nova Origem: ");
        String origem = scanner.nextLine();

        System.out.print("Novo Destino: ");
        String destino = scanner.nextLine();

        System.out.print("Nova Data de Saída (yyyy-MM-dd): ");
        String dataSaida = scanner.nextLine();

        System.out.print("Nova Data de Chegada (yyyy-MM-dd): ");
        String dataChegada = scanner.nextLine();

        System.out.print("Novo Valor: ");
        double valor = scanner.nextDouble();

        Passagem passagem = new Passagem(codigo, origem, destino, dataSaida, dataChegada, valor);
        passagemService.alterarPassagem(passagem);
    }

    private static void excluirPassagem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Excluir Passagem");

        System.out.print("Digite o código da passagem: ");
        int codigo = scanner.nextInt();

        passagemService.excluirPassagem(codigo);
    }
}

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
            PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
            
            while (true) {
                System.out.println("\nMenu de Opções:");
                System.out.println("1 - Incluir");
                System.out.println("2 - Alterar");
                System.out.println("3 - Excluir");
                System.out.println("4 - Exibir pelo ID");
                System.out.println("5 - Exibir todos");
                System.out.println("6 - Salvar dados");
                System.out.println("7 - Recuperar dados");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha
                
                if (opcao == 0) {
                    System.out.println("Finalizando o programa...");
                    break;
                }
                
                switch (opcao) {
                    case 1 -> // Incluir
                        incluir(scanner, repoFisica, repoJuridica);
                    case 2 -> // Alterar
                        alterar(scanner, repoFisica, repoJuridica);
                    case 3 -> // Excluir
                        excluir(scanner, repoFisica, repoJuridica);
                    case 4 -> // Exibir pelo ID
                        exibirPorId(scanner, repoFisica, repoJuridica);
                    case 5 -> // Exibir todos
                        exibirTodos(scanner, repoFisica, repoJuridica);
                    case 6 -> // Salvar dados
                        salvarDados(scanner, repoFisica, repoJuridica);
                    case 7 -> // Recuperar dados
                        recuperarDados(scanner, repoFisica, repoJuridica);
                    default -> System.out.println("Opção inválida!");
                }
            }
        }
    }

    private static void incluir(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        switch (tipo) {
            case 1 ->                 {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
                }
            case 2 ->                 {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CNPJ: ");
                    String cnpj = scanner.nextLine();
                    repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
                }
            default -> System.out.println("Tipo inválido!");
        }
    }

    private static void alterar(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("ID da pessoa a ser alterada: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        switch (tipo) {
            case 1 -> {
                PessoaFisica pf = repoFisica.obter(id);
                if (pf != null) {
                    pf.exibir();
                    System.out.print("Novo Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Nova Idade: ");
                    int idade = scanner.nextInt();
                    pf.setNome(nome);
                    pf.setCpf(cpf);
                    pf.setIdade(idade);
                    repoFisica.alterar(pf);
                } else {
                    System.out.println("Pessoa Física não encontrada!");
                }
            }
            case 2 -> {
                PessoaJuridica pj = repoJuridica.obter(id);
                if (pj != null) {
                    pj.exibir();
                    System.out.print("Novo Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo CNPJ: ");
                    String cnpj = scanner.nextLine();
                    pj.setNome(nome);
                    pj.setCnpj(cnpj);
                    repoJuridica.alterar(pj);
                } else {
                    System.out.println("Pessoa Jurídica não encontrada!");
                }
            }
            default -> System.out.println("Tipo inválido!");
        }
    }

    private static void excluir(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID da pessoa a ser excluída: ");
        int id = scanner.nextInt();

        switch (tipo) {
            case 1 -> repoFisica.excluir(id);
            case 2 -> repoJuridica.excluir(id);
            default -> System.out.println("Tipo inválido!");
        }
    }

    private static void exibirPorId(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID da pessoa: ");
        int id = scanner.nextInt();

        switch (tipo) {
            case 1 -> {
                PessoaFisica pf = repoFisica.obter(id);
                if (pf != null) {
                    pf.exibir();
                } else {
                    System.out.println("Pessoa Física não encontrada!");
                }
            }
            case 2 -> {
                PessoaJuridica pj = repoJuridica.obter(id);
                if (pj != null) {
                    pj.exibir();
                } else {
                    System.out.println("Pessoa Jurídica não encontrada!");
                }
            }
            default -> System.out.println("Tipo inválido!");
        }
    }

    private static void exibirTodos(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();

        switch (tipo) {
            case 1 -> {
                for (PessoaFisica pf : repoFisica.obterTodos()) {
                    pf.exibir();
                }
            }
            case 2 -> {
                for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                    pj.exibir();
                }
            }
            default -> System.out.println("Tipo inválido!");
        }
    }

    private static void salvarDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Informe o prefixo dos arquivos: ");
        String prefixo = scanner.nextLine();

        repoFisica.persistir(prefixo + ".fisica.bin");
        repoJuridica.persistir(prefixo + ".juridica.bin");
        System.out.println("Dados salvos com sucesso!");
    }

    private static void recuperarDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Informe o prefixo dos arquivos: ");
        String prefixo = scanner.nextLine();

        repoFisica.recuperar(prefixo + ".fisica.bin");
        repoJuridica.recuperar(prefixo + ".juridica.bin");
        System.out.println("Dados recuperados com sucesso!");
    }

    private static class PessoaFisicaRepo {

        public PessoaFisicaRepo() {
        }





        private Iterable<PessoaFisica> obterTodos() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }




        private void excluir(int id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void persistir(String string) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void recuperar(String string) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

    private static class PessoaJuridicaRepo {

        public PessoaJuridicaRepo() {
        }





        private Iterable<PessoaJuridica> obterTodos() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void inserir(PessoaJuridica pessoaJuridica) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private PessoaJuridica obter(int id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void alterar(PessoaJuridica pj) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void excluir(int id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void persistir(String string) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void recuperar(String string) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }
}
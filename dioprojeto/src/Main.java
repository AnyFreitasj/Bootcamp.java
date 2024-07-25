import java.util.Scanner;

public class Main {
    private static Bootcamp bootcampPython = new Bootcamp("Bootcamp Python Developer", "Aprenda a programar em Python do zero ao avançado.");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDados();
        menuPrincipal();
    }

    private static void inicializarDados() {
        // Criando Cursos
        Curso cursoBasicoPython = new Curso("Python Básico", "Aprenda o básico de Python.", 20);
        Curso cursoAvancadoPython = new Curso("Python Avançado", "Aprenda tópicos avançados de Python.", 40);

        // Criando Mentorias
        Mentoria mentoriaPython = new Mentoria("Python", "Sessão de mentoria para dúvidas sobre Python.", "João Mentor");

        // Criando Devs
        Dev dev1 = new Dev("Alice", "alice@example.com");
        Dev dev2 = new Dev("Bob", "bob@example.com");

        // Adicionando cursos e mentorias ao bootcamp
        bootcampPython.adicionarCurso(cursoBasicoPython);
        bootcampPython.adicionarCurso(cursoAvancadoPython);
        bootcampPython.adicionarMentoria(mentoriaPython);

        // Adicionando devs ao bootcamp
        bootcampPython.adicionarDev(dev1);
        bootcampPython.adicionarDev(dev2);
    }

    private static void menuPrincipal() {
        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Listar Cursos");
            System.out.println("2. Listar Mentorias");
            System.out.println("3. Listar Devs");
            System.out.println("4. Adicionar Curso");
            System.out.println("5. Adicionar Mentoria");
            System.out.println("6. Adicionar Dev");
            System.out.println("7. Concluir Atividade (Curso/Mentoria)");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    listarCursos();
                    break;
                case 2:
                    listarMentorias();
                    break;
                case 3:
                    listarDevs();
                    break;
                case 4:
                    adicionarCurso();
                    break;
                case 5:
                    adicionarMentoria();
                    break;
                case 6:
                    adicionarDev();
                    break;
                case 7:
                    concluirAtividade();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void listarCursos() {
        System.out.println("\n--- Cursos Disponíveis ---");
        for (Curso curso : bootcampPython.getCursos()) {
            System.out.println("- " + curso.getTitulo() + " (" + curso.getCargaHoraria() + "h)");
        }
    }

    private static void listarMentorias() {
        System.out.println("\n--- Mentorias Disponíveis ---");
        for (Mentoria mentoria : bootcampPython.getMentorias()) {
            System.out.println("- " + mentoria.getTitulo() + " com " + mentoria.getMentor());
        }
    }

    private static void listarDevs() {
        System.out.println("\n--- Devs Inscritos ---");
        for (Dev dev : bootcampPython.getDevs()) {
            System.out.println("- " + dev.getNome() + " (" + dev.getEmail() + ")");
        }
    }

    private static void adicionarCurso() {
        System.out.print("Título do Curso: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição do Curso: ");
        String descricao = scanner.nextLine();
        System.out.print("Carga Horária do Curso: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer do scanner

        Curso novoCurso = new Curso(titulo, descricao, cargaHoraria);
        bootcampPython.adicionarCurso(novoCurso);
        System.out.println("Curso adicionado com sucesso!");
    }

    private static void adicionarMentoria() {
        System.out.print("Título da Mentoria: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição da Mentoria: ");
        String descricao = scanner.nextLine();
        System.out.print("Nome do Mentor: ");
        String mentor = scanner.nextLine();

        Mentoria novaMentoria = new Mentoria(titulo, descricao, mentor);
        bootcampPython.adicionarMentoria(novaMentoria);
        System.out.println("Mentoria adicionada com sucesso!");
    }

    private static void adicionarDev() {
        System.out.print("Nome do Dev: ");
        String nome = scanner.nextLine();
        System.out.print("Email do Dev: ");
        String email = scanner.nextLine();

        Dev novoDev = new Dev(nome, email);
        bootcampPython.adicionarDev(novoDev);
        System.out.println("Dev adicionado com sucesso!");
    }

    private static void concluirAtividade() {
        System.out.print("Nome do Dev: ");
        String nomeDev = scanner.nextLine();
        Dev dev = encontrarDevPorNome(nomeDev);
        if (dev == null) {
            System.out.println("Dev não encontrado!");
            return;
        }

        System.out.println("1. Concluir Curso");
        System.out.println("2. Concluir Mentoria");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer do scanner

        switch (escolha) {
            case 1:
                listarCursos();
                System.out.print("Título do Curso a concluir: ");
                String tituloCurso = scanner.nextLine();
                Curso curso = encontrarCursoPorTitulo(tituloCurso);
                if (curso != null) {
                    dev.concluirAtividade(curso);
                    System.out.println("Curso concluído com sucesso!");
                } else {
                    System.out.println("Curso não encontrado!");
                }
                break;
            case 2:
                listarMentorias();
                System.out.print("Título da Mentoria a concluir: ");
                String tituloMentoria = scanner.nextLine();
                Mentoria mentoria = encontrarMentoriaPorTitulo(tituloMentoria);
                if (mentoria != null) {
                    dev.concluirAtividade(mentoria);
                    System.out.println("Mentoria concluída com sucesso!");
                } else {
                    System.out.println("Mentoria não encontrado!");
                }
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    private static Dev encontrarDevPorNome(String nome) {
        for (Dev dev : bootcampPython.getDevs()) {
            if (dev.getNome().equalsIgnoreCase(nome)) {
                return dev;
            }
        }
        return null;
    }

    private static Curso encontrarCursoPorTitulo(String titulo) {
        for (Curso curso : bootcampPython.getCursos()) {
            if (curso.getTitulo().equalsIgnoreCase(titulo)) {
                return curso;
            }
        }
        return null;
    }

    private static Mentoria encontrarMentoriaPorTitulo(String titulo) {
        for (Mentoria mentoria : bootcampPython.getMentorias()) {
            if (mentoria.getTitulo().equalsIgnoreCase(titulo)) {
                return mentoria;
            }
        }
        return null;
    }
}

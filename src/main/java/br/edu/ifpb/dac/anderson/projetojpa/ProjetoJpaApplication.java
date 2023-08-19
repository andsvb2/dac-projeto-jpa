package br.edu.ifpb.dac.anderson.projetojpa;

import br.edu.ifpb.dac.anderson.projetojpa.business.controller.FilmeController;
import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Filme;
import br.edu.ifpb.dac.anderson.projetojpa.model.repository.FilmeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ProjetoJpaApplication implements CommandLineRunner {

    private final FilmeRepository filmeRepository;

    public ProjetoJpaApplication(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjetoJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        FilmeController filmeController = new FilmeController(filmeRepository);
        String menu = "\nEscolha a opção desejada:\n" + "1. Criar um novo registro de filme;\n" + "2. Listar todos os filmes;\n" + "3. Sair\n";
        Scanner scanner = new Scanner(System.in);
        boolean exitFlag = false;

        while (!exitFlag) {
            System.out.println(menu);
            int opcao = Integer.parseInt(scanner.nextLine());
            if (opcao == 1) {
                System.out.print("Qual o título do filme? ");
                String titulo = scanner.nextLine();
                System.out.print("Qual o nome do(a) diretor(a)? ");
                String diretor = scanner.nextLine();
                System.out.print("Qual o gênero do filme? ");
                String genero = scanner.nextLine();
                filmeController.createFilme(titulo, genero);
                System.out.println("Filme registrado!");
            }
            else if (opcao == 2) {
                List<Filme> filmes = filmeController.getFilmes();
                System.out.println();
                for (Filme filme : filmes) {
                    System.out.println(filme);
                }
                System.out.println();
            } else if (opcao == 3) {
                exitFlag = true;
                System.out.println("Até mais.");
            }

        }
    }
}

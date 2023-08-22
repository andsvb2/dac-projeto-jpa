package br.edu.ifpb.dac.anderson.projetojpa.presentation;

import br.edu.ifpb.dac.anderson.projetojpa.business.controller.FilmeController;
import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Filme;
import br.edu.ifpb.dac.anderson.projetojpa.presentation.utilities.InputUtil;
import br.edu.ifpb.dac.anderson.projetojpa.presentation.utilities.PrinterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleView implements CommandLineRunner {

    @Autowired
    private FilmeController filmeController;
    @Autowired
    private InputUtil inputUtil;
    @Autowired
    private PrinterUtil printerUtil;


    @Override
    public void run(String... args) throws Exception {
        String menu = "\nEscolha a opção desejada:\n" + "1. Criar um novo registro de filme;\n" + "2. Listar todos os filmes;\n" + "3. Sair\n";
        Scanner scanner = new Scanner(System.in);
        boolean exitFlag = false;

        while (!exitFlag) {
            int opcao = inputUtil.getInteger(menu);
            if (opcao == 1) {
                String titulo = inputUtil.getString("Qual o título do filme? ");
                String diretor = inputUtil.getString("Qual o nome do(a) diretor(a)? ");
                String genero = inputUtil.getString("Qual o gênero do filme? ");
                filmeController.createFilme(titulo, diretor, genero);
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

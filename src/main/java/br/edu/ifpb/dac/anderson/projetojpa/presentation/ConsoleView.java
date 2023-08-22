package br.edu.ifpb.dac.anderson.projetojpa.presentation;

import br.edu.ifpb.dac.anderson.projetojpa.business.controller.DiretorController;
import br.edu.ifpb.dac.anderson.projetojpa.business.controller.FilmeController;
import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Diretor;
import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Filme;
import br.edu.ifpb.dac.anderson.projetojpa.presentation.utilities.InputUtil;
import br.edu.ifpb.dac.anderson.projetojpa.presentation.utilities.PrinterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

@Component
public class ConsoleView implements CommandLineRunner {

    @Autowired
    private FilmeController filmeController;
    @Autowired
    private DiretorController diretorController;
    @Autowired
    private InputUtil inputUtil;
    @Autowired
    private PrinterUtil printerUtil;


    @Override
    public void run(String... args) throws Exception {
        String menu = """
                Escolha a opção desejada:
                1. Criar um novo registro de filme;
                2. Criar um novo registro de diretor(a);
                3. Associar diretor(a) a filme;
                4. Listar todos os filmes e diretores;
                5. Sair;
                """;
        boolean exitFlag = false;

        while (!exitFlag) {
            int opcao = inputUtil.getInteger(menu);
            if (opcao == 1) {
                criarFilme();
            }
            else if (opcao == 2) {
                criarDiretor();
            }
            else if (opcao == 3) {
                associarDiretorFilme();
            }
            else if (opcao == 4) {
                exibirFilmesDiretores();
            } else if (opcao == 5) {
                exitFlag = true;
                printerUtil.printLine("Até mais.");
            }

        }
    }

    private void exibirFilmesDiretores() {
        exibirFilmes();
        exibirDiretores();
    }

    private void exibirFilmes() {
        List<Filme> filmes = filmeController.getFilmes();
        printerUtil.printLine("-------------------------------- FILMES --------------------------------");
        for (int i = 0; i < filmes.size(); i++) {
            Filme film = filmes.get(i);
            printerUtil.printLine((i + 1) +". " + film.toString());
        }
        printerUtil.printLine("");
    }

    private void exibirDiretores() {
        List<Diretor> diretores = diretorController.getDiretores();
        printerUtil.printLine("-------------------------------- DIRETORES(AS) --------------------------------");
        for (int i = 0; i < diretores.size(); i++) {
            Diretor diretor = diretores.get(i);
            printerUtil.printLine((i + 1) +". " + diretor.toString());
        }
        printerUtil.printLine("");
    }

    private void criarFilme() {
        String titulo = inputUtil.getString("Qual o título do filme? ");
        String genero = inputUtil.getString("Qual o gênero do filme? ");
        Year ano = inputUtil.getYear("Qual o ano de lançamento? ");
        String result = filmeController.createFilme(titulo, genero, ano);
        printerUtil.printLine(result);
    }

    public void criarDiretor() {
        String nome = inputUtil.getString("Qual o nome do(a) diretor(a)? ");
        String pais = inputUtil.getString("Qual o país de origem do(a) diretor(a)? ");
        LocalDate data_nascimento = inputUtil.getBirthDate("Qual o ano de nascimento?\nDigite no formato: YYYY-MM-dd (ex., 1999-12-25)\n");
        String result = diretorController.createDiretor(nome, pais, data_nascimento);
        printerUtil.printLine(result);
    }

    public void associarDiretorFilme() {
        List<Diretor> diretores = diretorController.getDiretores();
        List<Filme> filmes = filmeController.getFilmes();

        exibirFilmes();
        int filmeIndex = inputUtil.getInteger("Qual o filme quer atualizar? ");
        Filme filmeEscolhido = filmes.get(filmeIndex - 1);

        exibirDiretores();
        int diretorIndex = inputUtil.getInteger("A qual diretor(a) quer associar? ");
        Diretor diretorEscolhido = diretores.get(diretorIndex -1);

        String result = filmeController.addDiretor(filmeEscolhido, diretorEscolhido);
        printerUtil.printLine(result);
    }


}

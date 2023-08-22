package br.edu.ifpb.dac.anderson.projetojpa.business.controller;

import br.edu.ifpb.dac.anderson.projetojpa.business.service.FilmeService;
import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Diretor;
import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.Year;
import java.util.List;

@Controller
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    public String createFilme(String titulo, String genero, Year ano) {
        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setAno(ano);

        if (filmeService.filmeExists(filme) == null) {
            filmeService.save(filme);
            return "Filme registrado.";
        } else {
            return "Filme já existente. Não houve alterações no banco de dados.";
        }
    }


    public List<Filme> getFilmes() {
        return (List<Filme>) filmeService.findAll();
    }

    public List<Filme> getFilmeByTitulo(String titulo) {
        return (List<Filme>) filmeService.findFilmeByTitulo(titulo);
    }

    public List<Filme> getFilmeByGenero(String genero) {
        return (List<Filme>) filmeService.findFilmeByGenero(genero);
    }

    public List<Filme> getFilmeByAno(Year ano) {
        return filmeService.findFilmeByAno(ano);
    }

    public String addDiretor(Filme filme, Diretor diretor) {
        filme.setDiretor(diretor);
        filmeService.save(filme);
        return "Filme atualizado.";
    }

}

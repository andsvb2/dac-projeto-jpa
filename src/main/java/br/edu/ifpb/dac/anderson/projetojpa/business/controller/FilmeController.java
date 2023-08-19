package br.edu.ifpb.dac.anderson.projetojpa.business.controller;

import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Filme;
import br.edu.ifpb.dac.anderson.projetojpa.model.repository.FilmeRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FilmeController {

    private final FilmeRepository filmeRepository;

    public FilmeController(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public void createFilme(String titulo, String genero) {
        filmeRepository.save(new Filme(titulo, genero));
    }

    public List<Filme> getFilmes() {
        return (List<Filme>) filmeRepository.findAll();
    }

    public List<Filme> getFilmeByTitulo(String titulo) {
        return (List<Filme>) filmeRepository.findFilmeByTitulo(titulo);
    }

    public List<Filme> getFilmeByDiretor(String diretor) {
        return (List<Filme>) filmeRepository.findFilmeByDiretor(diretor);
    }

    public List<Filme> getFilmeByGenero(String genero) {
        return (List<Filme>) filmeRepository.findFilmeByGenero(genero);
    }

}

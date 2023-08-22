package br.edu.ifpb.dac.anderson.projetojpa.business.controller;

import br.edu.ifpb.dac.anderson.projetojpa.business.service.FilmeService;
import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Filme;
import br.edu.ifpb.dac.anderson.projetojpa.model.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    public void createFilme(String titulo, String genero) {
        filmeService.save(new Filme(titulo, genero));
    }

    public

    public List<Filme> getFilmes() {
        return (List<Filme>) filmeRepository.findAll();
    }

    public List<Filme> getFilmeByTitulo(String titulo) {
        return (List<Filme>) filmeRepository.findFilmeByTitulo(titulo);
    }

    public List<Filme> getFilmeByGenero(String genero) {
        return (List<Filme>) filmeRepository.findFilmeByGenero(genero);
    }

}

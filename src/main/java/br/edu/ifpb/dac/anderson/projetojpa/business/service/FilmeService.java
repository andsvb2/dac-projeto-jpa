package br.edu.ifpb.dac.anderson.projetojpa.business.service;

import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Filme;
import br.edu.ifpb.dac.anderson.projetojpa.model.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public void save(Filme filme) {
        filmeRepository.save(filme);
    }

    public void update(Filme filme) {
        Optional<Filme> filmeCadastrado = filmeRepository.findById(filme.getId());
        if (filmeCadastrado.isPresent()) {
            filmeRepository.save(filme);
        }


    }
}

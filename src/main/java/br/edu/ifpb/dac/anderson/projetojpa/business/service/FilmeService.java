package br.edu.ifpb.dac.anderson.projetojpa.business.service;

import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Filme;
import br.edu.ifpb.dac.anderson.projetojpa.model.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public void save(Filme filme) {
        filmeRepository.save(filme);
    }

    public Filme filmeExists(Filme filme) {
        List<Filme> filmesBD = filmeRepository.findFilmeByTitulo(filme.getTitulo());
        for (Filme filmeBD: filmesBD) {
            if (filmeBD.equals(filme)) {
                return filmeBD;
            }
        }
        return null;
    }

    public void update(Filme filme) {
        Optional<Filme> filmeCadastrado = filmeRepository.findById(filme.getId());
        if (filmeCadastrado.isPresent()) {
            filmeRepository.save(filme);
        }


    }

    public List<Filme> findAll() {
        return filmeRepository.findAll();
    }

    public List<Filme> findFilmeByTitulo(String titulo) {
        return filmeRepository.findFilmeByTitulo(titulo);
    }

    public List<Filme> findFilmeByGenero(String genero) {
        return filmeRepository.findFilmeByGenero(genero);
    }

    public List<Filme> findFilmeByAno(Year ano) {
        return filmeRepository.findFilmeByAno(ano);
    }
}

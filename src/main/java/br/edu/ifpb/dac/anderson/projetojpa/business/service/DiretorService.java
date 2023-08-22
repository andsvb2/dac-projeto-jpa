package br.edu.ifpb.dac.anderson.projetojpa.business.service;

import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Diretor;
import br.edu.ifpb.dac.anderson.projetojpa.model.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;

    public Diretor diretorExists(Diretor diretor) {
        List<Diretor> diretoresBD = diretorRepository.findDiretorByNome(diretor.getNome());
        for (Diretor diretorBD : diretoresBD) {
            if (diretorBD.equals(diretor)) {
                return diretorBD;
            }
        }
        return null;
    }

    public void save(Diretor diretor) {
        diretorRepository.save(diretor);
    }

    public List<Diretor> findAll() {
        return diretorRepository.findAll();
    }

    public List<Diretor> getDiretorByNome(String nome) {
        return diretorRepository.findDiretorByNome(nome);
    }

    public List<Diretor> getDiretorByPais(String pais) {
        return diretorRepository.findDiretorByPais(pais);
    }

    public List<Diretor> getDiretorByDataNascimento(LocalDate dataNascimento) {
        return diretorRepository.findDiretorByDataNascimento(dataNascimento);
    }
}

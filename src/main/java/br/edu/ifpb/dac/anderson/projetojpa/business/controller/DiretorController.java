package br.edu.ifpb.dac.anderson.projetojpa.business.controller;

import br.edu.ifpb.dac.anderson.projetojpa.business.service.DiretorService;
import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Diretor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    public String createDiretor(String nome, String pais, LocalDate ano) {
        Diretor diretor = new Diretor();
        diretor.setNome(nome);
        diretor.setPais(pais);
        diretor.setDataNascimento(ano);

        if (diretorService.diretorExists(diretor) == null) {
            diretorService.save(diretor);
            return "Diretor(a) registrado(a).";
        } else {
            return "Diretor(a) já existente. Não houve alterações no banco de dados.";
        }
    }

    public List<Diretor> getDiretores() {
        return diretorService.findAll();
    }

    public List<Diretor> getDiretorByNome(String nome) {
        return diretorService.getDiretorByNome(nome);
    }

    public List<Diretor> getDiretorByPais(String pais) {
        return diretorService.getDiretorByPais(pais);
    }

    public List<Diretor> getDiretorByDataNascimento(LocalDate dataNascimento) {
        return diretorService.getDiretorByDataNascimento(dataNascimento);
    }

}

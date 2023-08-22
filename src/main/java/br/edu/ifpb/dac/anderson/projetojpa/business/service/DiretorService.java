package br.edu.ifpb.dac.anderson.projetojpa.business.service;

import br.edu.ifpb.dac.anderson.projetojpa.model.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;


}

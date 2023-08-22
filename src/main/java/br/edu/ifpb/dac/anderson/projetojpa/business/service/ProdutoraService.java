package br.edu.ifpb.dac.anderson.projetojpa.business.service;

import br.edu.ifpb.dac.anderson.projetojpa.model.repository.ProdutoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoraService {

    @Autowired
    private ProdutoraRepository produtoraRepository;
}

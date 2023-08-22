package br.edu.ifpb.dac.anderson.projetojpa.business.controller;

import br.edu.ifpb.dac.anderson.projetojpa.business.service.ProdutoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProdutoraController {

    @Autowired
    private ProdutoraService produtoraService;
}

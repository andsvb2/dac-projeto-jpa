package br.edu.ifpb.dac.anderson.projetojpa.business.controller;

import br.edu.ifpb.dac.anderson.projetojpa.business.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DiretorController {

    @Autowired
    private DiretorService diretorService;
}

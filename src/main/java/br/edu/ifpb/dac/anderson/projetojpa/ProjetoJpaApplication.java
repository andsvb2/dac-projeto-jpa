package br.edu.ifpb.dac.anderson.projetojpa;

import br.edu.ifpb.dac.anderson.projetojpa.model.repository.FilmeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjetoJpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProjetoJpaApplication.class, args);
        applicationContext.close();
    }

}

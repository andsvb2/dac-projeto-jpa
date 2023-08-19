package br.edu.ifpb.dac.anderson.projetojpa.repository;

import br.edu.ifpb.dac.anderson.projetojpa.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findFilmeByTitulo(String titulo);
    List<Filme> findFilmeByDiretor(String diretor);
    List<Filme> findFilmeByGenero(String genero);
}
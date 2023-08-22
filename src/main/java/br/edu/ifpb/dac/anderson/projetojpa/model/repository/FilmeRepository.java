package br.edu.ifpb.dac.anderson.projetojpa.model.repository;

import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findFilmeByTitulo(String titulo);
    List<Filme> findFilmeByGenero(String genero);
    List<Filme> findFilmeByAno(Year ano);
}
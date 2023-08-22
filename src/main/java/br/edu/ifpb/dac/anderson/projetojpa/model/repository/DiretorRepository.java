package br.edu.ifpb.dac.anderson.projetojpa.model.repository;

import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {
    List<Diretor> findDiretorByNome(String nome);
    List<Diretor> findDiretorByPais(String pais);
    List<Diretor> findDiretorByDataNascimento(LocalDate dataNascimento);
}
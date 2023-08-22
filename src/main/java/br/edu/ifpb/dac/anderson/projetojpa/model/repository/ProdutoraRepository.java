package br.edu.ifpb.dac.anderson.projetojpa.model.repository;

import br.edu.ifpb.dac.anderson.projetojpa.model.entity.Produtora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoraRepository extends JpaRepository<Produtora, Long> {
}
package br.com.desafioestoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.desafioestoque.model.Secao;

@Repository
public interface SecaoRepository extends JpaRepository<Secao, Long>{
	public List <Secao> findAllByNomeContainingIgnoreCase(@Param("nome")String nome);

}

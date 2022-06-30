package br.com.desafioestoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.desafioestoque.model.Bebida;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long>{
	
	public List <Bebida> findAllByNomeContainingIgnoreCase(@Param("nome")String nome);

}

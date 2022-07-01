package br.com.desafioestoque.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioestoque.model.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {

	public List<Historico> findAllByEntrada(LocalDateTime entrada);
	
	public List<Historico> findAllBySaida(LocalDateTime saida);
}

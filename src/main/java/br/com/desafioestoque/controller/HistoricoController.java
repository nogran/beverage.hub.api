package br.com.desafioestoque.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioestoque.model.Historico;
//import br.com.desafioestoque.repository.BebidaRepository;
import br.com.desafioestoque.repository.HistoricoRepository;
//import br.com.desafioestoque.repository.SecaoRepository;

@RestController
@RequestMapping("/historico")
@CrossOrigin(origins="*", allowedHeaders="*")
public class HistoricoController {

	@Autowired
	private HistoricoRepository historicoRepository;
	
	/*@Autowired
	private BebidaRepository bebidaRepository;*/
	
	/*@Autowired 
	private SecaoRepository secaoRepository;*/
	
	@GetMapping
	public ResponseEntity<List<Historico>> getAll(){
		return ResponseEntity.ok(historicoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Historico> getById(@PathVariable Long id){
		return historicoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/entrada")
	public ResponseEntity<List<Historico>> getByEntrada(@PathVariable LocalDateTime entrada){
		return ResponseEntity.ok(historicoRepository.findAllByEntrada(entrada));
	}
	
	@GetMapping("/saida")
	public ResponseEntity<List<Historico>> getBySaida(@PathVariable LocalDateTime saida){
		return ResponseEntity.ok(historicoRepository.findAllBySaida(saida));
	}
}

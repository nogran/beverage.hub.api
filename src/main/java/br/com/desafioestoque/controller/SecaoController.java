package br.com.desafioestoque.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioestoque.model.Secao;
import br.com.desafioestoque.repository.SecaoRepository;

@RestController
@RequestMapping("/secao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecaoController {

	@Autowired
	private SecaoRepository secaoRepository;
	
	@GetMapping
	public ResponseEntity<List <Secao>> getAll(){
		return ResponseEntity.ok(secaoRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Secao> getById(@PathVariable Long id){
		return secaoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Secao>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(secaoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Secao> postCategoria(@Valid @RequestBody Secao secao){
		return ResponseEntity.status(HttpStatus.CREATED).body(secaoRepository.save(secao));
		
	}
	@PutMapping
	public ResponseEntity<Secao> putCategoria(@Valid @RequestBody Secao secao){
		return secaoRepository.findById(secao.getId())
				.map(resposta -> ResponseEntity.ok().body(secaoRepository.save(secao)))
				.orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable Long id){
		return secaoRepository.findById(id)
				.map(resposta -> {
					secaoRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
}

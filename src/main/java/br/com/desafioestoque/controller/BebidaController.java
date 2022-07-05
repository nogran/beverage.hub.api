package br.com.desafioestoque.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.desafioestoque.model.Bebida;
import br.com.desafioestoque.repository.BebidaRepository;
import br.com.desafioestoque.repository.SecaoRepository;
import br.com.desafioestoque.service.BebidaService;

@RestController
@RequestMapping("/bebida")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BebidaController {

	@Autowired
	private BebidaRepository bebidaRepository;
	
	@Autowired
	private BebidaService bebidaService;
	
	@Autowired
	private SecaoRepository secaoRepository;
	
	@GetMapping
	public ResponseEntity<List <Bebida>> getAll(){
		return ResponseEntity.ok(bebidaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bebida> getById(@PathVariable Long id){
		return bebidaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Bebida>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(bebidaRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/tipo/{tipoBebida}")
	public ResponseEntity<Optional<Bebida>> getByTipoBebida(@PathVariable String tipoBebida){
		return ResponseEntity.ok(bebidaRepository.findByTipoBebida(tipoBebida));
	}
	
//	@PostMapping
//    public ResponseEntity<Bebida> postBebida(@Valid @RequestBody Bebida bebida){
//
//        if(secaoRepository.existsById(bebida.getSecao().getId()))
//            return ResponseEntity.status(HttpStatus.CREATED).body(bebidaRepository.save(bebida));
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }
	
	@PostMapping
    public ResponseEntity<Bebida> postBebida(@RequestBody Bebida bebida){
		return bebidaService.checarTipoBebida(bebida)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
	
	@PutMapping
    public ResponseEntity<Bebida> putBebida(@Valid @RequestBody Bebida bebida){

        if(bebidaRepository.existsById(bebida.getId())) {
            if(secaoRepository.existsById(bebida.getSecao().getId()))
                return ResponseEntity.status(HttpStatus.OK)
                        .body(bebidaRepository.save(bebida));
        }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBebida(@PathVariable Long id) {

        return bebidaRepository.findById(id)
                .map(resposta -> {
                    bebidaRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
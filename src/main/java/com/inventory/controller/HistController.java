//package br.com.desafioestoque.controller;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.desafioestoque.model.Hist;
//import br.com.desafioestoque.repository.HistRepository;
//
//@RestController
//@RequestMapping("/historico")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class HistController {
//    @Autowired
//    private HistRepository historicoRepository;
//
//    @GetMapping
//    public ResponseEntity<List<Hist>> getAll() {
//        return ResponseEntity.ok(historicoRepository.findAll());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Hist> getById(@PathVariable Long id) {
//        return historicoRepository.findById(id)
//                .map(resposta -> ResponseEntity.ok(resposta))
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/entrada")
//    public ResponseEntity<List<Hist>> getByEntrada(@PathVariable LocalDateTime entrada) {
//        return ResponseEntity.ok(historicoRepository.findAllByEntrada(entrada));
//    }
//
//    @GetMapping("/saida")
//    public ResponseEntity<List<Hist>> getBySaida(@PathVariable LocalDateTime saida) {
//        return ResponseEntity.ok(historicoRepository.findAllBySaida(saida));
//    }
//
//}

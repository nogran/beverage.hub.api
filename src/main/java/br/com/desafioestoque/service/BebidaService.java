package br.com.desafioestoque.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.desafioestoque.model.Bebida;
import br.com.desafioestoque.model.Secao;
import br.com.desafioestoque.repository.BebidaRepository;
import br.com.desafioestoque.repository.SecaoRepository;

@Service
public class BebidaService {
	
	private BebidaRepository bebidaRepository;
	private SecaoRepository secaoRepository;
	
	public Optional<Bebida> checarTipoBebida(Bebida bebida, Secao secao) {		
				
		if (bebidaRepository.findByTipoBebida(bebida.getTipoBebida())
				.equals(secaoRepository.findByTipoSecao(secao.getTipoSecao()))) {

		return Optional.of(bebidaRepository.save(bebida));
	}
		return Optional.empty();
	}
}

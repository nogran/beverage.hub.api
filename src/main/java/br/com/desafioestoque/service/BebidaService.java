package br.com.desafioestoque.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioestoque.model.Bebida;
import br.com.desafioestoque.repository.BebidaRepository;
import br.com.desafioestoque.repository.SecaoRepository;

@Service
public class BebidaService {

	@Autowired
	private BebidaRepository bebidaRepository;
	
	@Autowired
	private SecaoRepository secaoRepository;

	public Optional<Bebida> checarTipoBebida(Bebida bebida) {

		if (bebidaRepository.findByTipoBebida(bebida.getTipoBebida())
				.equals(secaoRepository.findByTipoSecao(bebida.getSecao().getTipoSecao()))) {

			return Optional.of(bebidaRepository.save(bebida));
		}
		return Optional.empty();
	}
}

package br.upe.acs.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.upe.acs.dominio.Protocolo;
import br.upe.acs.repositorio.ProtocoloRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProtocoloServico {
	
	private final ProtocoloRepositorio repositorio;
	
	public List<Protocolo> listarProtocolos() {
		return repositorio.findAll();
	}

	public Optional<Protocolo> buscarProtocoloPorId(Long id) throws AcsExcecao {
		if (repositorio.findById(id).isEmpty()) {
			throw new AcsExcecao("Não existe um protocolo associado a este id!");
		}

		return repositorio.findById(id);
	}

}

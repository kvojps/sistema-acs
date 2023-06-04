package br.upe.acs.servico;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.upe.acs.dominio.Usuario;
import br.upe.acs.repositorio.UsuarioRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServico {
	private final UsuarioRepositorio repositorio;
	
	public Optional<Usuario> buscarUsuarioPorId(Long id) throws AcsExcecao {
		if (repositorio.findById(id).isEmpty()) {
			throw new AcsExcecao("Não existe um usuário associado a este id!");
		}
		
		return repositorio.findById(id);
	}
}

package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.Usuario;
import lombok.Getter;

@Getter
public class UsuarioResposta {
    private final Long id;
    private final String nomeCompleto;
    private final String cpf;
    private final String telefone;
    private final String email;

    public UsuarioResposta(Usuario usuario) {
        this.id = usuario.getId();
        this.nomeCompleto = usuario.getNomeCompleto();
        this.cpf = usuario.getCpf();
        this.telefone = usuario.getTelefone();
        this.email = usuario.getEmail();
    }
}
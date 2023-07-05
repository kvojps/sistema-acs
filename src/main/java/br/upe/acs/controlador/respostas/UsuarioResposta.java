package br.upe.acs.controlador.respostas;

import br.upe.acs.controlador.respostas.CursoResposta;
import br.upe.acs.controlador.respostas.EnderecoResposta;
import br.upe.acs.dominio.Aluno;
import br.upe.acs.dominio.Endereco;
import br.upe.acs.dominio.enums.PerfilEnum;
import lombok.Getter;

@Getter
public class UsuarioResposta {
    private final Long id;
    private final String nomeCompleto;
    private final String cpf;
    private final String matricula;
    private final String telefone;
    private final String email;

    private final PerfilEnum perfil;
    private final CursoResposta curso;
    private final int periodo;
    private final boolean verificado;
    private final EnderecoResposta endereco;

    public UsuarioResposta(Aluno aluno) {
        this.id = aluno.getId();
        this.nomeCompleto = aluno.getNomeCompleto();
        this.cpf = aluno.getCpf();
        this.telefone = aluno.getTelefone();
        this.email = aluno.getEmail();
        this.perfil = aluno.getPerfil();
        this.curso = new CursoResposta(aluno.getCurso());
        this.periodo = aluno.getPeriodo();
        this.matricula = aluno.getMatricula();
        this.verificado = aluno.isVerificado();
        this.endereco = converterEndereco(aluno.getEndereco());
    }

    private EnderecoResposta converterEndereco(Endereco endereco) {
        return new EnderecoResposta(endereco);
    }
}

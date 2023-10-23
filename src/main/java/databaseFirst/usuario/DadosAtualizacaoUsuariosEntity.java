package databaseFirst.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuariosEntity(
        @NotNull
        Long id,
        String nome,
        String cpf,
        String senha,
        String repetirSenha) {
}

package databaseFirst.item;

import databaseFirst.usuario.UsuariosEntity;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroItensEntity(
        @NotBlank
        String nome,
        @NotBlank
        String valor,
        @NotBlank
        String empresa,
        @NotBlank
        String descricao,
        @NotBlank
        String endereco,
        int venda,
        UsuariosEntity usuariosEntity) {
}

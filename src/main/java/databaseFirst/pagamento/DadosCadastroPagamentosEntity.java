package databaseFirst.pagamento;

import databaseFirst.usuario.UsuariosEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPagamentosEntity(
        @NotNull
        Tipo tipo,
        @NotBlank
        @Pattern(regexp = "\\d{16}")
        String numeroCartao,
        UsuariosEntity usuariosEntity
) {
}

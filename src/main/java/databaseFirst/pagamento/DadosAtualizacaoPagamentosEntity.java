package databaseFirst.pagamento;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPagamentosEntity(
        @NotNull
        Long id,
        String numeroCartao) {
}

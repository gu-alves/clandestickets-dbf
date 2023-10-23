package databaseFirst.item;

public record DadosAtualizacaoItensEntity(
        String nome,
        String valor,
        String empresa,
        String descricao,
        String endereco,
        int venda) {
}

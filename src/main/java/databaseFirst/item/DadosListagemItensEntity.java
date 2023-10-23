package databaseFirst.item;

public record DadosListagemItensEntity(
        Long id,
        String nome,
        String valor,
        String empresa,
        String descricao,
        String endereco,
        int venda,
        Long usuario_id,
        String usuario_nome,
        String usuario_cpf
) {
    public DadosListagemItensEntity(ItensEntity itens) {
        this(
                itens.getId(),
                itens.getNome(),
                itens.getValor(),
                itens.getEmpresa(),
                itens.getDescricao(),
                itens.getEndereco(),
                itens.getVenda(),
                (itens.getUsuariosEntity() != null ? itens.getUsuariosEntity().getId() : null),
                (itens.getUsuariosEntity() != null ? itens.getUsuariosEntity().getNome() : null),
                (itens.getUsuariosEntity() != null ? itens.getUsuariosEntity().getCpf() : null)
        );
    }
}


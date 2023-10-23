package databaseFirst.pagamento;

public record DadosListagemPagamentosEntity(Long id, Tipo tipo, String numero_cartao, Long usuario_id, String usuario_nome, String usuario_cpf) {
    public DadosListagemPagamentosEntity(PagamentosEntity pagamento) {
        this(
                pagamento.getId(),
                pagamento.getTipo(),
                pagamento.getNumeroCartao(),
                (pagamento.getUsuariosEntity() != null ? pagamento.getUsuariosEntity().getId() : null),
                (pagamento.getUsuariosEntity() != null ? pagamento.getUsuariosEntity().getNome() : null),
                (pagamento.getUsuariosEntity() != null ? pagamento.getUsuariosEntity().getCpf() : null));
    }
}

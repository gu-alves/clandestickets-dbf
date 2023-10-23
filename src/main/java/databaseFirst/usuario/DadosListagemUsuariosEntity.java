package databaseFirst.usuario;

public record DadosListagemUsuariosEntity(Long id, String nome, String cpf, String senha, String repetirSenha) {

    public DadosListagemUsuariosEntity(UsuariosEntity usuariosEntity) {
        this(usuariosEntity.getId(), usuariosEntity.getNome(), usuariosEntity.getCpf(),
                usuariosEntity.getSenha(), usuariosEntity.getRepetirSenha());
    }
}

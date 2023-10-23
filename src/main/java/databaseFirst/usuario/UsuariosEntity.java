package databaseFirst.usuario;

import databaseFirst.item.ItensEntity;
import databaseFirst.pagamento.PagamentosEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "usuario")
@Table(name = "usuarios", schema = "clandestickets")
public class UsuariosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Basic
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;
    @Basic
    @Column(name = "senha", nullable = false, length = 20)
    private String senha;
    @Basic
    @Column(name = "repetir_senha", nullable = false, length = 20)
    private String repetirSenha;

    @OneToMany(mappedBy = "usuario")
    private List<ItensEntity> itens;

    @OneToMany(mappedBy = "usuario")
    private List<PagamentosEntity> pagamentos;

    public UsuariosEntity() {
    }

    public UsuariosEntity(long id, String nome, String cpf, String senha,
                          String repetirSenha, List<ItensEntity> itens, List<PagamentosEntity> pagamentos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.repetirSenha = repetirSenha;
        this.itens = itens;
        this.pagamentos = pagamentos;
    }

    public UsuariosEntity(DadosCadastroUsuariosEntity dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.senha = dados.senha();
        this.repetirSenha = dados.repetirSenha();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRepetirSenha() {
        return repetirSenha;
    }

    public void setRepetirSenha(String repetirSenha) {
        this.repetirSenha = repetirSenha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuariosEntity that = (UsuariosEntity) o;
        return id == that.id && Objects.equals(nome, that.nome) && Objects.equals(cpf, that.cpf)
                && Objects.equals(senha, that.senha) && Objects.equals(repetirSenha, that.repetirSenha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, senha, repetirSenha);
    }

    public void atualizarInformacoes(DadosAtualizacaoUsuariosEntity dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if (dados.senha() != null) {
            this.senha = dados.senha();
        }
        if (dados.repetirSenha() != null) {
            this.repetirSenha = dados.repetirSenha();
        }
    }
}

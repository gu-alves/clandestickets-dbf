package databaseFirst.pagamento;

import databaseFirst.usuario.UsuariosEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "pagamento")
@Table(name = "pagamentos", schema = "clandestickets")
public class PagamentosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Basic
    @Column(name = "numero_cartao", nullable = false, length = 100)
    private String numeroCartao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuariosEntity usuariosEntity;

    public PagamentosEntity() {
    }

    public PagamentosEntity(long id, Tipo tipo, String numeroCartao, UsuariosEntity usuariosEntity) {
        this.id = id;
        this.tipo = tipo;
        this.numeroCartao = numeroCartao;
        this.usuariosEntity = usuariosEntity;
    }

    public PagamentosEntity(DadosCadastroPagamentosEntity dados) {
        this.tipo = dados.tipo();
        this.numeroCartao = dados.numeroCartao();
        this.usuariosEntity = dados.usuariosEntity();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public UsuariosEntity getUsuariosEntity() {
        return usuariosEntity;
    }

    public void setUsuariosEntity(UsuariosEntity usuariosEntity) {
        this.usuariosEntity = usuariosEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PagamentosEntity that)) return false;
        return getId() == that.getId() && Objects.equals(getTipo(), that.getTipo())
                && Objects.equals(getNumeroCartao(), that.getNumeroCartao())
                && Objects.equals(getUsuariosEntity(), that.getUsuariosEntity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTipo(), getNumeroCartao(), getUsuariosEntity());
    }

    public void atualizarInformacoes(DadosAtualizacaoPagamentosEntity dados) {
        if (dados.numeroCartao() != null) {
            this.numeroCartao = dados.numeroCartao();
        }
    }
}
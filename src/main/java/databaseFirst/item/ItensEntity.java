package databaseFirst.item;

import databaseFirst.usuario.UsuariosEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "item")
@Table(name = "itens", schema = "clandestickets")
public class ItensEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Basic
    @Column(name = "valor", nullable = false, length = 100)
    private String valor;
    @Basic
    @Column(name = "empresa", nullable = false, length = 100)
    private String empresa;
    @Basic
    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;
    @Basic
    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;
    @Basic
    @Column(name = "venda", nullable = true)
    private int venda;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuariosEntity usuariosEntity;

    public ItensEntity() {
    }

    public ItensEntity(DadosCadastroItensEntity dados) {
        this.nome = dados.nome();
        this.valor = dados.valor();
        this.empresa = dados.empresa();
        this.descricao = dados.descricao();
        this.endereco = dados.endereco();
        this.venda = 1;
        this.usuariosEntity = dados.usuariosEntity();
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
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
        if (o == null || getClass() != o.getClass()) return false;
        ItensEntity that = (ItensEntity) o;
        return id == that.id && Objects.equals(nome, that.nome) && Objects.equals(valor, that.valor)
                && Objects.equals(empresa, that.empresa) && Objects.equals(descricao, that.descricao)
                && Objects.equals(endereco, that.endereco) && Objects.equals(venda, that.venda)
                && Objects.equals(usuariosEntity, that.usuariosEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, valor, empresa, descricao, endereco, venda, usuariosEntity);
    }

    public void atualizarInformacoes(DadosAtualizacaoItensEntity dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.valor() != null) {
            this.valor = dados.valor();
        }
        if (dados.empresa() != null) {
            this.empresa = dados.empresa();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.endereco() != null) {
            this.endereco = dados.endereco();
        }
        if (dados.venda() != 0) {
            this.venda = dados.venda();
        }
    }
}

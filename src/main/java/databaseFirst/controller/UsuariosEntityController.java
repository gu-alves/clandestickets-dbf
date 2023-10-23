package databaseFirst.controller;

import databaseFirst.item.ItensEntity;
import databaseFirst.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("usuarios")
public class UsuariosEntityController {

    @Autowired
    private UsuariosEntityRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroUsuariosEntity dados) {
        repository.save(new UsuariosEntity(dados));
    }

    @GetMapping
    public Page<DadosListagemUsuariosEntity> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemUsuariosEntity::new);
    }

    @GetMapping("/{id}")
    public Optional<UsuariosEntity> buscarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuariosEntity dados) {
        var usuariosEntity =  repository.getReferenceById(dados.id());
        usuariosEntity.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
      repository.deleteById(id);
    }
}

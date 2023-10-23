package databaseFirst.controller;

import databaseFirst.pagamento.*;
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
@RequestMapping("pagamentos")
public class PagamentosEntityController {

    @Autowired
    private PagamentosEntityRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPagamentosEntity dados) {
        repository.save(new PagamentosEntity(dados));
    }

    @GetMapping
    public Page<DadosListagemPagamentosEntity> listar(@PageableDefault(sort = {"id"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemPagamentosEntity::new);
    }

    @GetMapping("/{id}")
    public Optional<PagamentosEntity> buscarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPagamentosEntity dados) {
        var itens =  repository.getReferenceById(dados.id());
        itens.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
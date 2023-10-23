package databaseFirst.controller;

import databaseFirst.item.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("itens")
public class ItensEntityController {

    @Autowired
    private ItensEntityRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroItensEntity dados) {
        repository.save(new ItensEntity(dados));
    }

    @GetMapping
    public List<DadosListagemItensEntity> listar() {
        return repository.findAll().stream().map(DadosListagemItensEntity::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<ItensEntity> buscarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoItensEntity dados) {
        var itens = repository.getReferenceById(id);
        itens.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

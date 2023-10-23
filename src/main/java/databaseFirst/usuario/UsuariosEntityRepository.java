package databaseFirst.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosEntityRepository extends JpaRepository<UsuariosEntity, Long> {
    Page<UsuariosEntity> findAll(Pageable paginacao);
    UsuariosEntity findByCpfAndSenha(String cpf, String senha);
    Optional<UsuariosEntity> findById(Long id);
}

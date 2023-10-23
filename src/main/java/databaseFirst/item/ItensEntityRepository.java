package databaseFirst.item;

import databaseFirst.item.ItensEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItensEntityRepository extends JpaRepository<ItensEntity, Long> {
    Page<ItensEntity> findAll(Pageable paginacao);
    Optional<ItensEntity> findById(Long id);
}

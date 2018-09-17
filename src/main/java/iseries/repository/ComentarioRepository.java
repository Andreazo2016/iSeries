package iseries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iseries.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}

package iseries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iseries.model.Episodio;

@Repository
public interface EpisodioRepository extends JpaRepository<Episodio, Integer> {

}

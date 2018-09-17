package iseries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import iseries.model.Temporada;

@Repository
public interface TemporadaRepository extends JpaRepository<Temporada, Integer> {

	@Query(value = "select * from temporadas where serie_id=?1", nativeQuery = true)
	List<Temporada> findTemporadaOfSerie(Integer serie_id);
	
}

package iseries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iseries.model.Serie;

@Repository
public interface SerieRepository  extends JpaRepository<Serie, Integer>{

}

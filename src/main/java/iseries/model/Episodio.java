package iseries.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="episodios")
public class Episodio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 9, max = 20, message="O tamanho deve ser entre {min} e {max}")
	private String titulo;

	@ManyToOne
	@JoinColumn(name="temporada_id")
	private Temporada temporada; 
	
	public Episodio() {	}

	public Episodio(Long id) {
		this.id = id;
	}

	public Episodio(Long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}

package iseries.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="temporadas")
public class Temporada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min = 9, max = 12, message="O tamanho deve ser entre {min} e {max}")
	private String numero;
	
	@NotNull
	@Size(min = 4, max = 15, message="O tamanho deve ser entre {min} e {max}")
	private String duracao;
	
	@ManyToOne
	@JoinColumn(name="serie_id")
	private Serie serie;
	
	@OneToMany
	(mappedBy = "temporada", targetEntity = Episodio.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Episodio> episodios;
	
	public Temporada() {}

	public Temporada(Integer id) {
		super();
		this.id = id;
	}

	public Temporada(Integer id, String numero, String duracao, Serie serie, List<Episodio> episodios) {
		super();
		this.id = id;
		this.numero = numero;
		this.duracao = duracao;
		this.serie = serie;
		this.episodios = episodios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public List<Episodio> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(List<Episodio> episodios) {
		this.episodios = episodios;
	}

}

package iseries.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="series")
public class Serie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_SERIE")
	private Integer id;
	@NotNull
	@Size(max = 50, message="O tamanho maximo é de {max}")
	private String nome;
	@NotNull
	@Size(min = 1, max = 15, message="O tamanho deve ser entre {min} e {max}")
	private String diretor;
	@NotNull
	@Size(min =1, max = 15, message="O tamanho deve ser entre {min} e {max}")
	private String origem;
	@NotNull
	@Size(max = 10, message="O tamanho maximo é de {max}")
	private String genero;
	@NotNull
	@Size(min = 1, max = 500, message="O tamanho deve ser entre {min} e {max}")
	private String sinopse;
	@NotNull
	@Size(min = 4, max = 4, message="Deve ser apenas o ano exato... Ex: 2017")
	private String ano;
	
	@Column(name="PATH")
	private String path;

	@ManyToMany(mappedBy="minhas_series",  fetch=FetchType.LAZY)
	private Collection<Usuario> usuarios;

	@OneToMany
	(mappedBy = "serie", targetEntity = Temporada.class, fetch = FetchType.LAZY, 
	cascade = CascadeType.ALL)
	private List<Temporada> temporadas;

	@OneToMany
	(mappedBy="serie", targetEntity=Comentario.class,	fetch=FetchType.LAZY,
	cascade=CascadeType.ALL)
	private Collection<Comentario> comentarios;

	public Serie() {}

	public Serie(Integer id) {
		super();
		this.id = id;
	}

	public Serie(Integer id, String nome, String diretor, String origem, String genero, String sinopse, String ano,
			String path, List<Temporada> temporadas) {
		super();
		this.id = id;
		this.nome = nome;
		this.diretor = diretor;
		this.origem = origem;
		this.genero = genero;
		this.sinopse = sinopse;
		this.ano = ano;
		this.path = path;
		this.temporadas = temporadas;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(List<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
}

package iseries.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_USUARIO", nullable=false)
	private Integer id;
	
	@NotNull 
	@Size(max = 25, message="O tamanho deve ser entre {min} e {max}")
	private String login;
	
	@NotNull 
	private String email;
	
	@NotNull 
	@Size(max = 10, message="O tamanho deve ser entre {min} e {max}")
	private String senha;
	
	@NotNull 
	private boolean admin;
	
	@Column(name="PATH")
	private String path;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USUARIO_SERIE", 
	joinColumns = { @JoinColumn(name = "ID_USUARIO", referencedColumnName="ID_USUARIO")}, 
	inverseJoinColumns = { @JoinColumn(name = "ID_SERIE",  referencedColumnName="ID_SERIE") })
	private Collection<Serie> minhas_series;

	@OneToMany
	(mappedBy="usuario", targetEntity=Comentario.class, fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Collection<Comentario> comentarios;
	
	public Usuario() { }

	public Usuario(int id){
		this.id = id;
	}

	public Usuario(Integer id, String login, String email, String senha, boolean admin) {
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.admin = admin;
	}

	public Usuario(Integer id, String login, String email, String senha, boolean admin,
			Collection<Serie> minhas_series) {
		super();
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.admin = admin;
		this.minhas_series = minhas_series;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Collection<Serie> getMinhas_series() {
		return minhas_series;
	}

	public void setMinhas_series(Collection<Serie> minhas_series) {
		this.minhas_series = minhas_series;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
}

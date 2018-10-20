package iSeriesTeste;

import iseries.model.Comentario;
import iseries.model.Serie;
import iseries.model.Usuario;

import java.util.Collection;

public class UsuarioBuilder {

    private Usuario usuario;
    public UsuarioBuilder(){
        this.usuario = new Usuario();
    }
    public UsuarioBuilder setLogin(String login) {
        this.usuario.setLogin(login);
        return this;
    }
    public UsuarioBuilder setEmail(String email) {
        this.usuario.setEmail(email);
        return this;
    }
    public UsuarioBuilder setSenha(String senha) {
        this.usuario.setSenha(senha);
        return this;
    }
    public UsuarioBuilder setAdmin(boolean admin) {
        this.usuario.setAdmin(admin);
        return this;
    }
    public UsuarioBuilder setMinhasSeries(Collection<Serie> minhas_series) {
        this.usuario.setMinhas_series(minhas_series);
        return this;
    }
    public UsuarioBuilder setComentarios(Collection<Comentario> comentarios) {
        this.usuario.setComentarios(comentarios);
        return this;
    }
    public Usuario build(){return this.usuario;}
}

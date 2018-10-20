package iseries.model;

public class UsuarioDTO {
    private String login = "default";
    private String senha;
    private String email;
    private String path;
    private boolean admin;

    public UsuarioDTO(String login, String senha, String email,String path, boolean admin) {
        this.login = login;
        this.senha = senha;
        this.path = path;
        this.admin = admin;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


import iseries.App;
import iseries.model.Usuario;
import iseries.repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={App.class})
public class LoginTest {

    @Autowired private UsuarioRepository usuarioRepository;
    private final String LOGIN = "andreazo18";
    private final String SENHA =  "123321a";
    private static Usuario usuario;

    @Before
    public  void initUser(){
        usuario = new Usuario();
        usuario.setEmail("andreazo2012@gmail.com");
        usuario.setLogin("devman");
        usuario.setSenha("solon123");
    }
    @Test
    public void testarLogin() {
        Usuario usuariotest =  usuarioRepository.findByLoginAndSenha(LOGIN,SENHA);
        Assert.assertEquals(usuariotest.getEmail(), "andreazo18@gmail.com");
    }

    @Test
   public  void testarSalvarUsuario(){
        Usuario usuarioSavo = usuarioRepository.save(usuario);
        Assert.assertEquals(usuarioSavo.getEmail(),"andreazo2012@gmail.com");
        Assert.assertEquals(usuarioSavo.getLogin(),"devman");
        Assert.assertEquals(usuario.getSenha(),"solon123");
    }

}
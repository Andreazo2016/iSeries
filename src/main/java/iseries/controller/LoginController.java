package iseries.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import iseries.model.Usuario;
import iseries.repository.UsuarioRepository;

@Controller
public class LoginController {

	@Autowired
	UsuarioRepository userRepo;

	@RequestMapping(value = "efeturarLogin", method = RequestMethod.POST)
	String logar(Usuario usuario, HttpSession session){
		
		List<Usuario> user = userRepo.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
		
		if(user.size() != 0){
			
			session.setAttribute("usuario", user.get(0));
			
			return "redirect:homeUsuario";
		}
		return "forward:/";
	}
	
	@RequestMapping("logout")
	String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
}

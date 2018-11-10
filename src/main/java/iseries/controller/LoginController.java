package iseries.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import iseries.model.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import iseries.model.Usuario;
import iseries.repository.UsuarioRepository;

@Controller
public class LoginController {

	@Autowired UsuarioRepository userRepo;

	@PostMapping(value = "efeturarLogin")
	String logar(UsuarioDTO usuario, HttpSession session){
		
		Usuario user = userRepo.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
		
		if(user != null){
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

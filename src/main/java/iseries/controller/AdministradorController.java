package iseries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import iseries.model.Usuario;
import iseries.repository.SerieRepository;
import iseries.repository.TemporadaRepository;
import iseries.repository.UsuarioRepository;

@Controller
public class AdministradorController {

	@Autowired
	UsuarioRepository userRepo;
	
	@Autowired
	SerieRepository serieRepo;
	
	@Autowired
	TemporadaRepository tempoRepo;  
	
	@RequestMapping("listaUsuarios")
	String listarUsuarios(Model model){
		
		List<Usuario> usuarios =  userRepo.findAll();
		
		model.addAttribute("lista_usuarios", usuarios);
		
		return "/adm/lista-usuarios";
	}
	
}

package iseries.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import iseries.model.Serie;
import iseries.repository.SerieRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@Autowired
	SerieRepository serieRepo;
	
	//Raiz
	@RequestMapping("/")
	@ResponseBody String  home(Model model){

		/*
		List<Serie> series = serieRepo.findAll();
		Collections.shuffle(series);
		model.addAttribute("serie", series.get(0));
		*/
		return "Deploy with jenkins";
	}
	
	// Página Inicial
	@RequestMapping("homeUsuario")
	String homeUsuario(HttpSession session){
		
		List<Serie> series = serieRepo.findAll();
		session.setAttribute("lista_series", series);
		
		return "/user/HomePage";
	}
}

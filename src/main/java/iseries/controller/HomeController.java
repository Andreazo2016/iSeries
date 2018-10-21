package iseries.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import iseries.repository.SerieRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@Autowired
	SerieRepository serieRepo;
	

	@RequestMapping("/")
	@ResponseBody String  home(Model model){
		return "TESTANDO O NOVO FORMATO: OH YES";
	}
	
	@RequestMapping("homeUsuario")
	String homeUsuario(HttpSession session){
		return "/user/HomePage";
	}
}

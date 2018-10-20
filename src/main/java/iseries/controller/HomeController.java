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
	

	@RequestMapping("/")
	@ResponseBody String  home(Model model){
		return "TESTANDO A VERA : AULA";
	}
	
	@RequestMapping("homeUsuario")
	String homeUsuario(HttpSession session){
		return "/user/HomePage";
	}
}

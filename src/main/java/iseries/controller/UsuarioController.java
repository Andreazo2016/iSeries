package iseries.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iseries.model.Serie;
import iseries.model.Usuario;
import iseries.repository.SerieRepository;
import iseries.repository.UsuarioRepository;
import iseries.util.FileUtil;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository userRepo;

	@Autowired
	private SerieRepository serieRepo;

	@Autowired
	private ServletContext servletContext;

	// Inserindo Usuario
	@RequestMapping(value = "efetuarCadastro", method = RequestMethod.POST)
	String addUsuario(@Valid Usuario usuario, BindingResult result, Model model, 
			RedirectAttributes redirectAttributes, @RequestParam(value="imagem", required=false) MultipartFile imagem) throws IOException{

		if(result.hasErrors()){
			redirectAttributes.addFlashAttribute("msgErro", "Erro ao Cadastrar");
			return "redirect:/";
		}

		if(imagem.getBytes().length != 0){
			FileUtil.salvarImagem(servletContext.getRealPath("/")+"resources/img/usuarios/"+usuario.getLogin()+".png", imagem);
			usuario.setPath(usuario.getLogin()+".png");
		}else{
			usuario.setPath("news.png");
		}

		redirectAttributes.addFlashAttribute("msgOk", "Cadastro Realizado com Sucesso!");
		userRepo.save(usuario);
		return "redirect:/";
	}

	//Atualizar Usuario
	@RequestMapping("updateUsuario")
	String update(HttpSession session, Usuario usuario, RedirectAttributes redirectAttributes){

		this.userRepo.save(usuario);
		session.setAttribute("usuario", this.userRepo.getOne(usuario.getId()));
		redirectAttributes.addFlashAttribute("msgOk", "Atualizado com Sucesso");
		
		return "forward:myProfile";
	}

	//Ver Perfil
	@RequestMapping("myProfile")
	String myProfile(){
		return "/user/Profile";

	}

	// Visualizando Series Na Lista Pessoal
	@RequestMapping("mySeries")
	String lookMySeries(HttpSession session, Model model){

		Usuario user = (Usuario) session.getAttribute("usuario");

		user = this.userRepo.findOne(user.getId());

		model.addAttribute("usuario", user);

		return "/user/minhas-series";
	}

	// Adicionando Serie Na Lista Pessoal
	@RequestMapping(value = "addInMyList", method = RequestMethod.GET)
	String addMyList(@RequestParam(value="idUser", required=true) Integer id_user, 
			@RequestParam(value="idSerie", required=true) Integer nova_serie,
			HttpSession session){

		Usuario user = this.userRepo.findOne(id_user);

		Collection<Serie> series = new ArrayList<Serie>();

		for(Serie s : user.getMinhas_series()){
			if(s.getId() == nova_serie){
				session.setAttribute("usuario", this.userRepo.getOne(id_user));
				return "redirect:homeUsuario";
			}
			series.add(this.serieRepo.findOne(s.getId()));
		}

		series.add(this.serieRepo.findOne(nova_serie));

		user.setMinhas_series(series);

		this.userRepo.save(user);

		session.setAttribute("usuario", this.userRepo.getOne(id_user));

		return "redirect:homeUsuario";		
	}

	// Removendo Serie da Lista Pessoal
	@RequestMapping(value = "removeSerieMyList", method = RequestMethod.GET)
	String removeSerieMyList(HttpSession session ,@RequestParam(value="ids", required=true) Integer ids){

		Usuario user = (Usuario) session.getAttribute("usuario");
		user = this.userRepo.findOne(user.getId());
		Serie serie = this.serieRepo.findOne(ids); // Serie que vai ser removida

		Collection<Serie> series = new ArrayList<Serie>();

		for(Serie s : user.getMinhas_series())
			series.add(this.serieRepo.findOne(s.getId()));

		series.remove(serie);

		user.setMinhas_series(series);

		this.userRepo.save(user);

		return "redirect:mySeries";
	}



}

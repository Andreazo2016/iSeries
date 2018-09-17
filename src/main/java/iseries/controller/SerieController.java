package iseries.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iseries.model.Comentario;
import iseries.model.Serie;
import iseries.repository.ComentarioRepository;
import iseries.repository.SerieRepository;
import iseries.repository.TemporadaRepository;
import iseries.repository.UsuarioRepository;
import iseries.util.FileUtil;

@Controller
public class SerieController {

	@Autowired
	UsuarioRepository userRepo;
	
	@Autowired
	SerieRepository serieRepo;
	
	@Autowired
	TemporadaRepository tempRepo;
	
	@Autowired
	ComentarioRepository comentRepo;
	
	@Autowired
	private ServletContext servletContext;
	
	// Inserindo Serie
	@RequestMapping(value = "cadastraSerie", method = RequestMethod.POST)
	String cadastraSerie(@Valid Serie serie, @RequestParam(value="imagem", required=false) MultipartFile imagem,
			BindingResult result, Model model, RedirectAttributes redirectAttributes) throws IOException{
		
		if(result.hasErrors()){
			redirectAttributes.addFlashAttribute("msgErro", "Erro ao Cadastrar Serie");
			return "redirect:homeUsuario";
		}
		
		if(imagem.getBytes().length != 0){
			FileUtil.salvarImagem(servletContext.getRealPath("/")+"resources/img/noticias/"+serie.getNome()+".png", imagem);
			serie.setPath(serie.getNome()+".png");
		}else{
			serie.setPath("news.png");
		}
		
		redirectAttributes.addFlashAttribute("msgOK", "Serie Cadastrada com Sucesso");
		serieRepo.save(serie);
		return "redirect:homeUsuario";
	}
	
	// Atualizando Serie
	@RequestMapping(value = "updateSerie", method = RequestMethod.POST)
	String updateSerie(@Valid Serie serie, Model model, @RequestParam(value="imagem", required=false) MultipartFile imagem,
			BindingResult result, RedirectAttributes redirectAttributes) throws IOException{
		
		if(result.hasErrors()){
			serie = serieRepo.findOne(serie.getId());
			model.addAttribute("serie", serie);
			redirectAttributes.addFlashAttribute("msgErro", "Erro ao Atualizar Serie");
			return "/user/visualizar-serie";
		}
		
		if(imagem.getBytes().length != 0){
			FileUtil.salvarImagem(servletContext.getRealPath("/")+"resources/img/noticias/"+serie.getNome()+".png", imagem);
			serie.setPath(serie.getNome()+".png");
		}else{
			serie.setPath("news.png");
		}
		
		redirectAttributes.addFlashAttribute("msgOk", "Serie atualizada com Sucesso");
		
		serieRepo.save(serie);
		
		model.addAttribute("serie", this.serieRepo.getOne(serie.getId()));
		model.addAttribute("temporadas", this.tempRepo.findTemporadaOfSerie(serie.getId()) );
		
		return "/user/visualizar-serie";
	}
	
	// Visualizando Serie
	@RequestMapping(value = "viewSerie", method = RequestMethod.GET)
	String viewSerie(HttpSession session, Serie serie, Model model){
		
		model.addAttribute("serie", this.serieRepo.getOne(serie.getId()));
		model.addAttribute("temporadas", this.tempRepo.findTemporadaOfSerie(serie.getId()) );
		
		return "/user/visualizar-serie";
	}
	
	//Usando p/ Quando add/del Temporada...
	@RequestMapping(value = "viewSerieII", method = RequestMethod.GET)
	String viewSerieII(HttpSession session, Model model, @RequestParam(value="id", required=false) Integer id){
		
		if(session.getAttribute("idx") != null){
			id = (Integer) session.getAttribute("idx");
			session.setAttribute("idx", null);
		}
		
		model.addAttribute("serie", this.serieRepo.getOne(id));
		model.addAttribute("temporadas", this.tempRepo.findTemporadaOfSerie(id) );
		
		return "/user/visualizar-serie";
	}

	//Adicionando Comentario
	@SuppressWarnings("deprecation")
	@RequestMapping("/adicionarComentario")
	@ResponseBody
	public String adicionarComentario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.set(date.getYear(), date.getMonth(), date.getDate());
		
		Comentario comentario = new Comentario();
		// Montando Comentário
		comentario.setId_usuario(Integer.parseInt(request.getParameter("user")));
		comentario.setId_serie(Integer.parseInt(request.getParameter("serie")));
		comentario.setTexto(request.getParameter("texto"));
		// Relacionando
		comentario.setUsuario(this.userRepo.findOne(Integer.parseInt(request.getParameter("user"))));
		comentario.setSerie(this.serieRepo.findOne(Integer.parseInt(request.getParameter("serie"))));
		// Registrando a Data/Hora
		comentario.setData(calendar);
		
		if(this.comentRepo.save(comentario) != null){
			String coment = "{"+
					"\"autor\":\""+comentario.getUsuario().getLogin()+"\","+
					"\"noticia\":\""+comentario.getId_serie()+"\","+
					"\"texto\":\""+comentario.getTexto()+"\","+
					"\"data\":"+date.getTime()+"}";
			comentario = null;
			return coment;
		}
		comentario = null;
		return "";
	}
	
	//Removendo Comentario
	@RequestMapping(value = "deletarComentario", method = RequestMethod.GET)
	String removerComentario(Comentario comentario, HttpSession session){
		
		comentario = this.comentRepo.findOne(comentario.getId());
		
		this.comentRepo.delete(comentario);
		
		session.setAttribute("idx", comentario.getId_serie());
		
		return "redirect:viewSerieII";
	}

}















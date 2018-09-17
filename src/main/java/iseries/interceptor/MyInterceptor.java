package iseries.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MyInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		/*
		System.out.println("executando interceptor - preHandle");

		String uri = request.getRequestURI();

		if(uri.endsWith("/") || 
				uri.endsWith("index") || 
				uri.endsWith("efetuarCadastro") ||
				uri.endsWith("efeturarLogin") ||
				uri.contains("resources")){
			return true;
		}

		if(request.getSession().getAttribute("usuario") != null)
			return true;

		response.sendRedirect("/");
		return false;
		*/
		return true;

	}
}

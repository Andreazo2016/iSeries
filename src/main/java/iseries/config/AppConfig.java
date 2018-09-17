package iseries.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import iseries.interceptor.MyInterceptor;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private MyInterceptor myInterceptor;
	
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(myInterceptor);
	}
}

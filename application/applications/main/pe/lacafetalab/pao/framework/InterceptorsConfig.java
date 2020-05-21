package pe.lacafetalab.pao.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import pe.lacafetalab.pao.shared.domain.valueobject.Role;
import pe.lacafetalab.pao.shared.utils.JsonWebTokenEncriptService;

@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {

	static Logger logger = LoggerFactory.getLogger(InterceptorsConfig.class);

	@Value("${authentication.jwt.secret}")
	private String secret;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor(new JsonWebTokenEncriptService(secret), new Role("PAO_ADMIN"))).addPathPatterns("/admin/**");
		registry.addInterceptor(new AuthInterceptor(new JsonWebTokenEncriptService(secret), new Role("STUDENT"))).addPathPatterns("/students/**");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/docs/**").addResourceLocations("classpath:/custom-files/docs/");
	}
}

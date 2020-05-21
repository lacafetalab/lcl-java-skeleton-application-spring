package pe.lacafetalab.pao.framework;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeansConfigurator {

	@Bean
	public HttpClient httpClient() {
		return HttpClient.newBuilder().version(Version.HTTP_2).followRedirects(Redirect.NORMAL).build();
	}

}

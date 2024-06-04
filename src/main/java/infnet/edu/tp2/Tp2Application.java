package infnet.edu.tp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "infnet.edu.tp2.Repositories")
public class Tp2Application {

	public static void main(String[] args) {

		SpringApplication.run(Tp2Application.class, args);	 
	}

	@Bean
	public WebMvcConfigurer corsSettings() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedOrigins("http://localhost:3000");
			}
		};
	}


}

package pe.feo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = { "pe.feo.persistence.repository",
		"pe.feo.transactional.service" })
@PropertySource("application.properties")
@Profile("test")
public class TestConfig {

}

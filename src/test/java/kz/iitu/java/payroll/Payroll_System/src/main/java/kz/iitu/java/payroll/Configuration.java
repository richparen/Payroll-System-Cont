package kz.iitu.java.payroll;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@ComponentScan("kz.iitu.java.payroll")
@PropertySource(value={"application.properties"})
@EnableJpaRepositories(basePackages = "kz.iitu.java.payroll.repository")
public class Configuration {
}

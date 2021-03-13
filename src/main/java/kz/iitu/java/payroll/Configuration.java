package kz.iitu.java.payroll;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@org.springframework.context.annotation.Configuration
@ComponentScan("kz.iitu.java.payroll")
@PropertySource(value={"application.properties"})
public class Configuration {
}

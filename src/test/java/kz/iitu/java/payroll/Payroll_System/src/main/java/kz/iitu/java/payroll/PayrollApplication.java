package kz.iitu.java.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class PayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayrollApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);

        PayrollSystem payrollSystem = context.getBean("payrollSystem", PayrollSystem.class);
        payrollSystem.showMenu();

        context.registerShutdownHook();
    }
}

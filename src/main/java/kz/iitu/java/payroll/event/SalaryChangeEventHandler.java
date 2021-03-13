package kz.iitu.java.payroll.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {
    @Override
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {
        System.out.println("\nSalaryChangeEventHandler.onApplicationEvent");
        System.out.println("Salary update: " + salaryChangeEvent.getEmployee().getSalary());
        System.out.println("Salary old:    " + salaryChangeEvent.getLastSalary());
        System.out.println("Employee:      " + salaryChangeEvent.getEmployee());
    }
}

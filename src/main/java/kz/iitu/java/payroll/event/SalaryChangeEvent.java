package kz.iitu.java.payroll.event;

import kz.iitu.java.payroll.type.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

public class SalaryChangeEvent extends ApplicationEvent {

    private Employee employee;
    private Double lastSalary;

    public SalaryChangeEvent(Object source, Employee employee, Double lastSalary) {
        super(source);
        this.employee = employee;
        this.lastSalary = lastSalary;
    }

    public Employee getEmployee(){
        return employee;
    }

    public Double getLastSalary(){
        return lastSalary;
    }
}

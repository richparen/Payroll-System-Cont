package kz.iitu.java.payroll.service;

import kz.iitu.java.payroll.type.CommissionEmployee;
import kz.iitu.java.payroll.type.Employee;
import kz.iitu.java.payroll.type.HourlyEmployee;
import kz.iitu.java.payroll.type.SalariedCommissionEmployee;
import org.springframework.stereotype.Component;

@Component
public class SalaryCalculatorService {

    public Employee calculateSalaryHourly(HourlyEmployee hourlyEmployee){
        Double totalSalary;
        if(hourlyEmployee.getWorkHour() > 40){
            totalSalary = 40.0 * hourlyEmployee.getSalaryHour() + (hourlyEmployee.getWorkHour() - 40) * 1.5 * hourlyEmployee.getSalaryHour();
        }else{
            totalSalary = hourlyEmployee.getWorkHour() * hourlyEmployee.getSalaryHour();
        }
        hourlyEmployee.setSalary(totalSalary);
        return hourlyEmployee;
    }

    public Employee calculateSalaryCommission(CommissionEmployee commissionEmployee, Double amount){
        Double bonus = amount * commissionEmployee.getPercentageSales() / 100;
        commissionEmployee.setSalary(commissionEmployee.getSalary() + bonus);
        return commissionEmployee;
    }

    public Employee calculateSalarySalaried(SalariedCommissionEmployee salariedCommissionEmployee, Double amount){
        Double bonus = amount * salariedCommissionEmployee.getPercentageSales() / 100;
        salariedCommissionEmployee.setSalary(salariedCommissionEmployee.getSalary() + bonus);
        return salariedCommissionEmployee;
    }
}

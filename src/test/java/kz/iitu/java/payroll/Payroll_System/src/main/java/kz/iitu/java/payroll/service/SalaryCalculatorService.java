package kz.iitu.java.payroll.service;

import kz.iitu.java.payroll.domain.EmployeeType;
import kz.iitu.java.payroll.repository.EmployeeRepository;
import kz.iitu.java.payroll.type.CommissionEmployee;
import kz.iitu.java.payroll.domain.Employee;

import kz.iitu.java.payroll.type.HourlyEmployee;
import kz.iitu.java.payroll.type.SalariedCommissionEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SalaryCalculatorService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Page<Employee> getAll() {
        Pageable pageable = PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC,"name", "age"));
        return employeeRepository.findAll(pageable);
    }


    public HourlyEmployee calculateSalaryHourly(HourlyEmployee hourlyEmployee){
        Double totalSalary;
        if(hourlyEmployee.getWorkHour() > 40){
            totalSalary = 40.0 * hourlyEmployee.getSalaryHour() + (hourlyEmployee.getWorkHour() - 40) * 1.5 * hourlyEmployee.getSalaryHour();
        }else{
            totalSalary = hourlyEmployee.getWorkHour() * hourlyEmployee.getSalaryHour();
        }
        hourlyEmployee.setSalary(totalSalary);
        calculateSalaryHourly(hourlyEmployee.getId(), EmployeeType.HOURLY, totalSalary);
        return hourlyEmployee;
    }

    public CommissionEmployee calculateSalaryCommission(CommissionEmployee commissionEmployee, Double amount){
        Double bonus = amount * commissionEmployee.getPercentageSales() / 100;
        commissionEmployee.setSalary(commissionEmployee.getSalary() + bonus);
        calculateSalaryCommission(commissionEmployee.getId(), EmployeeType.COMMISION, commissionEmployee.getSalary());
        return commissionEmployee;
    }

    public SalariedCommissionEmployee calculateSalarySalaried(SalariedCommissionEmployee salariedCommissionEmployee, Double amount){
        Double bonus = amount * salariedCommissionEmployee.getPercentageSales() / 100;
        salariedCommissionEmployee.setSalary(salariedCommissionEmployee.getSalary() + bonus);
        calculateSalarySalaried(salariedCommissionEmployee.getId(), EmployeeType.SALARIED_COMMISION, salariedCommissionEmployee.getSalary());
        return salariedCommissionEmployee;
    }

    public void calculateSalarySalaried(int id, EmployeeType employee, Double amount) {
        Employee employee1 = new Employee();
        Optional<Employee> employeeOptional = employeeRepository.findById((long) id);
        if (employeeOptional.isPresent()) {

            Employee dbemployee = employeeOptional.get();
            dbemployee.setFixedSalary(amount);

            employeeRepository.save(dbemployee);
        }
    }

    public void calculateSalaryCommission(int id, EmployeeType employee, Double amount) {
        Employee employee1 = new Employee();
        Optional<Employee> employeeOptional = employeeRepository.findById((long) id);
        if (employeeOptional.isPresent()) {

            Employee dbemployee = employeeOptional.get();
            dbemployee.setCommRate(amount);

            employeeRepository.save(dbemployee);
        }
    }

    public void calculateSalaryHourly(int id, EmployeeType employee, Double amount) {
        Employee employee1 = new Employee();
        Optional<Employee> employeeOptional = employeeRepository.findById((long) id);
        if (employeeOptional.isPresent()) {

            Employee dbemployee = employeeOptional.get();
            dbemployee.setCommRate(amount);

            employeeRepository.save(dbemployee);
        }
    }
}

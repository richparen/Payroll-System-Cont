package kz.iitu.java.payroll.controller;

import kz.iitu.java.payroll.domain.Employee;
import kz.iitu.java.payroll.service.SalaryCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private SalaryCalculatorService salaryCalculatorService;

    public Page<Employee> getAll(){
        return salaryCalculatorService.getAll();
    }
}

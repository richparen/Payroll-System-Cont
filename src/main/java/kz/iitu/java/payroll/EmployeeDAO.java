package kz.iitu.java.payroll;

import kz.iitu.java.payroll.dataBase.DBConnection;
import kz.iitu.java.payroll.event.SalaryChangeEvent;
import kz.iitu.java.payroll.type.CommissionEmployee;
import kz.iitu.java.payroll.type.Employee;
import kz.iitu.java.payroll.type.HourlyEmployee;
import kz.iitu.java.payroll.type.SalariedCommissionEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;
    private DBConnection connection;

    @Autowired
    public EmployeeDAO(DBConnection connection) {
        this.connection = connection;
    }

    public void updateSalary(Employee employee, Double lastSalary){
        String tbName;
        String bonus = " ";

        if(employee instanceof SalariedCommissionEmployee){
            tbName = "salaried_commission_employees";
        } else if(employee instanceof HourlyEmployee){
            tbName = "hourly_employees";
            bonus = ", `salary_hour` = " + ((HourlyEmployee) employee).getSalaryHour();
        } else if(employee instanceof CommissionEmployee){
            tbName = "commission_employees";
        } else{
            tbName = "salaried_employees";
        }

        String sql = "UPDATE " + tbName + " SET salary = " + employee.getSalary() + bonus + " WHERE id = " + employee.getId();
        connection.updateData(sql);
        System.out.println(sql);
        this.applicationEventPublisher.publishEvent(new SalaryChangeEvent(this, employee, lastSalary));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

}

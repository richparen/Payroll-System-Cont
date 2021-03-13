package kz.iitu.java.payroll.domain;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double fixedSalary;
    private double hourRate;
    private int hoursWorked;
    private Double commRate;

    public Employee(String name, double fixedSalary, double hourRate, int hoursWorked, Double commRate, EmployeeType emplType) {
        this.name = name;
        this.fixedSalary = fixedSalary;
        this.hourRate = hourRate;
        this.hoursWorked = hoursWorked;
        this.commRate = commRate;
        this.emplType = emplType;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Double getCommRate() {
        return commRate;
    }

    public void setCommRate(Double commRate) {
        this.commRate = commRate;
    }

    public EmployeeType getEmplType() {
        return emplType;
    }

    public void setEmplType(EmployeeType emplType) {
        this.emplType = emplType;
    }

    @Enumerated(EnumType.STRING)
    private EmployeeType emplType;

}


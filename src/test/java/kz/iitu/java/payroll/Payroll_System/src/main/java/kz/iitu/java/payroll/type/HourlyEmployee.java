package kz.iitu.java.payroll.type;

public class HourlyEmployee extends Employee{
    private int workHour;
    private double salaryHour;

    public HourlyEmployee() {
    }

    public HourlyEmployee(int id, String name, double salary, int workHour, double salaryHour) {
        super(id, name, salary);
        this.workHour = workHour;
        this.salaryHour = salaryHour;
    }

    public int getWorkHour() {
        return workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public double getSalaryHour() {
        return salaryHour;
    }

    public void setSalaryHour(double salaryHour) {
        this.salaryHour = salaryHour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                ", workHour=" + workHour +
                ", salaryHour=" + salaryHour +
                '}';
    }
}

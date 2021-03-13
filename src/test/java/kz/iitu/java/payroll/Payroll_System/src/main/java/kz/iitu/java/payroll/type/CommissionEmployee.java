package kz.iitu.java.payroll.type;

public class CommissionEmployee extends Employee{
    private Double percentageSales;

    public CommissionEmployee() {
    }

    public CommissionEmployee(int id, String name, double salary, Double percentageSales) {
        super(id, name, salary);
        this.percentageSales = percentageSales;
    }

    public Double getPercentageSales() {
        return percentageSales;
    }

    public void setPercentageSales(Double percentageSales) {
        this.percentageSales = percentageSales;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                ", percentageSales=" + percentageSales +
                '}';
    }
}

package kz.iitu.java.payroll.type;

public class SalariedCommissionEmployee extends Employee{
    private Double percentageSales;
    private Double amountOfCommission;

    public SalariedCommissionEmployee() {
    }

    public SalariedCommissionEmployee(int id, String name, double salary, double percentageSales, double amountOfCommission) {
        super(id, name, salary);
        this.percentageSales = percentageSales;
        this.amountOfCommission = amountOfCommission;
    }

    public double getPercentageSales() {
        return percentageSales;
    }

    public void setPercentageSales(double percentageSales) {
        this.percentageSales = percentageSales;
    }

    public double getAmountOfCommission() {
        return amountOfCommission;
    }

    public void setAmountOfCommission(double amountOfCommission) {
        this.amountOfCommission = amountOfCommission;
    }

    @Override
    public String toString() {
        return "SalariedCommissionEmployee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                ", percentageSales=" + percentageSales +
                ", amountOfCommission=" + amountOfCommission +
                '}';
    }
}

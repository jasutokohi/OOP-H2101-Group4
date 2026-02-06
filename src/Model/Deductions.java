package Model;

public class Deductions {
    private double sss;
    private double philhealth;
    private double pagibig;
    private double withholdingTax;

    public Deductions(double sssTax, double philhealthTax, double pagibigTax, double withholdingTax) {
        this.sss = sssTax;
        this.philhealth = philhealthTax;
        this.pagibig = pagibigTax;
        this.withholdingTax = withholdingTax;
    }

    public double getSSS() {
        return sss;
    }

    public double getPhilhealth() {
        return philhealth;
    }

    public double getPagibig() {
        return pagibig;
    }

    public double getWithholdingTax() {
        return withholdingTax;
    }
   
    
    public double getTotalDeductions(){
        return sss + philhealth + pagibig + withholdingTax;
    }
}

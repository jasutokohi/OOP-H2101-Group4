package Class;
import java.text.DecimalFormat;

class WithholdingTaxCalculator {
    
    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    public double calculateWithholdingTax(double basicSalary, double totalDeductions) {
        double taxableIncome = basicSalary - totalDeductions;
        double withholdingTax = 0;

        if (basicSalary >= 20833 && basicSalary < 33333) {
            withholdingTax = (taxableIncome - 20833) * 0.20;
        } else if (basicSalary >= 33333 && basicSalary < 66667) {
            withholdingTax = ((taxableIncome - 33333) * 0.25) + 2500;
        } else if (basicSalary >= 66667 && basicSalary < 166667) {
            withholdingTax = ((taxableIncome - 66667) * 0.30) + 10833;
        } else if (basicSalary >= 166667 && basicSalary < 666667) {
            withholdingTax = ((taxableIncome - 166667) * 0.32) + 40833.33;
        } else if (basicSalary >= 666667) {
            withholdingTax = ((taxableIncome - 666667) * 0.35) + 200833.33;
        } else {
            withholdingTax = 0;
        }

        return withholdingTax;
    }

    public String formatWithholdingTax(double tax) {
        return "Withholding Tax: P" + decfor.format(tax);
    }
}

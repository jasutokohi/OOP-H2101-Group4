package Model;
import java.text.DecimalFormat;

class WithholdingTaxCalculator {
    
    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    public double calculateWithholdingTax(double taxableIncome) {
        double withholdingTax;
        
        if (taxableIncome >= 20833 && taxableIncome < 33333) {
            withholdingTax = (taxableIncome - 20833) * 0.20;
        } else if (taxableIncome >= 33333 && taxableIncome < 66667) {
            withholdingTax = ((taxableIncome - 33333) * 0.25) + 2500;
        } else if (taxableIncome >= 66667 && taxableIncome < 166667) {
            withholdingTax = ((taxableIncome - 66667) * 0.30) + 10833;
        } else if (taxableIncome >= 166667 && taxableIncome < 666667) {
            withholdingTax = ((taxableIncome - 166667) * 0.32) + 40833.33;
        } else if (taxableIncome >= 666667) {
            withholdingTax = ((taxableIncome - 666667) * 0.35) + 200833.33;
        } else {
            withholdingTax = 0;
        }

        return withholdingTax;
    
    }
}

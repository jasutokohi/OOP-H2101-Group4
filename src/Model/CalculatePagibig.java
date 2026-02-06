package Model;

public class CalculatePagibig {
    public double calculatePagibig(double grossIncome){
        double pagibigTax;
        
        if(grossIncome >= 1000 && grossIncome <= 1500){
            return grossIncome * 0.03;
        }
        else if(grossIncome > 1500){
            return grossIncome * 0.04;
        }
        return 0;
    }
}

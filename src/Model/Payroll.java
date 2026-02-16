package Model;

public class Payroll {
    
    private final CalculateBenefits calculateBenefits = new CalculateBenefits();
    private final CalculateSSS calculateSSS = new CalculateSSS();
    private final CalculateWithholdingTax calculateWithholdingTax = new CalculateWithholdingTax();
    private final CalculatePagibig calculatePagibig = new CalculatePagibig();
    private final CalculatePhilhealth calculatePhilhealth = new CalculatePhilhealth();
    
    //calculateMethods
    public double getGrossSalary(int basicSalary, int overtimeHours, double hourlyRate){
        double overtimePay = overtimeHours * hourlyRate * 1.25; 
        double grossSalary = overtimePay + basicSalary;
        return grossSalary;
    }
    
    public double getGrossSalary(int basicSalary){//GrossSalary for probationary who doesn't ahve overtime
        return basicSalary;
    }
    
    public Benefits getBenefits(String position){
        return calculateBenefits.calculateBenefits(position);
    }
    
    public Deductions getDeductions(double grossIncome){
        double sss = calculateSSS.calculateSSS(grossIncome);
        double pagibig = calculatePagibig.calculatePagibig(grossIncome);
        double philhealthTax = calculatePhilhealth.calculatePhilHealth(grossIncome);
        double mandatoryDeductions = sss + pagibig + philhealthTax;
        
        double taxableIncome = grossIncome - mandatoryDeductions;
        double withholdingTax = calculateWithholdingTax.calculateWithholdingTax(taxableIncome); 
        
        return new Deductions(sss, philhealthTax, pagibig, withholdingTax);
    }
    
    
    public double getNetSalary(int basicSalary, int overtimeHours, double hourlyRate, String position){
        double grossSalary = getGrossSalary(basicSalary, overtimeHours, hourlyRate);
        
        Benefits benefitsObj = getBenefits(position);
        double benefits = benefitsObj.getTotalBenefits();
        
        Deductions deductionsObj = getDeductions(grossSalary);
        double totalDeductions = deductionsObj.getTotalDeductions();
        return grossSalary + benefits - totalDeductions;
    }
    
    public double getNetSalary(int basicSalary, String position){//Probationary Net Salary
        double grossSalary = getGrossSalary(basicSalary);
        
        Benefits benefitsObj = getBenefits(position);
        double benefits = benefitsObj.getTotalBenefits();
        
        Deductions deductionsObj = getDeductions(grossSalary);
        double totalDeductions = deductionsObj.getTotalDeductions();
        return grossSalary + benefits - totalDeductions;
    }
}

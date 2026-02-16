package Model;

import java.text.DecimalFormat;

public class PayrollCalculation{
    private static final DecimalFormat decFor = new DecimalFormat("0.00");
    private final int basicSalary;
    private final int daysWorked;
    private final int overtimeHours;
    private final double riceSubsidy = 1500.00, phoneAllowance = 2000.00, clothingAllowance = 1000.00, benefits = 4500.00;
    private final double sssRate = 0.045, philHealthRate = 0.03, pagibigRate = 0.02;
    private double dailyRate, overTimePay ,overtime,grossIncome,sss, philhealth, pagIbig, 
                   totalDeduction,finalTotalDeductions,netIncome, withholdingTax;
    private final WithholdingTaxCalculator withholdingTaxCalculator = new WithholdingTaxCalculator();

    //Constructor
    public PayrollCalculation(int BasicSalary, int DaysWorked, int OvertimeHours) {
        this.basicSalary = BasicSalary;
        this.daysWorked = DaysWorked;
        this.overtimeHours = OvertimeHours;
        
        this.calculateAll();
    }
    
    //Calculations
    
    //Calculates Earnings part
    private void calculateAll(){ 
        dailyRate = basicSalary / 20;
        overTimePay = dailyRate * .10;
        overtime = overtimeHours * overTimePay;
        grossIncome = dailyRate * daysWorked + overtime;
        sss = basicSalary * sssRate; //Calculation for SSS Deduction
        philhealth = basicSalary * philHealthRate; //Calculation for SSS Deduction
        pagIbig = basicSalary * pagibigRate; // PagIbig = BasicSalary * 2%
        totalDeduction = sss + philhealth + pagIbig;
        withholdingTax = withholdingTaxCalculator.calculateWithholdingTax(basicSalary,totalDeduction);
        finalTotalDeductions = totalDeduction + withholdingTax;
        netIncome = grossIncome + benefits - finalTotalDeductions;
    }
    
    //returns/prints Overall Earnings part
    public String showEarnings(){ 
        return """
               Monthly Rate: """ + decFor.format(basicSalary) + "\n"
               + "Daily Rate: " + decFor.format(dailyRate) + "\n"
               + "Overtime: " + decFor.format(overtime) + "\n"
               + "Gross Income: " + decFor.format(grossIncome) + "\n";
    }
    
    //returns/prints Overall Benefits part
    public String showBenefits(){
        return 
               "Rice Subsidy: P" + riceSubsidy +   
               "\nPhone Allowance: P" + phoneAllowance +
               "\nClothing Allowance: P" + clothingAllowance +
               "\nBenefits: P" + benefits + "\n";
    }
    
    //returns/prints Overall Deductions part
    public String showDeductions(){
        return """
           Social Security Systems Deductions: P""" + decFor.format(sss) + "\n" +
           "Philhealth Deduction: P" + decFor.format(philhealth) + "\n" +
           "Pag-Ibig Deduction: P" + decFor.format(pagIbig) + "\n" +
           "Withholding Tax: P" + decFor.format(withholdingTax) + "\n" +
           "Total Deductions: P" + decFor.format(finalTotalDeductions) + "\n";
    }
    
    //returns/prints Overall Summary part
    public String summary(){
        return """
               Gross Income: P""" + decFor.format(grossIncome) + "\n" +
               "Benefits: P" + decFor.format(benefits) + "\n" +
               "Deductions: P" + decFor.format(finalTotalDeductions) + "\n" +
               "Net Income: P" + decFor.format(netIncome);
    }
}


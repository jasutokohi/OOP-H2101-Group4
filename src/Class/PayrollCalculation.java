package Class;

import java.text.DecimalFormat;

public class PayrollCalculation{
    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    private final int BasicSalary;
    private final int DaysWorked;
    private final int OvertimeHours;
    private final double RiceSubsidy = 1500.00, PhoneAllowance = 2000.00, ClothingAllowance = 1000.00, Benefits = 4500.00;
    private final double SSSrate = 0.045, Philhealthrate = 0.03, Pagibigrate = 0.02;
    private double DailyRate, OverTimePay ,Overtime,GrossIncome,SSS, Philhealth, PagIbig, 
                   TotalDeduction,FinalTotalDeductions,NetIncome, WithholdingTax;
    private final WithholdingTaxCalculator taxCalculator = new WithholdingTaxCalculator();

    //Constructor
    public PayrollCalculation(int BasicSalary, int DaysWorked, int OvertimeHours) {
        this.BasicSalary = BasicSalary;
        this.DaysWorked = DaysWorked;
        this.OvertimeHours = OvertimeHours;
        
        this.calculateAll();
    }
    
    //Calculations
    
    //Calculates Earnings part
    private void calculateAll(){ 
        DailyRate = BasicSalary / 20;
        OverTimePay = DailyRate * .10;
        Overtime = OvertimeHours * OverTimePay;
        GrossIncome = DailyRate * DaysWorked + Overtime;
        SSS = BasicSalary * SSSrate; //Calculation for SSS Deduction
        Philhealth = BasicSalary * Philhealthrate; //Calculation for SSS Deduction
        PagIbig = BasicSalary * Pagibigrate; // PagIbig = BasicSalary * 2%
        TotalDeduction = SSS + Philhealth + PagIbig;
        WithholdingTax = taxCalculator.calculateWithholdingTax(BasicSalary,TotalDeduction);
        FinalTotalDeductions = TotalDeduction + WithholdingTax;
        NetIncome = GrossIncome + Benefits - FinalTotalDeductions;
    }
    
    //returns/prints Overall Earnings part
    public String showEarnings(){ 
        return """
               Monthly Rate: """ + decfor.format(BasicSalary) + "\n"
               + "Daily Rate: " + decfor.format(DailyRate) + "\n"
               + "Overtime: " + decfor.format(Overtime) + "\n"
               + "Gross Income: " + decfor.format(GrossIncome) + "\n";
    }
    
    //returns/prints Overall Benefits part
    public String ShowBenefits(){
        return 
               "Rice Subsidy: P" + RiceSubsidy +   
               "\nPhone Allowance: P" + PhoneAllowance +
               "\nClothing Allowance: P" + ClothingAllowance +
               "\nBenefits: P" + Benefits + "\n";
    }
    
    //returns/prints Overall Deductions part
    public String showDeductions(){
        return """
           Social Security Systems Deductions: P""" + decfor.format(SSS) + "\n" +
           "Philhealth Deduction: P" + decfor.format(Philhealth) + "\n" +
           "Pag-Ibig Deduction: P" + decfor.format(PagIbig) + "\n" +
           "Withholding Tax: P" + decfor.format(WithholdingTax) + "\n" +
           "Total Deductions: P" + decfor.format(FinalTotalDeductions) + "\n";
    }
    
    //returns/prints Overall Summary part
    public String Summary(){
        return """
               Gross Income: P""" + decfor.format(GrossIncome) + "\n" +
               "Benefits: P" + decfor.format(Benefits) + "\n" +
               "Deductions: P" + decfor.format(FinalTotalDeductions) + "\n" +
               "Net Income: P" + decfor.format(NetIncome);
    }
}


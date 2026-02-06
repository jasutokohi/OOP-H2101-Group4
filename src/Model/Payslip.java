package Model;

public class Payslip {
    private final Employee employee;        
    private final Benefits benefits;     
    private final Deductions deductions;    
    private final Payroll payroll;
    private final int hoursWorked;
    private final int overtimeHours;
    private final double grossSalary;
    private final double netSalary;

    public Payslip(Employee employee, Payroll payroll, int overtimeHours, int hoursWorked) {
        this.employee = employee;
        this.payroll = payroll; 
        this.hoursWorked = hoursWorked;
        
        this.overtimeHours = (employee instanceof RegularEmployee) ? overtimeHours : 0;

        this.benefits = payroll.getBenefits(employee.getPosition());
        this.grossSalary = (employee instanceof RegularEmployee) ?
                payroll.getGrossSalary(employee.getBasicSalary(), this.overtimeHours, ((RegularEmployee) employee).getHourlyRate()) :
                payroll.getGrossSalary(employee.getBasicSalary());

        this.deductions = payroll.getDeductions(this.grossSalary);

        this.netSalary = payroll.getNetSalary(
                employee.getBasicSalary(),
                this.overtimeHours,
                (employee instanceof RegularEmployee) ? ((RegularEmployee) employee).getHourlyRate() : 0,
                employee.getPosition()
        );
    }
    
    public void printEarnings(){
        
        System.out.println("Basic Salary: " + employee.getBasicSalary());
        System.out.println("Hours Worked: " + hoursWorked);
        if (employee instanceof RegularEmployee) {
            System.out.println("Overtime Hours: " + overtimeHours);
        }
        System.out.println("Gross Income: " + grossSalary);
        
    }
    
    public void printBenefits(){
        System.out.println("Rice Subsidy: " + benefits.getRiceSubsidy());
        System.out.println("Phone Allowance : " + benefits.getPhoneAllowance());
        System.out.println("Clothing Allowance : " + benefits.getClothingAllowance());
        System.out.println("Total Benefits: " + benefits.getTotalBenefits());
    }
    
    public void printDeductions(){
        System.out.println("SSS Tax: " + deductions.getSSS());
        System.out.println("Philhealth Tax: " + deductions.getPhilhealth());
        System.out.println("Pagibig Tax: " + deductions.getPagibig());
        System.out.println("Withholding Tax: " + deductions.getWithholdingTax());
        System.out.println("Total Deductions: " + deductions.getTotalDeductions());
    }
    
    public void printSummary(){
        System.out.println("Gross Income: " + grossSalary);
        System.out.println("Total Benefits: " + benefits.getTotalBenefits());
        System.out.println("Total Deductions: " + deductions.getTotalDeductions());
        System.out.println("Net Salary: " + netSalary);
    }
}

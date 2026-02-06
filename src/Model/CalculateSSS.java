
package Model;

public class CalculateSSS {
    public double calculateSSS(double grossIncome){
    if (grossIncome < 3250) {
        return 135.00;
    }

    if (grossIncome >= 24750) {
        return 1125.00;
    }

    double steps = (grossIncome - 3250) / 500;
    return 157.50 + (steps * 22.50);
    }
}

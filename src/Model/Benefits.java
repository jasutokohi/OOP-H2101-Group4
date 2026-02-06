package Model;

public class Benefits {
    private final int riceSubsidy;
    private final int phoneAllowance;
    private final int clothingAllowance;

    public Benefits(int riceSubsidy, int phoneAllowance, int clothingAllowance) {
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
    }

    //getters
    public int getRiceSubsidy() {
        return riceSubsidy;
    }

    public int getPhoneAllowance() {
        return phoneAllowance;
    }

    public int getClothingAllowance() {
        return clothingAllowance;
    }
    
    public int getTotalBenefits(){
        return riceSubsidy + phoneAllowance + clothingAllowance;
    }
    
    
}

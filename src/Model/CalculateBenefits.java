package Model;

public class CalculateBenefits {
    public Benefits calculateBenefits(String position){
        String pos = position.toLowerCase()
                             .replaceAll("[–—]", "-")   // normalize long dashes
                             .replace('\u00A0', ' ')    // non-breaking space
                             .replaceAll("\\s+", " ")   // collapse multiple spaces
                             .trim();
         
        int riceSubsidy = 1500;
        int phoneAllowance, clothingAllowance;
        
        if(pos.equals("ceo") || pos.equals("cfo") || pos.equals("cpo") || pos.equals("cmo")){
            phoneAllowance = 2000;
            clothingAllowance = 1000;

        }else if(pos.contains("team leader")){
            phoneAllowance = 800;
            clothingAllowance = 800;

        }else if(pos.contains("rank-and-file") || pos.contains("rank and file")){
            phoneAllowance = 500;
            clothingAllowance = 500;

        }else{
            phoneAllowance = 1000;
            clothingAllowance = 1000;
        }
        return new Benefits(riceSubsidy, phoneAllowance, clothingAllowance);
    }
}

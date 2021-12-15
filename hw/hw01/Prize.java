/**
 * written by Evan Scales
 */
public class Prize {
    private String name;
    private double prizePrice;

    public Prize(){
        
    }
    public Prize(String aName, double aPrice){
        this.name = aName;
        this.prizePrice = aPrice;
    }

    public String getName(){
        return this.name;
    }
    public double getPrizePrice(){
        return this.prizePrice;
    }

    public void setName(String aN){
        if(aN != null)
            this.name = aN;
        else
            this.name = "none";
    }
    public void setPrizePrice(double aP){
        if(aP > 0)
            this.prizePrice = aP;
        else
            this.prizePrice = 5;
    }

    
}
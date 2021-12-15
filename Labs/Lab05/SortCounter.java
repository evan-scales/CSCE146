/**
 * written by Evan Scales
 */
public class SortCounter {
    private int numOfSorts;
    private String str;

    public SortCounter(String aStr){
        this.str = aStr;
        this.numOfSorts = 0;
        this.countSorts(aStr);
    }
    public int getNumOfSorts(){
        return this.numOfSorts;
    }
    public String getStr(){
        return this.str;
    }
    public void countSorts(String aStr){
        if(aStr == null)
            return;
        aStr = aStr.toUpperCase();
        for(int i=0;i<aStr.length()-3;i++){
            if(aStr.charAt(i) == 'S' && 
                    aStr.charAt(i+1) == 'O' &&
                    aStr.charAt(i+2) == 'R' &&
                    aStr.charAt(i+3) == 'T'){
                        this.numOfSorts++;
                    }
        }
    }
    
}
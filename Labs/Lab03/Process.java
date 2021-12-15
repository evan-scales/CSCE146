/**
 * written by Evan Scales
 */
public class Process {
    private String name;
    private double completionTime;

    public Process(){
        this.name = "none";
        this.completionTime = 0;
    }

    public Process(String aName, double aCompletionTime){
        this.setName(aName);
        this.setCompletionTime(aCompletionTime);
    }

    public String getName(){
        return this.name;
    }
    public double getCompletionTime(){
        return this.completionTime;
    }

    public void setName(String aName){
        if(aName == null)
            this.name = "none";
        else
            this.name = aName;
    }
    public void setCompletionTime(double aTime){
        if(aTime >= 0)
            this.completionTime = aTime;
        else
            this.completionTime= 0;
    }

    public String toString(){
        return "Process Name: "+this.name+" Completion Time: "+this.completionTime;
    }
    
}
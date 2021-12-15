/**
 * written by Evan Scales
 */
public class VideoGame {

    String name;
    String console;

    public VideoGame(){

    }
    public VideoGame(String aName, String aConsole){
        this.name = aName;
        this.console = aConsole;
    }

    public String getName(){
        return this.name;
    }
    public String getConsole(){
        return this.console;
    }

    public void setName(String aN){
        if(aN != null)
            this.name = aN;
        else
            this.name = "none";
    }
    public void setConsole(String aC){
        if(aC != null)
            this.console = aC;
        else
            this.console = "none";
    }
}
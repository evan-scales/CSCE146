
/**
 * written by Evan Scales
 */

public class VideoGameManager {
    private static final String DELIM = "\t";
    private static final int FIELD_AMT = 2;
    private GenLL<VideoGame> vGames;
    private GenLL<VideoGame> current;

    public VideoGameManager(){
        vGames = new GenLL<VideoGame>();
        current = new GenLL<VideoGame>();
    }

    //read the file
    public void readFile(String fileName){
        try{
            //clears list to read new file
            vGames = new GenLL<VideoGame>();
            Scanner fileScanner = new Scanner(new FileInputStream(fileName));
            //Read
            while(fileScanner.hasNextLine()){
                String fileLine = fileScanner.nextLine();
                String [] splitLines = fileLine.split(DELIM);
                if(splitLines.length == FIELD_AMT){
                    String name = splitLines[0];
                    String console = splitLines[1];
                    VideoGame newVG = new VideoGame(name,console);
                    vGames.add(newVG);
                }
            }
            fileScanner.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //write to file
    public void writeToFile(String fileName, boolean append){
        try{
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName, append));
            current.reset();
            int size = current.getSize();

            for(int i=0;i<size;i++){
                VideoGame games = current.getCurrent();
                fileWriter.println(games.getName()+DELIM+games.getConsole());
                current.goToNext();
            }
            fileWriter.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //print to console
    public void printResults(){
        current.reset(); //go to the start of the list
        int size = current.getSize(); //find the size of the list
        for(int i=0;i<size;i++){
            VideoGame games = current.getCurrent(); //get the current item in the list
            System.out.println(games.getName()+DELIM+games.getConsole());
            current.goToNext(); //go to the next item in the list
        }
    }

    //search video games
    public GenLL<VideoGame> search(String aGame, String aConsole){
        current = new GenLL<VideoGame>(); //clears current list to make fresh list
        int counter = 0;
        vGames.reset(); //go to the start of the list
        int size = vGames.getSize(); //find the size of the list
        //go throguh all video games
        for(int i=0;i<size;i++){
            VideoGame games = vGames.getCurrent(); //get the current item in the list

            //switch all the names to lower case
            String name = games.getName().toLowerCase();
            String console = games.getConsole().toLowerCase();

            if(name.contains(aGame.toLowerCase()) && console.contains(aConsole.toLowerCase())){
                current.add(games);
                counter++;
            }
            else if(name.contains(aGame.toLowerCase()) && aConsole.equals("*")){
                current.add(games);
                counter++;
            }
            else if(aGame.equals("*") && console.contains(aConsole.toLowerCase())){
                current.add(games);
                counter++;
            }
            else if(aGame.equals("*") && aConsole.equals("*")){
                current.add(games);
                counter++;
            }
            vGames.goToNext();
        }
        //if the counter was 0 then the list would not have been populated
        if(counter != 0)
            return current;
        else
            return null;
    }
    
}
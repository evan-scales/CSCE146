/**
 * written by Evan SCales
 */
import java.util.Scanner;
public class VideoGameFrontEnd {
    private static VideoGameManager videoGame = new VideoGameManager();
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        boolean quit = false;

        while(!quit){
            printChoices();
            int choice = keyboard.nextInt();
            keyboard.nextLine();
            switch(choice){
                case 1:
                    loadData();
                    break;
                case 2:
                    searchData();
                    break;
                case 3:
                    printData();
                    break;
                case 4:
                    printDataToFile();
                    break;
                case 9:
                    quit = true;
                    break;
                    default:
                        System.out.println("Invalid Input");
            }
        }
        System.out.println("Goodbye");
    }

    public static void printChoices(){
        System.out.println("Enter 1 to load the video game database\n"
            + "Enter 2 to search the database\n"
            + "Enter 3 to print current results\n"
            + "Enter 4 to print current results to file\n"
            + "Enter 9 to quit");
    }
    public static void loadData(){
        System.out.println("Enter the file name");
        String fileName = keyboard.nextLine();
        videoGame.readFile(fileName);
    }
    public static void searchData(){
        GenLL<VideoGame> current;
        System.out.println("Enter the name of the game or '*' for all names");
        String game = keyboard.nextLine();
        System.out.println("Enter the name of the console or '*' for all consoles");
        String console = keyboard.nextLine();

        current = videoGame.search(game, console);
        //only print the results if there are matches
        if(current != null)
            videoGame.printResults();
        else
            System.out.println("No "+game+" games found for "+console+" console");
    }
    public static void printData(){
        videoGame.printResults();
    }
    public static void printDataToFile(){
        System.out.println("Enter the file name to print out.");
        String fileName = keyboard.nextLine();
        System.out.println("Append to file? True or false.");
        String append = keyboard.nextLine();
        if(append.equalsIgnoreCase("true"))
            videoGame.writeToFile(fileName, true);
        else if(append.equalsIgnoreCase("false"))
            videoGame.writeToFile(fileName, false);
        else
            System.out.println("Invalid Input");
    }
}
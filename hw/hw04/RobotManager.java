/**
 * written by Evan Scales
 */
import java.io.*;
import java.util.Scanner;
public class RobotManager {
    public static final int MAZE_SIZE = 10;
    public static final char PLAYER = 'O';
    public static final char OBST = 'X';
    public static final char EMPTY = '_';
    private char [][] maze; //index 0 = y, index 1 = x
    private LLQueue<String> move;

    public RobotManager(){
        this.init();
    }
    private void init(){
        maze = new char[MAZE_SIZE][MAZE_SIZE];
        move = new LLQueue<String>();
    }

    //read the board file
    public void readFile(String fileName){
        try{
            Scanner fileScanner = new Scanner(new FileInputStream(fileName));
            for(int i=0;i<MAZE_SIZE;i++){
                maze[0][0] = PLAYER;
                maze[i] = fileScanner.nextLine().toCharArray();
            }
            fileScanner.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //read the commands file
    public void readCommands(String commandsFile){
        int count = 0;
        int currentX = 0;
        int currentY = 0;
        try{
            Scanner fileScanner = new Scanner(new FileInputStream(commandsFile));
            while(fileScanner.hasNextLine()){
                move.enqueue(fileScanner.nextLine());
                //check which move it is
                if(move.peek().equals("Move Up")){
                    System.out.println("Command " + count);
                    if(isValid(currentY-1) && maze[currentY-1][currentX] != OBST){
                            maze[currentY][currentX] = EMPTY;
                            maze[currentY-1][currentX] = PLAYER;
                            currentY -= 1;
                            count++;
                            move.dequeue();
                            printMaze();
                    }
                    else{
                        System.out.println("CRASH!");
                        break;
                    }
                }
                else if(move.peek().equals("Move Down")){
                    System.out.println("Command " + count);
                    if(isValid(currentY+1) && maze[currentY+1][currentX] != OBST){
                        maze[currentY][currentX] = EMPTY;
                        maze[currentY+1][currentX] = PLAYER;
                        currentY += 1;
                        count++;
                        move.dequeue();
                        printMaze();
                    }
                    else{
                        System.out.println("CRASH!");
                        break;
                    }
                }
                else if(move.peek().equals("Move Left")){
                    System.out.println("Command " + count);
                    if(isValid(currentX-1) && maze[currentY][currentX-1] != OBST){
                        maze[currentY][currentX] = EMPTY;
                        maze[currentY][currentX-1] = PLAYER;
                        currentX -= 1;
                        count++;
                        move.dequeue();
                        printMaze();
                    }
                    else{
                        System.out.println("CRASH!");
                        break;
                    }
                }
                else if(move.peek().equals("Move Right")){
                    System.out.println("Command " + count);
                    if(isValid(currentX+1) && maze[currentY][currentX+1] != OBST){
                        maze[currentY][currentX] = EMPTY;
                        maze[currentY][currentX+1] = PLAYER;
                        currentX += 1;
                        count++;
                        move.dequeue();
                        printMaze();
                    }
                    else{
                        System.out.println("CRASH!");
                        break;
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //check if the move is valid
    private boolean isValid(int index){
        return index >= 0 && index < maze.length;
    }
    //print the maze
    public void printMaze(){
        for(int i=0;i<MAZE_SIZE;i++)
            System.out.println(maze[i]);
    }
}
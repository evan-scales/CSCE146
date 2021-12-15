/**
 * written by Evan Scales
 */
import java.util.Scanner;
public class RobotFrontEnd {
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        boolean gameOver = false;
        System.out.println("Welcome to the Robot Simulator");
        while(!gameOver){
            RobotManager robot = new RobotManager(); //redeclare robot so that maze clears
            System.out.println("Enter file for the Board");
            String input1 = keyboard.nextLine();
            System.out.println("Enter file for the Robot Commands");
            String input2 = keyboard.nextLine();
            robot.readFile(input1);
            robot.printMaze();

            System.out.println("Simulation begin");
            robot.readCommands(input2);
            System.out.println("Simulation end");
            System.out.println("Quit? Enter \"true\" to quit or hit enter to run another simulation");
            gameOver = keyboard.nextLine().equalsIgnoreCase("true");
        }
    }
}
/*
 * Written by JJ Shepherd
 */
import java.util.*;
public class ProcessSchedulerSimulator {

	public static final int MAX_SIM_TIME = 50;//Max cycle times
	public static final double MAX_PROC_TIME = 15.0;
	public static final int RAND_ADD_VAL = 3;//A value that adds a new process only when it's a multiple.
	public static final int RAND_CANCEL_VAL = 23;//A value that ends the current process only it's a multiple.
	public static Random rng = new Random(10);//Random number generator. Add a number into its parameter to fix its seed value
	public static void main(String[] args) {
		//Creating process scheduler
		ProcessScheduler scheduler = new ProcessScheduler();
		int currProcCount = 0;
		Process currProcess;
		printHeader("Welcome to the\nprocess scheduler\nsimulator");
		System.out.println("\n");
		for(int i=0;i<MAX_SIM_TIME;i++)
		{
			printHeader("Time Step "+i);
			//Possibly add a new process
			if(rng.nextInt()%RAND_ADD_VAL == 0)
			{
				addRandomProcess(scheduler,++currProcCount);
			}
			//Possibly remove a process
			if(rng.nextInt()%RAND_CANCEL_VAL == 0)
			{
				printAction("Cancelling current Process");
				scheduler.cancelCurrentProcess();
			}
			//Get status of the current process
			currProcess = scheduler.getCurrentProcess();
			if(currProcess == null)
			{
				printAction("No processes currently running");
			}
			else if(currProcess.getCompletionTime() > 0.0)
			{
				printAction("Current Process "+currProcess.toString());
				currProcess.setCompletionTime(currProcess.getCompletionTime()-1.0);
				printAction("Updating Completion Time "+currProcess.toString());
			}
			else
			{
				printAction("Current Process Complete");
				scheduler.runNextProcess();
				currProcess = scheduler.getCurrentProcess();
				if(currProcess!=null)
				{
					printAction("New current process "+currProcess.toString());
				}
				else
				{
					printAction("No current process");
				}
			}
			//Check status of the process queue
			printAction("Current Process Queue");
			scheduler.printProcessQueue();

		}
	}
	public static void addRandomProcess(ProcessScheduler scheduler, int count)
	{
		String name = "Process"+(count);
		double randTime = rng.nextDouble()*MAX_PROC_TIME;
		Process p = new Process(name,randTime);
		printAction("Adding a new Process " + p.toString());
		scheduler.addProcess(p);
	}
	public static void printHeader(String data)
	{
		System.out.println("---------------------------\n"+data+"\n---------------------------");
	}
	public static void printAction(String data)
	{
		System.out.println("***"+data+"***");
	}
	

}
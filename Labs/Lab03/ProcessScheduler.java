 /**
 * written by Evan Scales
 */
public class ProcessScheduler {
    private LLQueue<Process> processes;
    private Process currentProcess;

    public ProcessScheduler(){
        processes = new LLQueue<Process>();
        this.currentProcess = null;
    }

    public Process getCurrentProcess(){
        return this.currentProcess;
    }
    public void addProcess(Process aP){
        if(this.currentProcess == null)
            this.currentProcess = aP;
        else
            this.processes.enqueue(aP);
    }
    public void runNextProcess(){
        this.currentProcess = processes.dequeue();
    }
    public void cancelCurrentProcess(){
        this.runNextProcess();
    }
    public void printProcessQueue(){
        this.processes.print();
    }

    
}
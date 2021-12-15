/**
 * written by Evan Scales
 */
import java.util.Scanner;
import java.util.Random;
import java.io.*;
public class Showcase {
    private Prize[] prizes;
    public static final String DELIM = "\t";
    public static final int BODY_FIELD_AMT = 2;
    public static final int HEADER_FIELD_AMT = 2;
    public static final int DEF_SIZE = 50;
    
    public Showcase(){
        init(DEF_SIZE);
        readPrizes();
    }
    public Showcase(int size){
        init(size);
    }
    public void init(int size){
        if(size >= 1)
            prizes = new Prize[size];
        else
            prizes = new Prize[DEF_SIZE];
    }

    public Prize[] getFivePrizes(){
        Random r = new Random();
        Prize[] fivePrizes = new Prize[5];
        int j;
        for(int i=0;i<5;i++){
            Prize randomPrize;
            j = r.nextInt(50);
            randomPrize = prizes[j];

            //make sure the random prize is valid
            if(prizes[j] != null)
                fivePrizes[i] = randomPrize;
            else    
                i--;
        }
        return fivePrizes;
    }

    public void readPrizes(){
        try{
            Scanner filScanner = new Scanner(new File("prizeList.txt"));
            //read the header
            String fileLine = filScanner.nextLine();
            String[] splitLines = fileLine.split(DELIM);
            if(splitLines.length == HEADER_FIELD_AMT){
                int size = Integer.parseInt(splitLines[1]);
                init(size);
            }
            else
                return;
            //Read the body
            while(filScanner.hasNext()){
                fileLine = filScanner.nextLine();
                splitLines = fileLine.split(DELIM);
                if(splitLines.length == BODY_FIELD_AMT){
                    String name = splitLines[0];
                    double price = Double.parseDouble(splitLines[1]);
                    Prize aPrize = new Prize(name,price);
                    this.addPrizes(aPrize);
                }
            }
            filScanner.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addPrizes(Prize aPrize){
        if(prizes[prizes.length-1] != null)
            return;
        for(int i=0;i<prizes.length;i++){
            if(prizes[i] == null){
                prizes[i] = aPrize;
                break;
            }
        }
    }

    
 }
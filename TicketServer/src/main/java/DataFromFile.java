import java.io.*;
import java.util.*;

public class DataFromFile implements IDataAccessLayer {
    
	final String FILE_QUEUE_COUNTER="queue_counter.txt";
	final String FILE_SERVED_COUNTER="served_counter.txt";
    
    public int getCurrentQueueNumber(){
        int queue=readNumberFromFile(FILE_QUEUE_COUNTER);   
        return queue;
    }
    public int getCurrentServedNumber(){
        int served=readNumberFromFile(FILE_SERVED_COUNTER);   
        return served;
    }
    public void updateServedNumber(int number){
        incrementNumberFile(FILE_SERVED_COUNTER, number);
    }
    public void updateQueueNumber(int number){
        incrementNumberFile(FILE_QUEUE_COUNTER, number);
    }    
	private int readNumberFromFile(String filename){
		int counterVal=0;
		try{
			File dataFile = new File(filename);
			if(!dataFile.exists()){
				dataFile.createNewFile();
			}else{
				Scanner scanner = new Scanner(dataFile);
				while(scanner.hasNextInt()){
					counterVal=scanner.nextInt();
					break;
				}
				scanner.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return counterVal;
	}
	
	
	private void incrementNumberFile(String filename,int currentNumber){
		try{
			FileWriter fileWriter = new FileWriter(new File(filename));
            fileWriter.write(""+currentNumber);
			fileWriter.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

    

}

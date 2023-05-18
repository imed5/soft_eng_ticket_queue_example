public class TicketServer implements ITicketServer{
	
	private int queue_counter;
	private int served_counter;
	private IDataAccessLayer dal;

	public TicketServer(){
		dal=DataAccessSingleton.getSingletonInstance();
	}
	public boolean isThereCustomer(){
		int queue_number=dal.getCurrentQueueNumber(); 
		int served=dal.getCurrentServedNumber(); 				
		if (served>=queue_number)return false;
		return true;
	}	
	public int callNextCustomer(String agent){
		int queue_number=dal.getCurrentQueueNumber();
		int served=dal.getCurrentServedNumber();
		if (served>=queue_number)return served;
		served=served+1;
		served_counter=served;
		dal.updateServedNumber(served_counter);		
		Thread displayThread=new Thread(
			new DisplayNotify("Customer"+served_counter));
		Thread speakerThread=new Thread(
			new SpeakerNotify("Customer"+served_counter));
		displayThread.start();
		speakerThread.start();
		return served_counter;
	}

	public boolean resetAllCounters(){
		//no need for checks here, blindly reset.
		dal.updateServedNumber(0);		
		dal.updateQueueNumber(0);		
		served_counter=0;
		queue_counter=0;
		return true;
	}
	
	public int issueTicketNumber(String kioskNumber){
		int number=dal.getCurrentQueueNumber(); 
		number=number+1;
		queue_counter=number;
		dal.updateQueueNumber(queue_counter);			
		return queue_counter;
	}

	public int getLastQueueNumber(){
		return	queue_counter;
	}	

	public int getLastServedNumber(){
		return	served_counter;
	}		
}
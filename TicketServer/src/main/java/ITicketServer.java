
interface ITicketServer{
	
	public int issueTicketNumber(String kioskNumber) ;

	public boolean isThereCustomer() ;
		
	public int callNextCustomer(String agent);
		
	public int getLastQueueNumber() ;
	
	public int getLastServedNumber() ;

	public boolean resetAllCounters() ;	

}



public class TicketServerSingleton{
	
	private static ITicketServer ticketServer;
	
	public static ITicketServer getTicketServer(){
		if (ticketServer==null){
			ticketServer=new TicketServer();
		}
		return ticketServer;
	}
	
}


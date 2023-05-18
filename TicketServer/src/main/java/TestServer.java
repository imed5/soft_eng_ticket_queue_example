
public class TestServer{

	public static void main(String [] args){			
		ITicketServer server=TicketServerSingleton.getTicketServer();
		server.resetAllCounters();
		int number=server.issueTicketNumber("K1");
		number=server.issueTicketNumber("K1");
		number=server.issueTicketNumber("K1");
		System.out.println("Issued Ticket number is : "+number);
		number=server.callNextCustomer("A1");
		System.out.println("Customer to serve : "+number);
		server.resetAllCounters();
		number=server.getLastQueueNumber();
		System.out.println("Customer to serve : "+number);
	}
}

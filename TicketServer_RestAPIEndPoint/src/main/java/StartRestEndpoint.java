import static spark.Spark.*;

public class StartRestEndpoint{
	public static void main(String [] args){
		ITicketServer server=TicketServerSingleton.getTicketServer();
		System.out.println("Rest API EndPoint is Running ");
		get("/issueTicket/:kiosk", 
			(req, res) -> ""+server.issueTicketNumber(req.params(":kiosk")));

		get("/callNextCustomer/:agent", 
			(req, res) -> ""+server.callNextCustomer(req.params(":agent")));
			
		get("/isThereCustomer", 
			(req, res) -> ""+server.isThereCustomer());
		
		get("/resetCounters", 
			(req, res) -> ""+server.resetAllCounters());

		}
}

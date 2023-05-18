

class StartAgentGui{
	
	public static void main(String [] args){
		String ticketServerAddress="http://localhost:4567";
		String agent="A1";
		if (args.length>0){
			ticketServerAddress=args[0];
		}
		if (args.length>1){
			agent=args[1];
		}
		System.out.println("Connecting to server running at : "+ticketServerAddress);
		IAgentGui guiInstance=AgentGuiFactory.createGuiInstance(ticketServerAddress,agent);
	}
}



class StartKioskGui{
	
	public static void main(String [] args){
		String ticketServerAddress="http://localhost:4567";
		String kioskName="Kiosk";
		if (args.length>0){
			ticketServerAddress=args[0];
		}
		if (args.length>1){
			kioskName=args[1];
		}		
		System.out.println("Connecting to server running at : "+ticketServerAddress);
		IKioskGui guiInstance=KioskGuiFactory.createGuiInstance(ticketServerAddress,kioskName);
	}
}

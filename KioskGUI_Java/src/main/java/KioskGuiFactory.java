
public class KioskGuiFactory{
		
	public static IKioskGui createGuiInstance(String address,String kiosk){
		IKioskGui gui=new KioskGui(address,kiosk);
		return gui;
	}
	
}

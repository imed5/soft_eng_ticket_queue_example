
public class AgentGuiFactory{
		
	public static IAgentGui createGuiInstance(String address,String agent){
		IAgentGui gui=new AgentGui(address,agent);
		return gui;
	}
	
}

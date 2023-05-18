import javax.swing.*;    
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class AgentGui implements IAgentGui {  

	private JLabel l_customerNumber;
	private String ticketServerAddress;
	private String agentNumber;
	public AgentGui(String address,String agent){
		ticketServerAddress=address;
		agentNumber=agent;
		buildGui();
	}
	
	public void callNextCustomer(){
		String queueNumber=readURLPage(ticketServerAddress+"/callNextCustomer/"+agentNumber);
		l_customerNumber.setText("Queue : "+queueNumber);
	}
	
	
	private void buildGui(){
		JFrame f=new JFrame("Ticket Queue Agent System");  
		
		l_customerNumber=new JLabel("Server Customer : ");  
		
		JButton b_nextCustomer=new JButton("Next Customer");  
		
		l_customerNumber.setBounds(50,100,150,40);  
		
		b_nextCustomer.setBounds(50,150,150,40);  
		
		f.add(b_nextCustomer);  
		f.add(l_customerNumber);  
		f.setSize(400,400);  
		f.setLayout(null);  
		f.setVisible(true); 
		
		b_nextCustomer.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				callNextCustomer();
			} 
		} );  		
	}
	
	public static String readURLPage(String url){
		String pageContent="";
		String inputLine="";
		try{
			URL oracle = new URL(url);
			BufferedReader in = new BufferedReader(
				new InputStreamReader(oracle.openStream()));

			while ((inputLine = in.readLine()) != null)
				pageContent=pageContent+inputLine;
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
		return pageContent;
	}
}

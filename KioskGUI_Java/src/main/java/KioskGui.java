import javax.swing.*;    
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class KioskGui implements IKioskGui {  

	private String ticketServerAddress;
	private String kioskName;
	private JLabel l_queuenumber;
	public KioskGui(String address,String kiosk){
		ticketServerAddress=address;
		kioskName=kiosk;
		buildGui();
	}
	
	public void issueTicket(){
		String queueNumber=readURLPage(ticketServerAddress+"/issueTicket/"+kioskName);
		l_queuenumber.setText("Ticket Number is : "+queueNumber);
		//sending to Printer or other objects for printing
	}
	
	
	private void buildGui(){
		JFrame f=new JFrame("Kiosk System");  
		JButton b_printTicket=new JButton("Issue Ticket");  		
		l_queuenumber=new JLabel("Server Customer : ");  

		b_printTicket.setBounds(50,100,150,40);  
		l_queuenumber.setBounds(50,150,150,40);  
		
		f.add(b_printTicket);  
		f.add(l_queuenumber);  
		f.setSize(400,400);  
		f.setLayout(null);  
		f.setVisible(true); 
		
		b_printTicket.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				issueTicket();
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

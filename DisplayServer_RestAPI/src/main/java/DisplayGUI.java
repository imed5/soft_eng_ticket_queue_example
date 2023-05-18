import javax.swing.*;

public class DisplayGUI {

    private JLabel l_message;
    public DisplayGUI(){
        buildGui();
    }
    public void showMessage(String message){
        l_message.setText(message);
    }
    private void buildGui(){
		JFrame f=new JFrame("Display System");  
		
		l_message=new JLabel("");  
		l_message.setBounds(50,150,150,40);  
		
		f.add(l_message);  
		f.setSize(400,400);  
		f.setLayout(null);  
		f.setVisible(true); 		
	}

}

import java.io.*;
import java.net.*;

public class DisplayNotify implements Runnable{

    private String content;
    public DisplayNotify(String data){
        content=data;
    }
    public void run() {
        //Send data to display server using whatever method...
        try{
            System.out.println("sending data to Display server : "+content);

            String url="http://localhost:5050/display/"+content;
            readURLPage(url);
        }catch(Exception e){e.printStackTrace();}
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

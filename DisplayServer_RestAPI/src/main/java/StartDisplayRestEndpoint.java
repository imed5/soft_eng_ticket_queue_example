import static spark.Spark.*;

public class StartDisplayRestEndpoint{
	public static void main(String [] args){		
		DisplayGUI gui=new DisplayGUI();
		System.out.println("Display Server Running: Skeleton, no major code ");
		
		port(5050);
		get("/display/:data", 
			(req, res) -> {
				String message=req.params(":data");
				gui.showMessage(message);
				System.out.println(message);
				return "ok";
			});

		}
}

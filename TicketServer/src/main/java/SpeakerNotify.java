
public class SpeakerNotify implements Runnable{

    private String content;
    public SpeakerNotify(String data){
        content=data;
    }
    public void run() {
        //Send data to speaker server using whatever method...
        System.out.println("sending data to speaker server : "+content);
    }
    
}

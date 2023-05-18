public class DataAccessSingleton{
	
	private static IDataAccessLayer dal;
	
	public static IDataAccessLayer getSingletonInstance(){
		if (dal==null){
			dal=new DataFromFile();
		}
		return dal;
	}
	
}
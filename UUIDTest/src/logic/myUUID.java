package logic;

//import java.util.ArrayList;
import java.util.UUID;

public class myUUID {
	
	public static String generateUUID(String id) {
		String prefix = id;
		String ID = prefix;
		
		//UUIDDAO dao = new UUIDDAO();
		
		//ArrayList<String> UUIDs = dao.getAll();
		
		ID += "-";
		ID += UUID.randomUUID().toString();
		
		//check
		//for(int i=0; i<UUIDs.size(); i++) {
		//	if(UUIDs.get(i) == ID) {
		//		generateUUID(prefix);
		//	}
		//}
		
		return ID;
	}
	
	public static String createUUID(String type) {
		
		String ID = "";
		
		switch(type) {
			case "User": 
				ID = generateUUID("01");
				break;
			case "Role":
				ID = generateUUID("02");
				break;
				
			//rest van de soorten invullen
				
			default:
				throw new RuntimeException("Type of ID not known");
		}
		
		return ID;
		
	}
}

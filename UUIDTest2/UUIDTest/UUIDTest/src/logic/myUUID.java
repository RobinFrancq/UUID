package logic;

import java.util.ArrayList;
import java.util.UUID;

import db.UUIDDAO;

public class myUUID {
	
	public static String generateUUID(String id) {
		String prefix = id;
		String ID = prefix;
		
		UUIDDAO dao = new UUIDDAO();
		
		ArrayList<String> UUIDs = dao.getAll();
		
		ID += "-";
		ID += UUID.randomUUID().toString();
		
		//check
		for(int i=0; i<UUIDs.size(); i++) {
			if(UUIDs.get(i) == ID) {
				generateUUID(prefix);
			}
		}
		
		return ID;
	}
	
	public static String createUUID(String id) {
		
		String ID = "";
		
		switch(id) {
			case "01": 
				//user
				ID = generateUUID(id);
				break;
			case "02":
				//factuur
				ID = generateUUID(id);
				break;
				
			//rest van de soorten invullen
				
			default:
				throw new RuntimeException("Type of ID not known");
		}
		
		return ID;
		
	}
}

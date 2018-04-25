package logic;

import java.util.ArrayList;
import java.util.UUID;

import db.UUIDDAO;

public class myUUID {
	private String UUID_ID;
	private String source_EntityID;
	private int entityTypeID;
	private int entityVersion;
	private int source_ID;
	
	//Contructor
	public myUUID(String uUID_ID, String source_EntityID, int entityTypeID, int entityVersion, int source_ID) {
		super();
		UUID_ID = uUID_ID;
		this.source_EntityID = source_EntityID;
		this.entityTypeID = entityTypeID;
		this.entityVersion = entityVersion;
		this.source_ID = source_ID;
	}
	
	
	//Getters and Setters
	public String getUUID_ID() {
		return UUID_ID;
	}
	public void setUUID_ID(String uUID_ID) {
		UUID_ID = uUID_ID;
	}

	public String getSource_EntityID() {
		return source_EntityID;
	}
	public void setSource_EntityID(String source_EntityID) {
		this.source_EntityID = source_EntityID;
	}

	public int getEntityTypeID() {
		return entityTypeID;
	}
	public void setEntityTypeID(int entityTypeID) {
		this.entityTypeID = entityTypeID;
	}

	public int getEntityVersion() {
		return entityVersion;
	}
	public void setEntityVersion(int entityVersion) {
		this.entityVersion = entityVersion;
	}

	public int getSource_ID() {
		return source_ID;
	}
	public void setSource_ID(int source_ID) {
		this.source_ID = source_ID;
	}
	
	// Function that generates a UUID
	public static String generateUUID() {
		
		UUIDDAO dao = new UUIDDAO();
		
		ArrayList<String> UUIDs = dao.getAll();
		
		String newUUID = UUID.randomUUID().toString();
		
		// Check if UUID exists allready
		for(int i=0; i<UUIDs.size(); i++) {
			if(UUIDs.get(i) == newUUID) {
				generateUUID();
			}
		}
		return newUUID;
	}

	
	// TWO FUNCTIONS THAT WILL BE USED BY OTHER SYSTEMS
	
	// Function that creates new UUID row into the database
	// Parameters of this function came from message
	public static void insertNewUUID(String sourceEntityId, int entityTypeId, int sourceId) {
		UUIDDAO dao = new UUIDDAO();
		String newUUID = generateUUID();
		myUUID UUID = new myUUID(newUUID, sourceEntityId, entityTypeId, 1, sourceId);
		dao.insert(UUID);
		System.out.println("New UUID created and inserted into UUIDMaster database");
		System.out.println("New UUID: " + newUUID);
	}
	
	// Function that updates the EntityVersion in the database
	// the parameter is form the message
	public static void updateVersion(myUUID UUID) {
		UUIDDAO dao = new UUIDDAO();
		dao.updateVersion(UUID);
		System.out.println("UUID version set to " + UUID.getEntityVersion());
	}
}

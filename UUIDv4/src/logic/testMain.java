package logic;


public class testMain {
	public static void main(String[] args) {
		
		// Aanmaak nieuwe UUID door de Kassa voor de entiteit Payment
		// Inhoud van de message van de kassa
		
		// Uitvoering van de methode
		myUUID newUUID = myUUID.createNewUUID("ABC", "Payment", "Kassa");
		
		// Frontend ontvangt de enititeit Payment in zijn queue
		// Frontend maakt nu zelf een row in de database met dezelfde UUID maar een andere sourceID
		//String UUIDToInsert = newUUID.getUUID_ID();
		
		// Uitvoering van de methode
		//myUUID.insertUUID(UUIDToInsert, "123", "Payment", "Frontend");
		
		
		
		// Frontend maakt een update aan de version van de UUID 
		
		// Uitvoeren van de methode
		//myUUID.updateVersion(UUIDToInsert, "123", "Payment", "Frontend");
		
		// Kassa ontvangt dezelfde payment entity maar met een andere version
		// Kassa gaat nu ook zijn version updaten 
		
		// Uitvoeren van de methode
		//myUUID.updateVersion(UUIDToInsert, "ABC", "Payment", "Kassa");
	}
}
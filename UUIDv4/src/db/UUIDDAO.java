package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logic.Entity;
import logic.Source;
import logic.myUUID;

public class UUIDDAO extends BaseDAO{
	
	public int insert(myUUID UUID) {
		PreparedStatement ps = null;

		String sql = "INSERT INTO UUID VALUES(?,?,?,?,?)";
		
		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			ps.setString(1, UUID.getUUID_ID());
			ps.setString(2, UUID.getSource_EntityID());
			ps.setInt(3, UUID.getEntityTypeID());
			ps.setInt(4, UUID.getEntityVersion());
			ps.setInt(5, UUID.getSource_ID());

			return ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				;
				throw new RuntimeException("error.unexpected");
			}
		}
	}
	
	
	public ArrayList<String> getAll() {
		ArrayList<String> result = new ArrayList<String>();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;

		String sql = "SELECT * FROM UUID";
		
		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()) { 
				String ID = rs.getString("UUID"); 
				result.add(ID);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				;
				throw new RuntimeException("erro unexpected");
			}
		}
		
		return result;
	}
	
	public ArrayList<myUUID> getByUUID(String UUID) {
		ArrayList<myUUID> result = new ArrayList<myUUID>();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;

		String sql = "SELECT * FROM UUID WHERE UUID='?'";
		
		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()) { 
				String ID = rs.getString("UUID"); 
				String source_entityID = rs.getString("Source_EntityID"); 
				int entityTypeID = rs.getInt("EntityTypeID"); 
				int entityVersionID = rs.getInt("EntityVersion"); 
				int source_ID = rs.getInt("SourceID"); 
				myUUID uuid= new myUUID(ID,source_entityID,entityTypeID,entityVersionID,source_ID);
				result.add(uuid);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				;
				throw new RuntimeException("erro unexpected");
			}
		}
		
		return result;
	}
	
	public ArrayList<Entity> getEntityByName(String entityName) {
		
		ArrayList<Entity> result = new ArrayList<Entity>();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;

		String sql = "SELECT * FROM EntityType WHERE name=?";
		
		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, entityName);

			rs = ps.executeQuery();
			
			while(rs.next()) { 
				int ID = rs.getInt("id"); 
				String name = rs.getString("name"); 
				
				Entity entity = new Entity(ID, name);
				result.add(entity);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				;
				throw new RuntimeException("error unexpected");
			}
		}
		return result;
	}
	
	public ArrayList<Source> getSourceByName(String sourceName) {
		
		ArrayList<Source> result = new ArrayList<Source>();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;

		String sql = "SELECT * FROM Source WHERE Name=?";
		
		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, sourceName);

			rs = ps.executeQuery();
			
			while(rs.next()) { 
				int ID = rs.getInt("id"); 
				String name = rs.getString("name"); 
				
				Source source = new Source(ID, name);
				result.add(source);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				;
				throw new RuntimeException("error unexpected");
			}
		}
		return result;
	}
	
	public void updateVersion(myUUID UUID) {
		
		PreparedStatement ps = null;

		String sql = "UPDATE UUID SET EntityVersion = EntityVersion + 1 WHERE UUID=? AND Source_EntityID=? AND EntityTypeID=? AND SourceID=?";
		
		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, UUID.getUUID_ID());
			ps.setString(2, UUID.getSource_EntityID());
			ps.setInt(3, UUID.getEntityTypeID());
			ps.setInt(4, UUID.getSource_ID());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				;
				throw new RuntimeException("erro unexpected");
			}
		}
		
		
	}
	
}

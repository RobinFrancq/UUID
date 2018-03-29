package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UUIDDAO extends BaseDAO{
	
	public int insert(String ID) {
		PreparedStatement ps = null;

		String sql = "INSERT INTO UUID VALUES(?)";
		
		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			ps.setString(1, ID);

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
				throw new RuntimeException("error.unexpected");
			}
		}
		
		return result;
	}
}

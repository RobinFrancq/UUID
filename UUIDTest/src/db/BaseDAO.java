package db;

import java.sql.Connection;

public abstract class BaseDAO {
	private Connection connection;

	protected Connection getConnection() {
		return connection;
	}

	protected void setConnection(Connection connection) {
		this.connection = connection;
	}

	public BaseDAO() {
		setConnection(DatabaseSingleton.getDatabaseSingleton().getConnection(
				true));
	}

}
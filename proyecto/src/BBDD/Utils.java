package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	private final static String stringConnector = "jdbc:mysql://localhost:3306/damg2";
	private final static String user = "root";
	private final static String pass = "";

	private static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(stringConnector, user, pass);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	private static int contarInterrogaciones(String sql) {
		int contador = 0;
		for (int i = 0; i < sql.length(); i++) {
			if (sql.charAt(i) == '?') {
				contador++;
			}
		}
		return contador;
	}
	
	public static List<Integer> insertDataAndGetId(String sql, List<Object> data) {
		return doAction(sql,data,true);
	}
	
	public static void insertData(String sql,List<Object> data){
		doAction(sql, data, false);
	}	
	
	private static List<Integer> doAction(String sql, List<Object> data, boolean devolverId) {
		List<Integer> ids = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql,
						devolverId ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS)) {
			int numInte = contarInterrogaciones(sql);

			boolean esLote = data.size() % numInte == 0;

			if (!esLote) {
				throw new Exception("Los datos no coinciden con las ?");
			}
			for (int i = 0, posicion = 1; i < data.size(); i++, posicion++) {
				ps.setObject(posicion, data.get(i));
				if ((i + 1) % numInte == 0) {
					posicion = 0;
					ps.addBatch();
				}
			}
			ps.executeBatch();

			if (!devolverId)
				return null;
			
			try (ResultSet rs = ps.getGeneratedKeys()) {
				while (rs.next()) {
					ids.add(rs.getInt(1));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ids;
	}
}

package BBDD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main2 {

	public static void main(String[] args) {
		String sql = "insert into usuarios(nombre, contraseña) values(?,?)";
		List<Object> data = new ArrayList<>();
		data.add("Andrés");
		data.add("123123");
		data.add("miguel");
		data.add("miguel1");
		Utils.insertData(sql, data);
		List<Integer> ids1 = Utils.insertDataAndGetId(sql, data);
		System.out.println(ids1);
	}
}

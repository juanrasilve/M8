package com.video.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexiones {
	
	public Connection conexion(){
		//Conexi�n a BBDD
		
		Connection conexion1 = null;
		
		// usuario y clave
				String user = "root";
				String password = "sasa";
				try {
		 
					// una sola cadena de conexi�n, en un s�lo par�metro se concatena el
					// usuario y el password
					String url1 = "jdbc:mysql://localhost:3306/mydbvideos?user=" + user + "&password=" + password;
					conexion1 = DriverManager.getConnection(url1);
					if (conexion1 != null) {
						System.out.println("Conexi�n 1: Conexi�n a mydbvideos satisfactoria");
					}
				
				} catch (SQLException e) {
					System.out.println(
							"Error en la conexi�n, verifique, su usuario y password o el nombre de la base a la que intenta conectarse");
					e.printStackTrace();
				}
				return conexion1;
			}

}

package com.video.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.video.dao.UsuariDao;
import com.video.model.Usuari;

public class UsuariDaoImpl implements UsuariDao{

	public int createUsuari(Usuari usu, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql1 = "INSERT INTO USUARI (NOM,COGNOM,PASSWORD,DATA_REGISTRE) VALUES ('"+usu.getNom() +"','"+usu.getCognom()+"','"+usu.getPassword()+"',CURDATE())";
			stmt.execute(sql1);
			
			String sql2 = "SELECT IDUSUARI FROM USUARI WHERE NOM='"+usu.getNom()+"' and COGNOM='"+usu.getCognom()+"' and PASSWORD='"+usu.getPassword()+"'";
			PreparedStatement  ps = conn.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				usu =new Usuari(); 
				usu.setIdusuari(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usu.getIdusuari();
	}

	@Override
	public Usuari getUsuari(int idusuari,Connection conn) {
		Usuari usu=null;
		try {
			String sql = "SELECT * FROM USUARI WHERE IDUSUARI= " + idusuari;
			PreparedStatement  ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				usu =new Usuari(); 
				usu.setIdusuari(rs.getInt(1));
				usu.setNom(rs.getString(2));
				usu.setCognom(rs.getString(3));
				usu.setDataRegistre(rs.getString(4));	
			}
			return usu;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usu;
	}

	@Override
	public void updateUsuari(Usuari usuari,Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "UPDATE USUARI SET NOM="+usuari.getNom()+",COGNOM="+usuari.getCognom()+",PASSWORD="+usuari.getPassword()+" WHERE IDUSUARI="+usuari.getIdusuari();
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUsuari(Usuari usuari,Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM USUARI WHERE IDUSUARI="+usuari.getIdusuari();
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int getIdUsuari(Usuari usuari,Connection conn) {
		
		try {
			String sql = "SELECT IDUSUARI FROM USUARI WHERE NOM='"+usuari.getNom()+"' and PASSWORD='"+usuari.getPassword()+"'";
			PreparedStatement  ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {  
				usuari.setIdusuari(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  usuari.getIdusuari();
	}

}

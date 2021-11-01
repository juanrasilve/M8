package com.video.dao;

import java.sql.Connection;

import com.video.model.Usuari;

public interface UsuariDao {
	
	public int createUsuari(Usuari usu,Connection conn);
	public Usuari getUsuari(int idusuari,Connection conn);
	public void updateUsuari(Usuari usuari,Connection conn);
	public void deleteUsuari(Usuari usuari,Connection conn);
	public int getIdUsuari(Usuari usuari,Connection conn);

}

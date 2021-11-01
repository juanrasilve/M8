package com.video.controller;

import java.sql.Connection;
import java.util.Date;

import com.video.dao.impl.UsuariDaoImpl;
import com.video.model.Usuari;
import com.video.model.Video;
import com.video.view.AppVideo;

public class UsuarioController{
	
	private Usuari model;
	private AppVideo view;
	
	 public UsuarioController(Usuari model, AppVideo view){
	      this.model = model;
	      this.view = view;
	 }
	 
	 public void setIdusuari(int idUsuari){
	      model.setIdusuari(idUsuari);
	 }
	 
	 public void setNom(String nom){
	      model.setNom(nom);		
	 }
	 
	 public void setCognom(String cognom){
	      model.setNom(cognom);		
	 }
	 
	 public void setPassword(String password){
	      model.setPassword(password);		
	 }
	 
	 public void setDateRegistre(String dateRegistre){
	      model.setDataRegistre(dateRegistre);		
	 }
	  
	 public int createUsuario(Usuari usu,Connection conn){	
		  UsuariDaoImpl usuDao = new UsuariDaoImpl();
		  return usuDao.createUsuari(usu,conn);
	      //view.printStudentDetails(model.getName(), model.getRollNo());
	 }	
	 
	 public void readUsuario(){				
	      //view.printStudentDetails(model.getName(), model.getRollNo());
	 }	
	 
	 public void updateUsuario(){				
	      //view.printStudentDetails(model.getName(), model.getRollNo());
	 }	
	 public void deleteUsuario(){				
	      //view.printStudentDetails(model.getName(), model.getRollNo());
	 }	
	 
	 public int obtenerUsuario(Usuari usu,Connection conn){	
		  UsuariDaoImpl usuDao = new UsuariDaoImpl();
		  return usuDao.getIdUsuari(usu,conn);
	      //view.printStudentDetails(model.getName(), model.getRollNo());
	 }	
}
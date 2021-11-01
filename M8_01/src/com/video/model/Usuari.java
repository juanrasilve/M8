package com.video.model;

public class Usuari {
	
	private int idusuari;
	private String nom;
	private String cognom;
	private String password;
	private String dataRegistre;
	
	public int getIdusuari() {
		return idusuari;
	}
	public void setIdusuari(int idusuari) {
		this.idusuari = idusuari;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCognom() {
		return cognom;
	}
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDataRegistre() {
		return dataRegistre;
	}
	public void setDataRegistre(String dataRegistre) {
		this.dataRegistre = dataRegistre;
	}

}

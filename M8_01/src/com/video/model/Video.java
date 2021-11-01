package com.video.model;

import java.sql.Date;

public class Video {
	
	private int idvideo;
	private String url;
	private String titol;
	private int idusuari;
	private Date fecha;
	private String estat;
	
	public int getIdvideo() {
		return idvideo;
	}
	public void setIdvideo(int idvideo) {
		this.idvideo = idvideo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitol() {
		return titol;
	}
	public void setTitol(String titol) {
		this.titol = titol;
	}
	public int getIdusuari() {
		return idusuari;
	}
	public void setIdusuari(int idusuari) {
		this.idusuari = idusuari;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstat() {
		return estat;
	}
	public void setEstat(String estat) {
		this.estat = estat;
	}
	
	
}

package com.video.controller;

import java.sql.Connection;
import java.util.List;

import com.video.dao.impl.UsuariDaoImpl;
import com.video.dao.impl.VideoDaoImpl;
import com.video.model.Video;
import com.video.view.AppVideo;

public class VideoController {
	
	private Video model;
	private AppVideo view;
	
	 public VideoController(Video model, AppVideo view){
	      this.model = model;
	      this.view = view;
	 }
	 
	 public void setURL(String url){
	      model.setUrl(url);		
	 }
	 
	 public void setTitol(String titol){
	      model.setTitol(titol);		
	 }
	 
	 public void setIdUsuari(int idusuari){
	      model.setIdusuari(idusuari);		
	 }
	 
	 public int createVideo(Video video,Connection conn){				
		 VideoDaoImpl videoDao = new VideoDaoImpl();
		 return videoDao.createVideo(video,conn);
	 }	
	 
	 public void readVideo(){				
	 }	
	 
	 public void updateVideo(Video video,Connection conn){	
		 VideoDaoImpl videoDao = new VideoDaoImpl();
		 videoDao.updateVideo(video,conn);
	 }	
	 public void deleteVideo(){				
	 }	
	 
	 public List<Video> getVideosByUsuari(int idUsuari,Connection conn){
		 VideoDaoImpl videoDao = new VideoDaoImpl();
		 return videoDao.getVideosByUsuari(idUsuari,conn);
	 }
}
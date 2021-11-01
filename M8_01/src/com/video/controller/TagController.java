package com.video.controller;

import java.sql.Connection;
import java.util.List;

import com.video.dao.impl.TagDaoImpl;
import com.video.dao.impl.UsuariDaoImpl;
import com.video.dao.impl.VideoDaoImpl;
import com.video.model.Tag;
import com.video.model.Video;
import com.video.view.AppVideo;

public class TagController {
	
	private Tag model;
	private AppVideo view;
	
	 public TagController(Tag model, AppVideo view){
	      this.model = model;
	      this.view = view;
	 }
	 
	 public void setNom_tag(String nomTag) {
	      model.setNom_tag(nomTag);	
	 }
	 
	 public void setId_video(int id_video) {
			model.setId_video(id_video);
		}
	 
	 public int createTag(Tag tag,Connection conn){				
	      //view.printStudentDetails(model.getName(), model.getRollNo());
		 TagDaoImpl tagDao = new TagDaoImpl();
		 return tagDao.createTag(tag,conn);
	 }	
	 
	 public void readVideo(){				
	      //view.printStudentDetails(model.getName(), model.getRollNo());
	 }	
	 
	 public void updateVideo(){				
	      //view.printStudentDetails(model.getName(), model.getRollNo());
	 }	
	 public void deleteVideo(){				
	      //view.printStudentDetails(model.getName(), model.getRollNo());
	 }	
	 
	 public List<Tag> getTagByIdVideo(int id_video, Connection conn) {
		 TagDaoImpl tagDao = new TagDaoImpl();
		 return tagDao.getTagByIdVideo(id_video,conn);
		 
	 }
}
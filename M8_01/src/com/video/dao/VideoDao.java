package com.video.dao;

import java.sql.Connection;
import java.util.List;

import com.video.model.Usuari;
import com.video.model.Video;

public interface VideoDao {
	
	public int createVideo(Video video,Connection conn);
	public Video getVideo(int idusuari,Connection conn);
	public void updateVideo(Video video,Connection conn);
	public void deleteVideo(Video video,Connection conn);
	public List<Video> getVideosByUsuari(int idUsuari,Connection conn);

}

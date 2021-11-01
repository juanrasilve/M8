package com.video.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.video.dao.VideoDao;
import com.video.model.Estats;
import com.video.model.Video;

public class VideoDaoImpl implements VideoDao{

	public int createVideo(Video video, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
			String sql1 = "INSERT INTO VIDEO (TITOL,URL,USUARI_IDUSUARI,DATA_PUJADA,ESTAT) VALUES ('"+video.getTitol() +"','"+video.getUrl()+"','"+video.getIdusuari()+"',Date_format(now(),'%Y/%m/%d %h:%i:%s'),'"+video.getEstat()+"')";
			stmt.execute(sql1);
			
			String sql2 = "SELECT IDVIDEO FROM VIDEO WHERE USUARI_IDUSUARI="+video.getIdusuari();
			PreparedStatement  ps = conn.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				video =new Video(); 
				video.setIdvideo(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return video.getIdvideo();
	}

	@Override
	public Video getVideo(int idVideo,Connection conn) {
		Video vid=null;
		try {
			String sql = "SELECT * FROM VIDEO WHERE IDVIDEO= " + idVideo;
			PreparedStatement  ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				vid =new Video(); 
				vid.setIdvideo(rs.getInt(1));
				vid.setTitol(rs.getString(2));
				vid.setUrl(rs.getString(3));
				vid.setIdusuari(rs.getInt(4));
			}
			return vid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vid;
	}

	@Override
	public void updateVideo(Video video,Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			
			//Actualitza a Verifying
			String sql1 = "UPDATE VIDEO SET ESTAT='"+Estats.VERIFYING+"' WHERE USUARI_IDUSUARI ="+video.getIdusuari()+" AND DATA_PUJADA <  (SELECT DATE_SUB(NOW(),INTERVAL 30 SECOND))";
			stmt.execute(sql1);
			
			//Actualitza a Public
			String sql2 = "UPDATE VIDEO SET ESTAT='"+Estats.PUBLIC+"' WHERE USUARI_IDUSUARI ="+video.getIdusuari()+" AND DATA_PUJADA <  (SELECT DATE_SUB(NOW(),INTERVAL 60 SECOND))";
			stmt.execute(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteVideo(Video video,Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM VIDEO WHERE IDVIDEO="+video.getIdvideo();
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Video> getVideosByUsuari(int idUsuari,Connection conn) {
		Video vid=null;
		List<Video> videos = new ArrayList<Video>();
		try {
			String sql = "SELECT * FROM VIDEO WHERE USUARI_IDUSUARI= " + idUsuari;
			PreparedStatement  ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				vid =new Video(); 
				vid.setIdvideo(rs.getInt(1));
				vid.setTitol(rs.getString(2));
				vid.setUrl(rs.getString(3));
				vid.setIdusuari(rs.getInt(4));
				vid.setFecha(rs.getDate(5));
				vid.setEstat(rs.getString(6));
				videos.add(vid);
			}
			return videos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videos;
	}

	
	

}

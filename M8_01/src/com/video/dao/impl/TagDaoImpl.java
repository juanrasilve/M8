package com.video.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.video.dao.TagDao;
import com.video.model.Tag;

public class TagDaoImpl implements TagDao{

	public int createTag(Tag tag, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql1 = "INSERT INTO TAG (NOM_TAG,VIDEO_IDVIDEO) VALUES ('"+tag.getNom_tag() +"','"+tag.getId_video()+"')";
			stmt.execute(sql1);
			
			String sql2 = "SELECT IDTAG FROM TAG WHERE VIDEO_IDVIDEO="+tag.getIdtag();
			PreparedStatement  ps = conn.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				tag =new Tag(); 
				tag.setIdtag(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tag.getIdtag();
	}

	@Override
	public Tag getTag(int idTag,Connection conn) {
		Tag tag=null;
		try {
			String sql = "SELECT * FROM TAG WHERE IDTAG= " + idTag;
			PreparedStatement  ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				tag =new Tag(); 
				tag.setIdtag(rs.getInt(1));
				tag.setNom_tag(rs.getString(2));
				tag.setId_video(rs.getInt(3));
			}
			return tag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tag;
	}

	@Override
	public void updateTag(Tag tag,Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "UPDATE TAG SET NOM_TAG='"+tag.getNom_tag()+"',VIDEO_IDVIDEO='"+tag.getId_video()+"' WHERE IDTAG="+tag.getIdtag();
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTag(Tag tag,Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM TAG WHERE IDTAG="+tag.getIdtag();
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Tag> getTagByIdVideo(int idVideo,Connection conn) {
		Tag tag=null;
		List<Tag> tags = new ArrayList<Tag>();
		try {
			String sql = "SELECT * FROM TAG WHERE VIDEO_IDVIDEO= " + idVideo;
			PreparedStatement  ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				tag =new Tag(); 
				tag.setIdtag(rs.getInt(1));
				tag.setNom_tag(rs.getString(2));
				tag.setId_video(rs.getInt(3));
				
				tags.add(tag);
			}
			return tags;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tags;
	}

}

package com.video.dao;

import java.sql.Connection;
import java.util.List;

import com.video.model.Tag;

public interface TagDao {
	
	public int createTag(Tag tag,Connection conn);
	public Tag getTag(int idTag,Connection conn);
	public void updateTag(Tag tag,Connection conn);
	public void deleteTag(Tag tag,Connection conn);
	public List<Tag> getTagByIdVideo(int idVideo,Connection conn);

}

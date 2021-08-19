package com.food.myapp.board;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlAccessorType(XmlAccessType.FIELD) // 부모- 자식 엘리먼트
public class BoardVO {
	@XmlAttribute // 엘리먼트를 구분할수있게하는 속성으로 설정
	private int id;
	private String title;
	private String writer;
	private String content;
	private Date wdate;
	private int cnt;
	
	private String SearchContent;

	private String Search;
	

	public String getSearchContent() {
		return SearchContent;
	}
	public void setSearchContent(String searchContent) {
		SearchContent = searchContent;
	}

	public String getSearch() {
		return Search;
	}
	public void setSearch(String search) {
		Search = search;
	}


	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public String toString() {
		return "BoardVO: "+id+" "+title;
	}
	
	
	
	
	
	
	
	
}

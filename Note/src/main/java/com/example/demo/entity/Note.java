package com.example.demo.entity;

import java.util.Date;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Note {
	
	@Id
	private int id;
	private String title;

	@Column(length = 1500)
	private String content;
	private Date date;
	
	
	
	public Note( String title, String content, Date date) {
		super();
		this.id = new Random().nextInt(999) ;
		this.title = title;
		this.content = content;
		this.date = date;
	}
	
	public Note( int id,String title, String content, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public Note() {
		
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + "]";
	}
	
	
	
	
	

}

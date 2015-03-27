package ru.tutorialsworld.models.entities;

import java.util.Date;

public class Article {
	private int id;
	private String title;
	private String url;
	private Date createDate;
	private Date modifiedDate;
	private String userName;
	private int categoryId;
	private String content;
	
	public Article(int id, String title, String url, Date createDate,
			Date modifiedDate, String userName, int categoryId, String content) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.userName = userName;
		this.categoryId = categoryId;
		this.content = content;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}

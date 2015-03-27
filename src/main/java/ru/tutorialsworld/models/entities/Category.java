package ru.tutorialsworld.models.entities;

public class Category {
	private int id;
	private String name;
	private String fullName;
	private int parentId;
	private int sortIndex;

	public Category(int id, String name, String fullName, int parentId, int sortIndex) {
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.parentId = parentId;
		this.sortIndex = sortIndex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}

}

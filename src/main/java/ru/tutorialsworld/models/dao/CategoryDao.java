package ru.tutorialsworld.models.dao;

import java.util.List;

import ru.tutorialsworld.models.entities.Category;

public interface CategoryDao {
	public List<Category> getAllCategories();
	
	public List<Category> getAllCategoriesByLevel(int lvl);

	public Category getCategoryById(int id);
	
	public Category getCategoryByName(String name);

	public void createCategory(Category cat);

	public void deleteCategory(Category cat);

	public void updateCategory(Category cat);

}

package ru.tutorialsworld.models;

import java.util.ArrayList;
import java.util.List;

import ru.tutorialsworld.models.dao.CategoryDao;
import ru.tutorialsworld.models.dao.CategoryDaoImpl;
import ru.tutorialsworld.models.entities.Category;

public class CategoryModel {
	public static List<Category> getAllCategories() {
		CategoryDao categoryDao = new CategoryDaoImpl();
		return categoryDao.getAllCategories();
	}

	public static Category getCategoryById(int categoryId){
		CategoryDao categoryDao = new CategoryDaoImpl();
		return categoryDao.getCategoryById(categoryId);
	}
	
	public static List<Category> getSubcategories(Category parentCategory) {
		List<Category> subcategories = new ArrayList<Category>();
		for (Category category : getAllCategories()) {
			if (category.getParentId() == parentCategory.getId()) {
				subcategories.add(category);
			}
		}
		return subcategories;
	}
	
	public static List<Category> getSubcategoriesByID(int parentCategory) {
		List<Category> subcategories = new ArrayList<Category>();
		for (Category category : getAllCategories()) {
			if (category.getParentId() == parentCategory) {
				subcategories.add(category);
			}
		}
		return subcategories;
	}
	

	public static List<Category> getTopLevelCategories() {
		List<Category> subcategories = new ArrayList<Category>();
		for (Category category : getAllCategories()) {
			if (category.getParentId() == 0) {
				subcategories.add(category);
			}
		}
		return subcategories;
	}

	// by name
	public static List<Category> getCategoriesByLevel(int lvl) {
		List<Category> allCategories = getAllCategories();
		List<ArrayList<Category>> categoryByLvl = new ArrayList<ArrayList<Category>>();
		categoryByLvl.add((ArrayList<Category>) getTopLevelCategories());
		ArrayList<Category> lvl1 = new ArrayList<Category>();
		for (int i = 0; i < categoryByLvl.get(0).size(); i++) {
			for (Category cat : getSubcategories(categoryByLvl.get(0).get(i))) {
				lvl1.add(cat);
			}
		}
		categoryByLvl.add(lvl1);
		ArrayList<Category> lvl2 = new ArrayList<Category>();
		for (int i = 0; i < categoryByLvl.get(1).size(); i++) {
			for (Category cat : getSubcategories(categoryByLvl.get(1).get(i))) {
				lvl2.add(cat);
			}
		}
		categoryByLvl.add(lvl2);
		return categoryByLvl.get(lvl);
	}
}

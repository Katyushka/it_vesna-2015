package ru.tutorialsworld.models.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ru.tutorialsworld.models.connection.ConnectionProvider;
import ru.tutorialsworld.models.entities.Category;
import ru.tutorialsworld.models.entities.User;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> getAllCategories() {
		ArrayList<Category> categories = new ArrayList<Category>();
		try {
			String query = "SELECT * FROM categories";
			Statement ps = getConnection().createStatement();
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String fullName = rs.getString("full_name");
				int parentId = rs.getInt("parent_id");
				int sortIndex = rs.getInt("sort_index");
				Category cateroty = new Category(id, name, fullName, parentId,
						sortIndex);
				categories.add(cateroty);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<Category> getAllCategoriesByLevel(int lvl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryById(int id) {
		Category category = null;
		try {
			String query = "SELECT * FROM categories WHERE Id = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				int idParam = rs.getInt("id");
				String nameParam = rs.getString("name");
				String fullNameParam = rs.getString("full_name");
				int parentIdParam = rs.getInt("parent_id");
				int sortIndexParam = rs.getInt("sort_index");
				category = new Category(idParam, nameParam, fullNameParam, parentIdParam, sortIndexParam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public void createCategory(Category cat) {
		// TODO Auto-generated method stub
		Category newCategory = null;
		try {
			String query = "INSERT INTO categories (id, name, full_name, parent_id, sort_index) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = getConnection().prepareStatement(query);
			pstmt.setInt(1, cat.getId());
			pstmt.setString(2, cat.getName());
			pstmt.setString(3, cat.getFullName());
			pstmt.setInt(4, cat.getParentId());
			pstmt.setInt(5, cat.getSortIndex());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCategory(Category cat) {
		// TODO Auto-generated method stub
		try {
		String query = "DELETE FROM categories WHERE id = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(query);
		pstmt.setInt(1, cat.getId());
		pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public Category getCategoryByName(String name) {
		Category category = null;
		try {
			String query = "SELECT * FROM categories WHERE name = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(query);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				int idParam = rs.getInt("id");
				String nameParam = rs.getString("name");
				String fullNameParam = rs.getString("full_name");
				int parentIdParam = rs.getInt("parent_id");
				int sortIndexParam = rs.getInt("sort_index");
				category = new Category(idParam, nameParam, fullNameParam, parentIdParam, sortIndexParam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
		
	}

	@Override
	public void updateCategory(Category cat) {
		// TODO Auto-generated method stub

	}

	private Connection getConnection() {
		return ConnectionProvider.getConnection();
	}

	

}

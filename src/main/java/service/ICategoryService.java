package service;

import model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> categoryList();
    Category getCategoryById(int id);
    Category getCategoryByName(String categoryName);
    void save(Category category);
    void update(int id, Category newCategory);
    void delete(int id);

}

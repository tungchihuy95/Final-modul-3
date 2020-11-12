package service;

import com.sun.scenario.effect.impl.prism.PrImage;
import model.Category;
import sun.print.PeekGraphics;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService {


    private static String jdbcURL = "jdbc:mysql://localhost:3306/final3?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "caubephuthuy";

    private static final String SELECT_ALL_CATEGORY = "select * from category;";
    private static final String SELECT_CATEGORY_BY_ID = " select * from category where category_id =?;";
    private static final String SELECT_CATEGORY_BY_NAME = "select * from category where category_name =?;";

//    private static final String SELECT_ALL_PRODUCT = "select * from product;";
//    private static final String INSERT_PRODUCT = "insert into product values (?,?,?,?,?,?,?)";
//    private static final String UPDATE_PRODUCT = "update product set product_name=?, price=?, quantity=?, color=?, short_desc=?, category_id=? where pro "
//    private static final String DELETE_PRODUCT =

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    @Override
    public List<Category> categoryList() {
        List<Category> categories = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("category_id");
                String name = resultSet.getString("category_name");
                String status = resultSet.getString("status");
                categories.add(new Category(id, name, status));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getCategoryById(int id) {
        Connection connection = getConnection();
        Category category = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("category_name");
                String status = resultSet.getString("status");
                category = new Category(id, name, status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        Connection connection = getConnection();
        Category category = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_NAME);
            preparedStatement.setString(1,categoryName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("category_id");
                String name = resultSet.getString("category_name");
                String status = resultSet.getString("status");
                category = new Category(id, name, status);
            }
        }  catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void update(int id, Category newCategory) {

    }

    @Override
    public void delete(int id) {

    }
}

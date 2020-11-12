package service;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "caubephuthuy";

    private static final String SELECT_ALL_PRODUCT = "select * from product;";
    private static final String INSERT_PRODUCT = "insert into product values (?,?,?,?,?,?,?)";
    private static final String UPDATE_PRODUCT = "update product set product_name=?, price=?, quantity=?, color=?, short_desc=?, category_id=? where product_id=? ";
    private static final String DELETE_PRODUCT = "delete from product where product_id = ?;";
    private static final String SELECT_PRODUCT_BY_ID = "select * from product where product_id = ?;";

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
    public List<Product> productList() {
        Connection connection = getConnection();
        ICategoryService categoryService=new CategoryServiceImpl();
        List<Product> products=new ArrayList<>();
        try {
            PreparedStatement ps=connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("product_id");
                String name=rs.getString("product_name");
                float price =rs.getFloat("price");
                int quantity=rs.getInt("quantity");
                String color = rs.getString("color");
                String shortDesc = rs.getString("short_desc");
                int categoryId = rs.getInt("category_id");
                Category category = categoryService.getCategoryById(categoryId);

                products.add(new Product(id, name, price,quantity, color, shortDesc,category));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public String getProductNameById(int id) {
        return null;
    }

    @Override
    public void insertProduct(Product product) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setInt(1, product.getProductId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setFloat(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getShortDesc());
            preparedStatement.setInt(7, product.getCategory().getCategory_id());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Category> selectAllCategory(){
        List<Category> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("select * from category;");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("category_id");
                String name= resultSet.getString("category_name");
                String status= resultSet.getString("status");
                list.add(new Category(id, name, status));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    @Override
    public void updateProduct(int id, Product newProduct) {

    }

    @Override
    public void deleteProduct(int id) {

    }
}

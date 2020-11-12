package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> productList();
    String getProductNameById(int id);
    void insertProduct(Product product);
    void updateProduct(int  id, Product newProduct);
    void deleteProduct(int id);
}

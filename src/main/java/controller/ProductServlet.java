package controller;

import model.Category;
import model.Product;
import service.CategoryServiceImpl;
import service.ICategoryService;
import service.IProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                insertProduct(request,response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "search":
                showSearch(request, response);
                break;
            default:
                showListProduct(request,response);
                break;
        }
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
        return;
    }


    private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("product_id"));
        String name=request.getParameter("product_name");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color =request.getParameter("color");
        String short_desc =request.getParameter("short_desc");
        String categoryName = request.getParameter("categoryName");
        Category category=categoryService.getCategoryByName(categoryName);
        productService.insertProduct(new Product(id,name, price, quantity, color, short_desc,category));
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                showListProduct(request,response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categories=categoryService.categoryList();

        request.setAttribute("categories",categories);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/product/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products=productService.productList();
        request.setAttribute("products",products);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/product/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

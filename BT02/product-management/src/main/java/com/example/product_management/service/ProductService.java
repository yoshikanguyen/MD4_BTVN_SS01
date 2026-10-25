package com.example.product_management.service;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> productList = new ArrayList<>();

    public ProductService() {
        productList.add(new Product(1L, "Laptop Dell", 1500.0));
        productList.add(new Product(2L, "iPhone 15", 1200.0));
        productList.add(new Product(3L, "Chuột Logitech", 25.0));
    }

    // Lấy danh sách sản phẩm
    public List<Product> getAllProducts() {
        return productList;
    }

    // Thêm
    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    // Sửa
    public Product updateProduct(Long id, Product newProduct) {
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                p.setName(newProduct.getName());
                p.setPrice(newProduct.getPrice());
                return p;
            }
        }
        return null;
    }

    // Xóa
    public boolean deleteProduct(Long id) {
        return productList.removeIf(p -> p.getId().equals(id));
    }
}
package com.app.dao;

import com.app.model.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product,Long>{

    public List<Product> findByBrand(String brand);
}

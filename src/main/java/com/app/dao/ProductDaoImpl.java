package com.app.dao;

import com.app.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findByBrand(String brand) {
        Query query = this.em.createQuery("from Product where brand = :brand");
        query.setParameter("brand", brand);
        return query.getResultList();
    }

    @Override
    public List<Product> findAll() {
        return this.em.createQuery("from Product").getResultList();
    }

    @Override
    public Product findOne(Long key) {
        return this.em.find(Product.class, key);
    }

    @Override
    public Product create(Product entity) {
        this.em.persist(entity);
        this.em.flush();
        return findOne(entity.getId());
    }

    @Override
    public Product update(Product entity) {
        return this.em.merge(entity);
    }

    @Override
    public void delete(Product entity) {
        this.em.remove(this.em.find(Product.class, entity.getId()));
    }

    @Override
    public void deleteById(Long key) {
        this.em.remove(this.em.find(Product.class, key));
    }
}

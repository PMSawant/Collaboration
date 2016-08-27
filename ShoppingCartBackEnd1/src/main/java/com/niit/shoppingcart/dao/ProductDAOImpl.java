package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;

@Repository("productDAO")

public class ProductDAOImpl implements ProductDAO {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Product product) {
		System.out.println("hiii");
		sessionFactory.getCurrentSession().saveOrUpdate(product);

	}

	@Transactional
	public void delete(String id) {
		Product productToDelete = new Product();
		productToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(productToDelete);

	}

	@Transactional
	public Product get(String id) {
		logger.debug("calling get");
		String hql = "from Product where id=" + "'" + id + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();

		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}logger.debug("End get");
		return null;
	}

	@Transactional
	public List<Product> list() {
		logger.debug("calling list");
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		logger.debug("calling list");
		return listProduct;
	}

	@Transactional
	public Product getProduct(String Category_id) {
			logger.debug("calling get");
			String hql = "from Product,Category where id=" + "'" + Category_id + "'";
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Product> listProduct = (List<Product>) query.list();

			if (listProduct != null && !listProduct.isEmpty()) {
				return listProduct.get(0);
			}logger.debug("End get");
			
		return null;
	}

	
	@Transactional
	public Product getProduct1(String Supplier_id) {
			logger.debug("calling get");
			String hql = "from Product,Category where id=" + "'" + Supplier_id + "'";
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Product> listProduct = (List<Product>) query.list();

			if (listProduct != null && !listProduct.isEmpty()) {
				return listProduct.get(0);
			}logger.debug("End get");
			
		return null;
	}	
}

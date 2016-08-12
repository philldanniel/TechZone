package com.ecomm.techzone.dao;



import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.techzone.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
//	 protected Session getSession(){
//	        return sessionFactory.getCurrentSession();
//	    }
//	
	 public ProductDAOImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	 
	 
	
	@Transactional
	public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> listProduct = sessionFactory.getCurrentSession()
												  .createCriteria(Product.class)
												  .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;
	}


	@Transactional
	public Product get(String id) {
		//String hql = "from Category where id="+"'"+cat_id+"'";
		
	//	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	/*	Category cat =sessionFactory.getCurrentSession().get(Category.class, cat_id);
		return cat; */
		
		String hql = "from Product where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listProduct = query.getResultList();
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}

		return null;
	}


	@Transactional
	public void saveOrUpdate(Product product) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}


	@Transactional
	public void delete(String id) {
		Product productToDelete = new Product();
		productToDelete.setId(id);

		sessionFactory.getCurrentSession().delete(productToDelete);
		
	}

}

package com.ecomm.techzone.dao;



import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.techzone.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
//	 protected Session getSession(){
//	        return sessionFactory.getCurrentSession();
//	    }
//	
	 public CategoryDAOImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	 
	 
	
	@Transactional
	public List<Category> list() {
		@SuppressWarnings("unchecked")
		List<Category> listCat = sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCat;
	}


	@Transactional
	public Category get(String cat_id) {
		//String hql = "from Category where id="+"'"+cat_id+"'";
		
	//	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	/*	Category cat =sessionFactory.getCurrentSession().get(Category.class, cat_id);
		return cat; */
		
		String hql = "from Category where cat_Id=" + "'" + cat_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> listCategory = query.getResultList();
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}

		return null;
	}


	@Transactional
	public void saveOrUpdate(Category category) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}


	@Transactional
	public void delete(String cat_id) {
		Category categoryToDelete = new Category();
		categoryToDelete.setCat_id(cat_id);

		sessionFactory.getCurrentSession().delete(categoryToDelete);
		
	}

}

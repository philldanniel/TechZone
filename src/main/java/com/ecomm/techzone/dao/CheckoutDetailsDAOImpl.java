package com.ecomm.techzone.dao;



import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.techzone.model.CheckoutDetails;


@Repository("checkoutDetailsDAO")
public class CheckoutDetailsDAOImpl implements CheckoutDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
//	 protected Session getSession(){
//	        return sessionFactory.getCurrentSession();
//	    }
//	
	 public CheckoutDetailsDAOImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	 
	 
	
	@Transactional
	public List<CheckoutDetails> list() {
		@SuppressWarnings("unchecked")
		List<CheckoutDetails> listCheckoutDetails = sessionFactory.getCurrentSession().createCriteria(CheckoutDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCheckoutDetails;
	}


	@Transactional
	public CheckoutDetails get(String id) {
		//String hql = "from Category where id="+"'"+cat_id+"'";
		
	//	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	/*	Category cat =sessionFactory.getCurrentSession().get(Category.class, cat_id);
		return cat; */
		
		String hql = "from CheckoutDetails where userid=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CheckoutDetails> listCheckoutDetails = query.getResultList();
		if (listCheckoutDetails != null && !listCheckoutDetails.isEmpty()) {
			return listCheckoutDetails.get(0);
		}

		return null;
	}


	@Transactional
	public void saveOrUpdate(CheckoutDetails checkoutDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(checkoutDetails);
		
		
	}


	@Transactional
	public void delete(String id) {
		CheckoutDetails checkoutDetailsToDelete = new CheckoutDetails();
		checkoutDetailsToDelete.setUserid(id);

		sessionFactory.getCurrentSession().delete(checkoutDetailsToDelete);
		
	}
	
	
	
	

}

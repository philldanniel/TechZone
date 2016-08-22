package com.ecomm.techzone.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.techzone.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
//	 protected Session getSession(){
//	        return sessionFactory.getCurrentSession();
//	    }
//	
	 public CartDAOImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	 
	 
	
	@Transactional
	public List<Cart> list(String id) {
		@SuppressWarnings("unchecked")
		String hql = "from Cart where userId=" + "'" + id + "' and status=" + "'NEW'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> listCart = query.list();
		return listCart;
	}


	@Transactional
	public Cart get(String id,String product) {
		//String hql = "from Category where id="+"'"+cat_id+"'";
		
	//	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	/*	Category cat =sessionFactory.getCurrentSession().get(Category.class, cat_id);
		return cat; */
		
		String hql = "from Cart where userid='" + id + "' and product='"+ product + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> listCart = query.getResultList();
		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}

		return null;
	}

	@Transactional
	public void save(Cart cart) {
		
		sessionFactory.getCurrentSession().save(cart);
	}
	 
	@Transactional
	public void saveOrUpdate(Cart cart) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}
	
	@Transactional
	public void updateCart(String id){
		Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE Cart SET status = 'OLD' WHERE userid = '"+ id + "' and status = 'NEW'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}
	
	@Transactional
	public void delete(int id) {
		Cart cartToDelete = new Cart();
		cartToDelete.setId(id);

		sessionFactory.getCurrentSession().delete(cartToDelete);
		
	}
	
	@Transactional
	public Long getTotalAmount(String id){
		String hql = "select sum(price) from Cart where userId=" + "'" + id + "' and status=" + "'NEW'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long sum = (Long) query.uniqueResult();
		return sum;
	}
}

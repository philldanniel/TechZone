package com.ecomm.techzone.dao;



import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.techzone.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
//	 protected Session getSession(){
//	        return sessionFactory.getCurrentSession();
//	    }
//	
	 public UserDAOImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	 
	 
	
	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}


	@Transactional
	public User get(String id) {
		//String hql = "from Category where id="+"'"+cat_id+"'";
		
	//	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	/*	Category cat =sessionFactory.getCurrentSession().get(Category.class, cat_id);
		return cat; */
		
		String hql = "from Category where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> listUser = query.getResultList();
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}

		return null;
	}


	@Transactional
	public void saveOrUpdate(User user) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}


	@Transactional
	public void delete(String id) {
		User userToDelete = new User();
		userToDelete.setId(id);

		sessionFactory.getCurrentSession().delete(userToDelete);
		
	}

}

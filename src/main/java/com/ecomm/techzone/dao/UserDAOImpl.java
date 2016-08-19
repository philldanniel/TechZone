package com.ecomm.techzone.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.techzone.model.User;
import com.ecomm.techzone.model.UserRole;

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
		
		String hql = "from User where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> listUser = query.getResultList();
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}

		return null;
	}


	@Transactional
	public void saveOrUpdate(User user) {
		Session session = sessionFactory.getCurrentSession();
		String userid = user.getId();
		UserRole role = new UserRole();
		role.setUser_id(userid);
		role.setRole_name("ROLE_USER");
		
		session.saveOrUpdate(role);
		session.saveOrUpdate(user);
		
		
	}


	@Transactional
	public void delete(String id) {
		User userToDelete = new User();
		userToDelete.setId(id);

		sessionFactory.getCurrentSession().delete(userToDelete);
		
	}
	
	
	
	@Transactional
	public boolean isValidUser(String id,String password) {
		String hql = "from User where id='" + id + "' and password='"+ password +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("deprecation")
		List listUser = query.list();
		if (listUser != null && !listUser.isEmpty()) {
			return true;
		}
		else{
			return false;
		}
	}

}

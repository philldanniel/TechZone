package com.ecomm.techzone.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.techzone.model.UserRole;

@Repository("UserRoleDAO")
public class UserRoleDAOImpl implements UserRoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
//	 protected Session getSession(){
//	        return sessionFactory.getCurrentSession();
//	    }
//	
	 public UserRoleDAOImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	 
	 
	
	@Transactional
	public List<UserRole> list() {
		@SuppressWarnings("unchecked")
		List<UserRole> listRole = sessionFactory.getCurrentSession().createCriteria(UserRole.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listRole;
	}


	@Transactional
	public UserRole get(String id) {
		//String hql = "from Category where id="+"'"+cat_id+"'";
		
	//	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	/*	Category cat =sessionFactory.getCurrentSession().get(Category.class, cat_id);
		return cat; */
		Session session=sessionFactory.getCurrentSession();
		Query query =session.createQuery("from UserRole where user_id=?");
		query.setString(0,id);
		
		UserRole user=(UserRole)query.uniqueResult();
		
		/*String hql = "from UserRole where user_id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserRole> listUserRole = query.getResultList();
		if (listUserRole != null && !listUserRole.isEmpty()) {
			return listUserRole.get(0);
		}*/

		return user;
	}


	@Transactional
	public void saveOrUpdate(UserRole userRole) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(userRole);
	}


	@Transactional
	public void delete(String id) {
		UserRole userRoleToDelete = new UserRole();
		userRoleToDelete.setUser_id(id);

		sessionFactory.getCurrentSession().delete(userRoleToDelete);
		
	}

}

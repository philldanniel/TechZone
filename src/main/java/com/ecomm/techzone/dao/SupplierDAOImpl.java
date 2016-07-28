package com.ecomm.techzone.dao;



import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.techzone.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
//	 protected Session getSession(){
//	        return sessionFactory.getCurrentSession();
//	    }
//	
	 public SupplierDAOImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	 
	 
	
	@Transactional
	public List<Supplier> list() {
		@SuppressWarnings("unchecked")
		List<Supplier> listSup = sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listSup;
	}


	@Transactional
	public Supplier get(String sup_id) {
		//String hql = "from Category where id="+"'"+cat_id+"'";
		
	//	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	/*	Category cat =sessionFactory.getCurrentSession().get(Category.class, cat_id);
		return cat; */
		
		String hql = "from Category where sup_Id=" + "'" + sup_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> listSupplier = query.getResultList();
		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}

		return null;
	}


	@Transactional
	public void saveOrUpdate(Supplier supplier) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}


	@Transactional
	public void delete(String sup_id) {
		Supplier supplierToDelete = new Supplier();
		supplierToDelete.setSup_id(sup_id);

		sessionFactory.getCurrentSession().delete(supplierToDelete);
		
	}

}

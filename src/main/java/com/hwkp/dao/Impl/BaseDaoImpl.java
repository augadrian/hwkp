package com.hwkp.dao.Impl;

import com.hwkp.dao.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Autowired
	@Qualifier(value="sessionFactory")
	protected SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	@Override
	public T find(Class<T> clazz,Serializable id) {
		this.sessionFactory.getCurrentSession().flush();
		return (T) this.sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public void delete(T t) {
		this.sessionFactory.getCurrentSession().delete(t);
		this.sessionFactory.getCurrentSession().flush();

	}

	@Override
	public void update(T t) {
		this.sessionFactory.getCurrentSession().flush();
		this.sessionFactory.getCurrentSession().update(t);
	}
	public void saveOrUpdate(T t) {
		this.sessionFactory.getCurrentSession().flush();
		this.sessionFactory.getCurrentSession().saveOrUpdate(t);
	}
	public void save (T t){
		this.sessionFactory.getCurrentSession().flush();
		this.sessionFactory.getCurrentSession().save(t);
	}
}

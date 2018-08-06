package com.yogesh.hibernateTemplate;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly=false)
public class PersonDAO /*extends HibernateDaoSupport*/ {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	/*SessionFactory sessionFactory;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/
	
	public void savePerson(PersonDTO person)
	{
		hibernateTemplate.saveOrUpdate(person);
	}
	
	public List<PersonDTO> getAll()
	{
		DetachedCriteria criteria = DetachedCriteria.forClass(PersonDTO.class);
		return (List<PersonDTO>) hibernateTemplate.findByCriteria(criteria);
	}
	
	public void saveAccount(AccountDTO accountDto) 
	{
		hibernateTemplate.saveOrUpdate(accountDto);
		
		
	}

	public List<?> getPersonFromDB(Class<?> classes) {
		
		return hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(classes).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
	}


}

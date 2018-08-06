package com.yogesh.hibernateTemplate;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class HibernateTemplateMain {

	
	public static void main(String[] arg)
	{
	
		HibernateTemplateMain mainClass = new HibernateTemplateMain();
		
		mainClass.transactionMethod();
		
	}
	
	
	public void printAllprsn(List<PersonDTO> prs)
	{
		
		Iterator itr = prs.iterator();
		for (PersonDTO personDTO : prs)
		{
			System.out.println("Name: "+personDTO.getName()+"\t Mail: "+personDTO.getEmail()+"\t Account: "+personDTO.getAccount().getAccountId());
		}
		
	}
	
	/*@Transactional*/
	public void transactionMethod()
	{
		ApplicationContext ctx=  new ClassPathXmlApplicationContext("config.xml");
		
		PersonDAO personDAO= (PersonDAO) ctx.getBean("personDAO");
		
		System.out.println("Getting data from DB");
		List<PersonDTO> prs= personDAO.getAll();
		
				
		AccountDTO account = new AccountDTO();
		
		
		
		
		PersonDTO p1= new PersonDTO();
		account.setAccountId("ltofjd");
		p1.setName("Nik");
		p1.setEmail("Nik@gmail.com");
		p1.setAccount(account);
		
		System.out.println("Inserting Record.");
		personDAO.saveAccount(account);
		personDAO.savePerson(p1);
		
		/*account.setAccountId("and");
		p1.setName("Yog");
		p1.setEmail("Yog@gmail.com");
		p1.setAccount(account);
		personDAO.saveAccount(account);
		personDAO.savePerson(p1);*/
		
		System.out.println("Record Inserted.");
		
		List prsList = personDAO.getPersonFromDB(PersonDTO.class);
		
		Iterator itr = prsList.listIterator();
		
		PersonDTO prs1;
		
		while(itr.hasNext())
		{
			prs1=(PersonDTO) itr.next();
			System.out.println("Name: "+prs1.getName()+"\t Mail: "+prs1.getEmail()+"\t Account: "+prs1.getAccount().getAccountId());
			//System.out.println("Name: "+prs1.getPerson().getName()+"\t Mail: "+prs1.getPerson().getEmail()+"\t ID: "+prs1.getId()+"\t Account: "+prs1.getAccountId());
		}
	}
	
}

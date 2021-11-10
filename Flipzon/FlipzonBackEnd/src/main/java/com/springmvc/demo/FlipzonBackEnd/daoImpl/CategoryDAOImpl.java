package com.springmvc.demo.FlipzonBackEnd.daoImpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springmvc.demo.FlipzonBackEnd.dao.CategoryDAO;
import com.springmvc.demo.FlipzonBackEnd.dto.Category;

//. Add the @Repository annotation. The @Repository annotation is a marker for class specifying that it fulfills the role of providing access to the data and will be managed by spring framework.

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	//Add some dummy data to a static list for testing purpose which would be replaced later by access to records in database tables.
	//private static List<Category> categories=new ArrayList<>();
	
	//get the sessionfactory
	@Autowired
	private SessionFactory sessionFactory;
	
	// keyword static indicates that the particular member belongs to a type itself, rather than to an instance of that type. This means that only one instance of that static member is created which is shared across all instances of the class.
//	static {
//		Category category=new Category();
//		//adding first category
//		category.setId(1);
//		category.setName("Television");
//		category.setDescription("Description of television");
//		category.setImageURL("CAT_1.png");
//		categories.add(category);	
//		
//		category=new Category();
//		//adding second category
//		category.setId(2);
//		category.setName("Mobile");
//		category.setDescription("Description of mobile");
//		category.setImageURL("CAT_2.png");
//		categories.add(category);	
//		
//		category=new Category();
//		//adding third category
//		category.setId(3);
//		category.setName("Laptop");
//		category.setDescription("Description of laptop");
//		category.setImageURL("CAT_3.png");
//		categories.add(category);	
//	}
	
	@Override
	public List<Category> list() {
		//return categories;
		String selectActiveCategory = "FROM Category WHERE active = :active";
		//String selectActiveCategory = "FROM Category";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
	query.setParameter("active", true);
						
		return query.getResultList();
	
	}

	@Override
	public Category get(int id) {
		//enhanced for loop
//		for(Category category:categories) {
//			if(category.getId() ==id)
//				return category;
//		}
//		return null;
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	//Modify the DAO implementing class to add a new category to the database table using hibernate
	@Override
	@Transactional
	public boolean add(Category category) {
		try {
			//add the category to database table
			//The main runtime interface between a Java application and Hibernate. This is the central API class abstracting the notion of a persistence service.
			//The lifecycle of a Session is bounded by the beginning and end of a logical transaction. (Long transactions might span several database transactions.)
			//The main function of the Session is to offer create, read and delete operations for instances of mapped entity classes. Instances may exist in one of three states:
			//transient: never persistent, not associated with any Session
			//persistent: associated with a unique Session
			//detached: previously persistent, not associated with any Session
			//Transient instances may be made persistent by calling save(), persist() or saveOrUpdate(). Persistent instances may be made transient by calling delete(). Any instance returned by a get() or load() method is persistent. Detached instances may be made persistent by calling update(), saveOrUpdate(), lock() or replicate(). The state of a transient or detached instance may also be made persistent as a new persistent instance by calling merge().
			//save() and persist() result in an SQL INSERT, delete() in an SQL DELETE and update() or merge() in an SQL UPDATE. Changes to persistent instances are detected at flush time and also result in an SQL UPDATE. saveOrUpdate() and replicate() result in either an INSERT or an UPDATE.

			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		category.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

}

package dt.b190043.demoproject.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dt.b190043.demoproject.model.User;

@Component
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		    return false;
		}
	}

	@Override
	public boolean update(User user) {
		try {
				 
				sessionFactory.getCurrentSession().update(user);
				return true;
			   
		}catch(Exception e)
		{
			e.printStackTrace();
		    return false;
		}
	}

	@Override
	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}catch(Exception e)
		{
		    return false;
		}
	}

	@Override
	public User get(int userId) {
		try {
			return sessionFactory.getCurrentSession().get(User.class,userId);
			
		}catch(Exception e)
		{
		    return null;
		}
	}

	@Override
	public User get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("From User where email=:email",User.class)
			.setParameter("email", email)
			.getSingleResult();
		}catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public User login(String email, String password) {
		// TODO Auto-generated method stub
		try {
		   return	sessionFactory.getCurrentSession().createQuery("From User where email=:email and password=:password",User.class)
			.setParameter("email", email)
			.setParameter("password", password)
			.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}

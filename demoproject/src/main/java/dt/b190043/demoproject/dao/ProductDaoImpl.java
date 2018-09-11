package dt.b190043.demoproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dt.b190043.demoproject.model.Product;
import javassist.compiler.ast.Symbol;

@Component
@Transactional
public class ProductDaoImpl<T extends Product> implements ProductDao<T> {


	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addProduct(T t) {
		try {
			sessionFactory.getCurrentSession().save(t);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean update(T t) {
		try {
			sessionFactory.getCurrentSession().update(t);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(t);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	
	@Override
	public <T extends Product> T get(int productId) {
		try {
			 return (T)sessionFactory.getCurrentSession().createQuery("From Product where productId=:pid")
					 .setParameter("pid", productId)
					 .getSingleResult();
			 
		
		}catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public List<T> getProducts(float min, float max, T t) {
		// TODO Auto-generated method stub
		return null;
	}

}

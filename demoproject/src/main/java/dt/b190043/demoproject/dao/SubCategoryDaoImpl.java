package dt.b190043.demoproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dt.b190043.demoproject.model.SubCategory;
@Component
@Transactional
public class SubCategoryDaoImpl implements SubCategoryDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SubCategory> getAll() {
		try {
			return sessionFactory.getCurrentSession().createQuery("From SubCategory",SubCategory.class).getResultList();
		} catch (Exception e) {
			
			return null;
		}
	}

	@Override
	public SubCategory get(long subCategoryId) {
		try {
			return sessionFactory.getCurrentSession().createQuery("From SubCategory where subCatId=:id",SubCategory.class)
					.setParameter("id", subCategoryId)
					.getSingleResult();
		} catch (Exception e) {
			
			return null;
		}
	}
	

}

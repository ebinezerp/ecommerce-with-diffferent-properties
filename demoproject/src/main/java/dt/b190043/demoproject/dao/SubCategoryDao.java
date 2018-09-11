package dt.b190043.demoproject.dao;

import java.util.List;

import dt.b190043.demoproject.model.SubCategory;

public interface SubCategoryDao {
	
	public List<SubCategory> getAll();
	public SubCategory get(long subCategoryId);

}

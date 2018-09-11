package dt.b190043.demoproject.dao;

import java.util.List;

import dt.b190043.demoproject.model.Product;

public interface ProductDao<T extends Product> {

	 public boolean addProduct(T t);
	 public boolean update(T t);
	 public boolean delete(T t);
	 public <T extends Product> T get(int productId);
	 public List<T> getProducts(float min,float max,T t);
}

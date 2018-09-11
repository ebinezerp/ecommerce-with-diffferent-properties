package dt.b190043.demoproject.factory;

import dt.b190043.demoproject.model.Book;
import dt.b190043.demoproject.model.Mobile;
import dt.b190043.demoproject.model.Product;

public abstract class ProductFactory {
	
	
	


	public static Mobile getMobile()
	{
		return new Mobile();
	}
	
	public static Book getBook()
	{
		return new Book();
	}
	
	
	
}

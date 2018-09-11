package dt.b190043.demoproject;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dt.b190043.demoproject.config.HibernateConfiguration;
import dt.b190043.demoproject.dao.ProductDao;
import dt.b190043.demoproject.dao.UserDao;
import dt.b190043.demoproject.factory.ProductFactory;
import dt.b190043.demoproject.model.Author;
import dt.b190043.demoproject.model.Book;
import dt.b190043.demoproject.model.Mobile;
import dt.b190043.demoproject.model.Product;
import dt.b190043.demoproject.model.User;

@SpringJUnitConfig(classes= {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductTest {

	@Autowired
	private User user;

	@Autowired
	private UserDao userDao;
	@Autowired
	private ProductDao<Product> productDao;
	
	private Mobile mobile;
	
	private Book book;
	
	@Before
	public void setUp()
	{
		user=new User();
		user = new User();
		user.setUsername("ebinezer");
		user.setEmail("ebinezer@gmail.com");
		user.setMobile("123456789");
		user.setPassword("ebinezer");
		user.setRole("Seller");
		userDao.addUser(user);
	}
	
	
	@After
	public void tearDown()
	{
		
		if(mobile!=null && productDao.get(mobile.getProductId())!=null)
		{
			productDao.delete(mobile);
		}
		
		if(book!=null && productDao.get(book.getProductId())!=null)
		{
			productDao.delete(book);
		}
		
		if(userDao.get(user.getUserId())!=null)
		{
			userDao.delete(user);
		}
		
	}
	
	
	@Test
	public void testAddMobileProduct()
	{
		mobile=ProductFactory.getMobile();
		mobile.setBrand("Samsung");
		mobile.setMrp(20000);
		mobile.setUser(user);
		
		assertEquals("testAddProduct failed",true,productDao.addProduct(mobile));
	}
	
	@Test
	public void testUpdateMobileProduct()
	{
		mobile=ProductFactory.getMobile();
		mobile.setBrand("Samsung");
		mobile.setMrp(20000);
		mobile.setUser(user);
		
		productDao.addProduct(mobile);
		
		mobile=productDao.get(mobile.getProductId());
		
		mobile.setModel("J7");
		
		assertEquals("testUpdateMobileProduct failed", true,productDao.update(mobile));
	}
	
	
	/*@Test
	public void testAddBookProduct()
	{
		book=ProductFactory.getBook();
		
		book.setBrand("Love Story");
		Set<Author> authors=new HashSet<Author>();
		Author author=new Author();
		author.setAuthorName("abcd");
		authors.add(author);
		book.setAuthors(authors);
		book.setUser(user);
		assertEquals("testAddBookProduct failed",true,productDao.addProduct(book));
	}*/

	
	
	
}

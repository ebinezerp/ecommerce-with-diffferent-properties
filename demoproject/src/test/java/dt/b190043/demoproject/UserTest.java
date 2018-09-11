package dt.b190043.demoproject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dt.b190043.demoproject.config.HibernateConfiguration;
import dt.b190043.demoproject.dao.UserDao;
import dt.b190043.demoproject.model.User;

@SpringJUnitConfig(classes = { HibernateConfiguration.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

	@Autowired
	private UserDao userDao;

	@Autowired
	private User user;

	@Before
	public void setUp() {
		user = new User();
		user.setUsername("ebinezer");
		user.setEmail("ebinezer@gmail.com");
		user.setMobile("123456789");
		user.setPassword("ebinezer");
		user.setRole("Seller");
	}

	@After
	public void tearDown() {
		if (userDao.get(user.getUserId()) != null) {
			userDao.delete(user);
		}
	}

	@Test
	public void testAddUser1() {
		assertEquals("testAddUser1 failed", true, userDao.addUser(user));
	}

	@Test
	public void testAddUser2() {
		user.setEmail("madhu@gmail.com");
		assertEquals("testAddUser2 failed", true, userDao.addUser(user));
	}
	
	@Test(expected=Exception.class)
	public void testAddUserFailure()
	{
		userDao.addUser(user);
		assertEquals("testAddUser2 failed", false, userDao.addUser(user));
	}
	
	@Test
	public void testUpdateUser()
	{	
		userDao.addUser(user);
		User user1=userDao.get(user.getUserId());
		user1.setEmail("sudhakar@gmail.com");
		assertEquals("testUpdateUser failed",true,userDao.update(user1));
	}
	
	@Test(expected=Exception.class)
	public void testUpdateUserFailure()
	{
		assertEquals("testUpdateUserFailure failed",false,userDao.update(user));
	}
	
	@Test
	public void testGetUser()
	{
		userDao.addUser(user);
		assertEquals("testGetUser Failed",user,userDao.get(user.getUserId()));
	}
	
	@Test
	public void testGetUserFailure()
	{
		assertNull(userDao.get(20));
	}
	
	
	
	
	
	

}

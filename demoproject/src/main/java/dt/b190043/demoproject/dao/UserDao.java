package dt.b190043.demoproject.dao;

import dt.b190043.demoproject.model.User;

public interface UserDao {
	
	public boolean addUser(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public User get(int userId);
	public User get(String username);
	public User getUserByEmail(String email);
	public User login(String email,String password);

}

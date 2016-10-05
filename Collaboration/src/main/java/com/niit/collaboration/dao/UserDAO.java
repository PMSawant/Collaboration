package com.niit.collaboration.dao;

import com.niit.collaboration.model.User;

public interface UserDAO {
	
	public void saveorUpdate(User user);
	
	public void delete (String mailid);
	
	public User get(String mailid);

}

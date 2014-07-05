package com.infonal.service;

import java.util.ArrayList;

import com.infonal.model.User;

//The interface used for CRUD operations.The prototype, which is defined as insert-update-delete-list of methods.

public interface MainPageService {
	
	public boolean insertUser(User myInsertedUser);
	
	public boolean updateUser(User user);
	
	public ArrayList<User> getAllUsers();
	
	public boolean removeUser(String id);

}
